package com.qf.controller;

import com.qf.Utils.UploadUtils;
import com.qf.domain.AgriculturePicture;
import com.qf.service.impl.AgriculturePictureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by lucifer on 2019.7.24.0024.
 */
@Controller
@RequestMapping("/pic")
public class ImgController {

    @Autowired
    private AgriculturePictureServiceImpl agriculturePictureService;



    @ResponseBody
    @RequestMapping(value = "/updateImg", method = RequestMethod.POST)
    public int updateImg(@RequestParam("uploadFile") MultipartFile uploadFile, AgriculturePicture agriculturePicture) {
        String PictureUrl=null;
        if (uploadFile!=null&&!uploadFile.getOriginalFilename().equals("")){
            UploadUtils uploadUtils = new UploadUtils();
            PictureUrl = uploadUtils.savePic(uploadFile);
            agriculturePicture.setPictureUrl(PictureUrl);
        }
        int i = agriculturePictureService.add(agriculturePicture);
        return i>0?1:0;
    }


   /* @ResponseBody
    @RequestMapping("/loginAll")
    public int login(User user, MultipartFile uploadFile, HttpServletRequest request) {
        int res = 0;
        System.out.println(user);
        String path = request.getServletContext().getRealPath("/xiazai");
        System.out.println(path);

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!uploadFile.isEmpty()) {
            try {
                uploadFile.transferTo(new File(path + "/" + uploadFile.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if ("zf".equals(user.getName()) && "123".equals(user.getPass())) {
            return res = 1;
        }
        return res;
    }*/
}
