package com.shushi.spring.blog.controllers;

import com.shushi.spring.blog.common.CommonUtils;
import com.shushi.spring.blog.common.GoogleUtils;
import com.shushi.spring.blog.common.RestFB;
import com.shushi.spring.blog.models.BlogDmTinhThanhEntity;
import com.shushi.spring.blog.models.GooglePojo;
import com.shushi.spring.blog.models.Product;
import com.shushi.spring.blog.services.BlogDmTinhThanhService;
import com.shushi.spring.blog.services.ProductService;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author anhbt 6/29/2018
 * com.shushi.spring.blog.controllers
 */
@Controller
public class HomeController {
    @Autowired
    BlogDmTinhThanhService blogDmTinhThanhService;
    @Autowired
    ProductService productService;
    @Autowired
    private RestFB restFb;
    @Autowired
    private GoogleUtils googleUtils;

    @RequestMapping(value = {"/{id}","/"}, method = RequestMethod.GET)
    public String index(@PathVariable("id") Optional<String> id, Model model, Principal principal) {
        List<BlogDmTinhThanhEntity> list = blogDmTinhThanhService.findAll();
        model.addAttribute("dmTinhThanh", list);
        if(id.isPresent()){
            System.out.println(id);
            model.addAttribute("idFb", id);
        }
//        OAuth2Authentication c= (OAuth2Authentication) principal;
//        LinkedHashMap<String,String> d= (LinkedHashMap<String, String>) c.getUserAuthentication().getDetails();

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        org.springframework.security.core.userdetails.User u= (org.springframework.security.core.userdetails.User) auth.getPrincipal();
//        u.getAuthorities().parallelStream().forEach((x)-> System.out.println(x.getAuthority()));
        return "index";
    }

    @RequestMapping(value = "/tinhThanh/view/{id}", method = RequestMethod.GET)
    public String tinhThanhDetail(@PathVariable("id") Long id, Model model) {
        BlogDmTinhThanhEntity blogDmTinhThanhEntity = blogDmTinhThanhService.findOne(id);
        model.addAttribute("tinhThanh", blogDmTinhThanhEntity);
        return "fragments/tinhThanhDetails";
    }

    @RequestMapping(value = "/myexcel", method = RequestMethod.GET)
    public String getMyData(Model model) {
        List<BlogDmTinhThanhEntity> list = blogDmTinhThanhService.findAll();
        model.addAttribute("dmTinhThanhs", list);
        return "forexView";
    }
    @RequestMapping(value = "/myPdf", method = RequestMethod.GET)
    public String getPdfView(){
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
        request.getSession().setAttribute("productList",null);
        if(model.asMap().get("success") != null)
            redirectAttributes.addFlashAttribute("success",model.asMap().get("success").toString());
        return "redirect:/products/page/1";
    }

//    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/products/page/{pageNumber}", method = RequestMethod.GET)
    public String showPagedProductPage(HttpServletRequest request,@PathVariable("pageNumber") Integer pageNumber,Model model) {
        PagedListHolder<?> pagedListHolder= (PagedListHolder<?>) request.getSession().getAttribute("productList");
        if(pagedListHolder==null){
            pagedListHolder=new PagedListHolder<>(productService.findAll());
            pagedListHolder.setPageSize(7);
        }
        else {
            final int gotoPage=pageNumber-1;
            if(gotoPage<=pagedListHolder.getPageCount()&& gotoPage>=0){
                pagedListHolder.setPage(gotoPage);
            }
        }
        request.getSession().setAttribute("productList",pagedListHolder);
        int current=pagedListHolder.getPage()+1;
        System.out.println("current:"+current);
        int begin=Math.max(1,current-14);
        System.out.println("begin:"+begin);
        int end=Math.min(begin+5,pagedListHolder.getPageCount());
        System.out.println("end:"+end);
        int totalPage=pagedListHolder.getPageCount();
        System.out.println("totalPage:"+totalPage);
        String baseUrl="/products/page/";
        model.addAttribute("beginIndex",begin);
        model.addAttribute("endIndex",end);
        model.addAttribute("currentIndex",current);
        model.addAttribute("totalPageCount",totalPage);
        model.addAttribute("baseUrl",baseUrl);
        model.addAttribute("products",pagedListHolder);
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

    @RequestMapping("/user")
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

    @RequestMapping(value = "/google", method = RequestMethod.GET)
    public ModelAndView methodGoogle() {
        return new ModelAndView("redirect:" + "https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8989/login-google&response_type=code&client_id=698563595353-k7llkc2kob0e56s668197b8pd36q30aq.apps.googleusercontent.com&approval_prompt=force");
    }

    @RequestMapping(value = "/facebook", method = RequestMethod.GET)
    public ModelAndView methodFacebook() {
        return new ModelAndView("redirect:" + "https://www.facebook.com/dialog/oauth?client_id=303733256835975&redirect_uri=http://localhost:8989/login-facebook");
    }
}
