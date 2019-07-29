package com.qf.controller;

import com.qf.Utils.UploadUtils;
import com.qf.domain.AgriculturePicture;
import com.qf.service.impl.AgriculturePictureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lucifer on 2019.7.24.0024.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private AgriculturePictureServiceImpl agriculturePictureService;

    @ResponseBody
    @RequestMapping(value = "/updateImg", method = RequestMethod.POST)
    public int updateImg(@RequestParam("uploadFile") MultipartFile uploadFile, AgriculturePicture agriculturePicture,Integer productId) {
        String PictureUrl=null;
        if (uploadFile!=null&&!uploadFile.getOriginalFilename().equals("")){
            UploadUtils uploadUtils = new UploadUtils();
            PictureUrl = uploadUtils.savePic(uploadFile);
            agriculturePicture.setPictureUrl(PictureUrl);
        }
        int i = agriculturePictureService.add(agriculturePicture);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("proid",productId);
        map.put("picid",agriculturePicture.getPictureId());
        int p = agriculturePictureService.addpp(map);

        return p>0?1:0;
    }


    @RequestMapping("/loadAll")
    public String loadAll(@RequestParam(required = false,defaultValue ="1" )  int pages,
                              @RequestParam(required = false,defaultValue = "10") int rows,Model model) {

        int maxpage = agriculturePictureService.countRows(rows);

        if (pages < 1) {
            pages = 1;
        }
        if (pages > maxpage) {
            pages = maxpage;
        }
        List<AgriculturePicture> list = agriculturePictureService.loadAll(pages, rows);
        model.addAttribute("maxpage", maxpage);
        model.addAttribute("pages", pages);
        model.addAttribute("list", list);
        System.out.println(list);
        return "pictureIndex";

    }
    // 删除
    @RequestMapping("/delete")
    public String delete(int pictureId){
        int p=agriculturePictureService.deletepp(pictureId);
        int i = agriculturePictureService.deleteap(pictureId);

        return p>0&&i>0?"redirect:loadAll":"error";
    }

    // 批量删除用户
    @RequestMapping("/deleteBatch")
    @ResponseBody
    public int deleteBatch(String uidList){
        System.out.println("deleteBatch+++++++++++++++");
        List<Integer> list=new ArrayList<>();
        String[] s = uidList.split("-");
        System.out.println(s.toString());
        for(String id:s){
            int ids=Integer.parseInt(id);
            list.add(ids);
        }
        int i = agriculturePictureService.deleteBatch(list);
        System.out.println(i);
        return i==list.size()?1:0;
    }

}
