package com.shushi.spring.blog.controllers;

import com.shushi.spring.blog.common.CommonUtils;
import com.shushi.spring.blog.common.GoogleUtils;
import com.shushi.spring.blog.common.RestFB;
import com.shushi.spring.blog.common.SSOUtils;
import com.shushi.spring.blog.errors.ApiFieldError;
import com.shushi.spring.blog.errors.ApiGlobalError;
import com.shushi.spring.blog.models.*;
import com.shushi.spring.blog.models.sso.AuthenticationSuccess;
import com.shushi.spring.blog.repositorys.SpringSessionRepository;
import com.shushi.spring.blog.repositorys.ThietBiRepository;
import com.shushi.spring.blog.results.ResultPercentSystem;
import com.shushi.spring.blog.services.BlogDmTinhThanhService;
import com.shushi.spring.blog.services.ProductService;
import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.poi.openxml4j.opc.PackagePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


/**
 * @author anhbt 6/29/2018
 * com.shushi.spring.blog.controllers
 */
@Controller
public class HomeController {
    Logger logger = LogManager.getLogger(HomeController.class);
    @Autowired
    BlogDmTinhThanhService blogDmTinhThanhService;
    @Autowired
    ProductService productService;
    @Autowired
    private RestFB restFb;
    @Autowired
    private GoogleUtils googleUtils;
    @Autowired
    private SSOUtils ssoUtils;
    @Autowired
    ThietBiRepository thietBiRepository;
//    @Autowired
//    SessionRepository sessionFactory;
    @Autowired
    RedisOperationsSessionRepository redisOperationsSessionRepository;
    @Autowired
    SpringSessionRepository springSessionRepository;
    @RequestMapping(value = {"/{id}", "/"}, method = RequestMethod.GET)
    public String index(@PathVariable("id") Optional<String> id, Model model, Principal principal,HttpServletRequest request,HttpServletResponse response) {
//        if(checkLogout(request,response)){
//            return "redirect:/";
//        }else {
//            Session y= sessionFactory.findById(request.getSession().getId());
            List<BlogDmTinhThanhEntity> list = blogDmTinhThanhService.findAll();
            model.addAttribute("dmTinhThanh", list);
            if (id.isPresent()&& !id.toString().equals("index")) {
                System.out.println(id);
                model.addAttribute("idFb", id);
            }
//        OAuth2Authentication c= (OAuth2Authentication) principal;
//        LinkedHashMap<String,String> d= (LinkedHashMap<String, String>) c.getUserAuthentication().getDetails();

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        org.springframework.security.core.userdetails.User u= (org.springframework.security.core.userdetails.User) auth.getPrincipal();
//        u.getAuthorities().parallelStream().forEach((x)-> System.out.println(x.getAuthority()));
            return "index";
//        }
    }

    private boolean checkLogout(HttpServletRequest request,HttpServletResponse response){
        String sess=request.getSession().getId();
//        if(MyHttpSessionEventPublisher.getHttpSession(sess)==null){
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            if (auth != null) {
//                new SecurityContextLogoutHandler().logout(request, response, auth);
//            }
            return true;
//        }else return false;
    }
    @RequestMapping(value = "/tinhThanh/view/{id}", method = RequestMethod.GET)
    public String tinhThanhDetail(@PathVariable("id") Long id, Model model,HttpServletRequest request,HttpServletResponse response) {
        if(checkLogout(request,response)){
            return "redirect:/";
        }
        else {
            BlogDmTinhThanhEntity blogDmTinhThanhEntity = blogDmTinhThanhService.findOne(id);
            model.addAttribute("tinhThanh", blogDmTinhThanhEntity);
            return "fragments/tinhThanhDetails";
        }
    }

    @RequestMapping(value = "/myexcel", method = RequestMethod.GET)
    public String getMyData(Model model) {
        List<BlogDmTinhThanhEntity> list = blogDmTinhThanhService.findAll();
        model.addAttribute("dmTinhThanhs", list);
        return "forexView";
    }

    @RequestMapping(value = "/myPdf", method = RequestMethod.GET)
    public String getPdfView(Model model) {
        List<Product> courses = new ArrayList<>();
        courses.add(new Product(1,"Phông Trơn1","BTA01",100,"Cái","lamp",0,"Đen;Đỏ","Chất hịn",10,79000));
        courses.add(new Product(2,"Phông Gió2","BTA02",100,"Cái","tulips",10,"Đen;Đỏ","Chất bình thường",10,129000));
        courses.add(new Product(3,"Khoác Trơn3","BTA03",100,"Cái","wheel",0,"Đen;Trắng","Chất hịn",130,79000));
        model.addAttribute("courses",courses);
        return "reportView";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "fragments/home";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String geProductPage(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
//        List<Product> list = productService.findAll();
//        model.addAttribute("products", list);
//        System.out.println("Products:" + list.size());
        HttpSession session=request.getSession();
        session.setAttribute("productList", null);
        if (model.asMap().get("success") != null)
            redirectAttributes.addFlashAttribute("success", model.asMap().get("success").toString());
        return "redirect:/products/page/1";
    }

    //    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/products/page/{pageNumber}", method = RequestMethod.GET)
    public String showPagedProductPage(HttpServletRequest request, @PathVariable("pageNumber") Integer pageNumber, Model model) {
        PagedListHolder<?> pagedListHolder = (PagedListHolder<?>) request.getSession().getAttribute("productList");
        if (pagedListHolder == null) {
            pagedListHolder = new PagedListHolder<>(productService.findAll());
            pagedListHolder.setPageSize(7);
        } else {
            final int gotoPage = pageNumber - 1;
            if (gotoPage <= pagedListHolder.getPageCount() && gotoPage >= 0) {
                pagedListHolder.setPage(gotoPage);
            }
        }
        HttpSession session=request.getSession();
        request.getSession().setAttribute("productList", pagedListHolder);
        int current = pagedListHolder.getPage() + 1;
        System.out.println("current:" + current);
        int begin = Math.max(1, current - 14);
        System.out.println("begin:" + begin);
        int end = Math.min(begin + 5, pagedListHolder.getPageCount());
        System.out.println("end:" + end);
        int totalPage = pagedListHolder.getPageCount();
        System.out.println("totalPage:" + totalPage);
        String baseUrl = "/products/page/";
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPage);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("products", pagedListHolder);
        return "fragments/product";
    }

    @RequestMapping(value = "/products/view/{id}", method = RequestMethod.GET)
    public String geProductDetailsPage(@PathVariable("id") long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "fragments/productDetails";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Principal principal) {

        return principal == null ? "login" : "redirect:/";
    }

    @RequestMapping(value = "/403")
    public String accessDenied() {
        return "403";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    @ResponseBody
    public Principal user(Principal principal) {
        System.out.println(principal.getName());
        return principal;
    }

    @RequestMapping("/login-facebook")
    public String loginFacebook(HttpServletRequest request) throws ClientProtocolException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            return "redirect:/login?facebook=error";
        }
        String accessToken = restFb.getToken(code);

        com.restfb.types.User user = restFb.getUserInfo(accessToken);
        UserDetails userDetail = restFb.buildUser(user);
        CommonUtils.showString(user.getEmail(), user.getFirstName(), user.getName(), user.getId());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/" + user.getId();
    }

    @RequestMapping("/login-google")
    public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            return "redirect:/login?google=error";
        }
        String accessToken = googleUtils.getToken(code);

        GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
        UserDetails userDetail = googleUtils.buildUser(googlePojo);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/";
    }
    @RequestMapping("/login-sso")
    public String loginSSO(HttpServletRequest request) throws ClientProtocolException, IOException {
        String code = request.getParameter("ticket");

        if (code == null || code.isEmpty()) {
            return "redirect:/login?google=error";
        }
        AuthenticationSuccess userSSO=ssoUtils.getUserInfo(code);
        HttpSession session=request.getSession();
        logger.info(session.getId());
        SpringSessionEntity temp= springSessionRepository.getOne(session.getId());
        temp.setSessionId(code);
        springSessionRepository.save(temp);
        UserDetails userDetail = ssoUtils.buildUser(userSSO);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/";
    }
    @RequestMapping(value = "/google", method = RequestMethod.GET)
    public ModelAndView methodGoogle() {
        return new ModelAndView("redirect:" + "https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8989/login-google&response_type=code&client_id=698563595353-k7llkc2kob0e56s668197b8pd36q30aq.apps.googleusercontent.com&approval_prompt=force");
    }
    @RequestMapping(value = "/sso", method = RequestMethod.GET)
    public ModelAndView methodSSO() {
        return new ModelAndView("redirect:" + "https://local.baohiemxahoi.gov.vn:8443/login?service=http://anhshushi.com:8989/login-sso");
    }

    @RequestMapping(value = "/facebook", method = RequestMethod.GET)
    public ModelAndView methodFacebook() {
        return new ModelAndView("redirect:" + "https://www.facebook.com/dialog/oauth?client_id=303733256835975&redirect_uri=http://localhost:8989/login-facebook");
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult errors, Model model) {
        logger.info("Vo day");
        System.out.println(student.toString());
        if (!errors.hasErrors()) {
            // get mock objects
            List<Student> students = CommonUtils.buildStudents();
            // add current student
            students.add(student);
            model.addAttribute("students", students);
        }else {
            List<ApiFieldError> apiFieldErrors = errors.getAllErrors()
                    .stream()
                    .map(x -> {
                        System.out.println(x.getObjectName()+ ""+ x.getDefaultMessage());
                        return new ApiFieldError(
                                x.getObjectName(), "", x.getDefaultMessage());
                    })
                    .collect(Collectors.toList());
            model.addAttribute("abc","abc");
            model.addAttribute("errors", apiFieldErrors);
        }

        List<ApiGlobalError> apiGlobalErrors = errors
                .getGlobalErrors()
                .stream()
                .map(globalError -> new ApiGlobalError(
                        globalError.getCode())
                )
                .collect(toList());
        List<ObjectError>t=errors.getAllErrors();
        t.forEach((x) -> {
            System.out.println(x.getDefaultMessage());
            System.out.println(x.getObjectName());
                } );

        return ((errors.hasErrors()) ? "index" : "redirect:/user");
    }
    @RequestMapping(value = "/user/chart",method = RequestMethod.GET)
    public String chart(Model model) {
        List<ListTest> t=thietBiRepository.getPercentProc();
        System.out.println(t.size());
        List<ListByXuatXu> k=thietBiRepository.getPercentXuatXuProc();
        System.out.println(k.size());
        k.forEach(x-> System.out.println(x.toString()));
        List<ResultPercentSystem> temp= t.stream().map(x -> new ResultPercentSystem(x.getPercent(),x.getNhaSanXuat())).collect(toList());
        List<ResultPercentSystem> temp2= k.stream().map(x -> new ResultPercentSystem(x.getPercent(),x.getXuatXu())).collect(toList());
        temp2.forEach(x -> System.out.println(x.toString()));
        model.addAttribute("tuan",temp);
        model.addAttribute("temp2",temp2);
        return "chart";
    }
    @RequestMapping(value = {"/test/home"},method = RequestMethod.GET)
    public String testHome(@RequestParam Map<String,String> allRequestParams,@RequestParam("numbers_page") Optional<String> numbers_page,@RequestParam("per_page") Optional<String> perPage,Model model){
        int pp=10;
        if(perPage.isPresent()){
            String per=perPage.get();
            pp=Integer.parseInt(per);
        }

        if(numbers_page.isPresent()){
            String k=numbers_page.get();
            Sort sort=new Sort(Sort.Direction.DESC,"maTinhThanh");
            Pageable pageable= PageRequest.of(Integer.parseInt(k)-1,pp,sort);

            Page<BlogDmTinhThanhEntity> page=blogDmTinhThanhService.findPage(pageable);
            model.addAttribute("listElement",page.getTotalPages());
            model.addAttribute("content",page.getContent());
            model.addAttribute("currentIndex",Integer.parseInt(k));
            model.addAttribute("isFirst",page.isFirst());
            model.addAttribute("isLast",page.isLast());
            model.addAttribute("hasNext",page.hasNext());
            model.addAttribute("hasPrevious",page.hasPrevious());
            model.addAttribute("perPage",pp);
        }else {
            Sort sort=new Sort(Sort.Direction.DESC,"maTinhThanh");
            Pageable pageable= PageRequest.of(0,pp,sort);
            Page<BlogDmTinhThanhEntity> page=blogDmTinhThanhService.findPage(pageable);
            model.addAttribute("listElement",page.getTotalPages());
            model.addAttribute("content",page.getContent());
            model.addAttribute("currentIndex",1);
            model.addAttribute("isFirst",page.isFirst());
            model.addAttribute("isLast",page.isLast());
            model.addAttribute("hasNext",page.hasNext());
            model.addAttribute("hasPrevious",page.hasPrevious());
            model.addAttribute("totalElement",page.getTotalElements());
            model.addAttribute("perPage",pp);
        }
        return "user/home";
    }

    @RequestMapping(value = "/sso/logout",method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void postLogout(@RequestParam("logoutRequest")String logoutRequest){
//        MyHttpSessionEventPublisher.deleteHttpSession(sess);
        String ticket=ssoUtils.getTicketLogout(logoutRequest);
        logger.info(ticket);
        SpringSessionEntity temp=springSessionRepository.findBySessionId(ticket);
        if(temp!=null) {
            redisOperationsSessionRepository.deleteById(temp.getPrimaryId());

            redisOperationsSessionRepository.cleanupExpiredSessions();
        }

    }
    @PostMapping("/test/home/send")
    public String test(@RequestParam Map<String,String> allRequestParams,
    @RequestParam String numbers,
    Model model){
        System.out.println(numbers);
//        model.addAttribute("numbers_page",numbers);
        return "redirect:/test/home/"+numbers;
    }
    @RequestMapping(value = "/test/home/selected",method = RequestMethod.POST)
    public String testSelected(@RequestParam("select_val")String val){
        System.out.println(val);
        return "redirect:/test/home?numbers_page=1&per_page="+val ;
    }
    @RequestMapping(value = "/test/home/search",method = RequestMethod.POST)
    public String testSearch(@RequestParam("search")String search,@RequestParam("numbers_page") Optional<String> numbers_page,@RequestParam("per_page") Optional<String> perPage,Model model){
        int pp=10;
        if(perPage.isPresent()){
            String per=perPage.get();
            pp=Integer.parseInt(per);
        }

        if(numbers_page.isPresent()){
            String k=numbers_page.get();
            Sort sort=new Sort(Sort.Direction.DESC,"maTinhThanh");
            Pageable pageable= PageRequest.of(Integer.parseInt(k)-1,pp,sort);

            Page<BlogDmTinhThanhEntity> page=blogDmTinhThanhService.findBySearch(search,pageable);
            model.addAttribute("listElement",page.getTotalPages());
            model.addAttribute("content",page.getContent());
            model.addAttribute("currentIndex",Integer.parseInt(k));
            model.addAttribute("isFirst",page.isFirst());
            model.addAttribute("isLast",page.isLast());
            model.addAttribute("hasNext",page.hasNext());
            model.addAttribute("hasPrevious",page.hasPrevious());
            model.addAttribute("perPage",pp);
        }else {
            Sort sort=new Sort(Sort.Direction.DESC,"maTinhThanh");
            Pageable pageable= PageRequest.of(0,pp,sort);
            Page<BlogDmTinhThanhEntity> page=blogDmTinhThanhService.findBySearch(search,pageable);
            model.addAttribute("listElement",page.getTotalPages());
            model.addAttribute("content",page.getContent());
            model.addAttribute("currentIndex",1);
            model.addAttribute("isFirst",page.isFirst());
            model.addAttribute("isLast",page.isLast());
            model.addAttribute("hasNext",page.hasNext());
            model.addAttribute("hasPrevious",page.hasPrevious());
            model.addAttribute("totalElement",page.getTotalElements());
            model.addAttribute("perPage",pp);
        }
        return "user/home";
    }
}
