package com.shushi.spring.blog.controllers;
import com.shushi.spring.blog.models.MyFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author anhbt 8/2/2018
 * com.shushi.spring.blog.controllers
 */
@Controller
public class FileUploadController {

    @RequestMapping("/file")
    public String index(Model model) {
        model.addAttribute("myFile", new MyFile());
        return "upload/upload";
    }
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(MyFile myFile, Model model) {
        model.addAttribute("message", "Upload success");
        model.addAttribute("description", myFile.getDescription());
        try {
            MultipartFile multipartFile = myFile.getMultipartFile();
            String fileName = multipartFile.getOriginalFilename();
            File file = new File(this.getFolderUpload(), fileName);
            multipartFile.transferTo(file);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Upload failed");
        }
        return "upload/uploadStatus";
    }
    public File getFolderUpload() {
        File folderUpload = new File("E:\\data\\Uploads");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}
