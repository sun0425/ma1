package com.qf.controller;

import com.qf.Utils.UploadUtils;
import com.qf.domain.Admin;
import com.qf.domain.AgriculturePicture;
import com.qf.domain.AgricultureUser;
import com.qf.response.QueryResponseResult;
import com.qf.service.impl.AdminServiceImpl;
import com.qf.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucifer on 2019.7.18.0018.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AdminServiceImpl adminService;

//   @RequestMapping("/login")
//    public String login(){
//        return "login";
//    }

/*
  @RequestMapping(value = "/findAll/{page}/{size}", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有用户列表", notes = "获取所有用户列表")
    @ResponseBody
    public QueryResponseResult findAll(@PathVariable("size")Integer size, @PathVariable("page")Integer page) {
        return  userService.findAll(page,size);
    }

*/



   // 登录 根据表单提交验证用户信息 并存session里面
   @RequestMapping("/index")
   public String index(Admin admin, HttpServletRequest request) {
       System.out.println(admin.toString()+"111+++++++==========");
       Admin admin1 = adminService.loginByUserNameAndPassword(admin);
       System.out.println(admin1);

       HttpSession session = request.getSession();
       session.setAttribute("admin", admin1);

       return admin1!=null?"redirect:loadAllUser":"error";
   }

   // 管理员查询所有用户信息
    @RequestMapping("/loadAllUser")
    public String loadAllUser(@RequestParam(required = false,defaultValue ="1" )  int pages,
                              @RequestParam(required = false,defaultValue = "5") int rows,Model model) {
        System.out.println("loadAllUser");
        int maxpage = userService.countRows(rows);

        if(pages<1){
            pages=1;
        }
        if(pages>maxpage){
            pages=maxpage;
        }

        List<AgricultureUser> list = userService.loadAllUser(pages, rows);
        model.addAttribute("maxpage",maxpage);
        model.addAttribute("pages",pages);
        model.addAttribute("user",list);

        System.out.println(list);
        return "user";
    }


    // 修改前先查询用户的信息
    @RequestMapping("upDateById")
    public String  upDateById( Integer userId,Model model){
        System.out.println("upDateById+++++++++");
        AgricultureUser user = userService.loadUserById(userId);
        model.addAttribute("user",user);
        System.out.println(user);
        return "edit";
    }
    @ResponseBody
    @RequestMapping(value = "/updateImg", method = RequestMethod.POST)
    public int updateImg(@RequestParam("uploadFile") MultipartFile uploadFile, AgricultureUser user) {
        System.out.println("/updateImg"+"-------");
        String PictureUrl=null;
        if (uploadFile!=null&&!uploadFile.getOriginalFilename().equals("")){
            UploadUtils uploadUtils = new UploadUtils();
            PictureUrl = uploadUtils.savePic(uploadFile);
            user.setUserPicture(PictureUrl);
        }
        int i = userService.updateUser(user);
        return i>0?1:0;
    }

    //修改用户信息
    @RequestMapping("upDateUser")
    public String upDateUser(AgricultureUser user){
        System.out.println("upDateUser__---------------");
        int i = userService.updateUser(user);
        return i>0?"redirect:loadAllUser":"error";
    }

    // 单个删除用户
    @RequestMapping("deleteUser")
    public String deleteUser(int userId){
        int i = userService.deleteUser(userId);
        return i>0?"redirect:loadAllUser":"error";
    }

    // 批量删除用户
    @RequestMapping("deleteBatch")
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
        int i = userService.deleteBatch(list);
        System.out.println(i);
        return i==list.size()?1:0;
    }

    // 添加用户
    @RequestMapping("addUser")
    public String addUser(AgricultureUser user){
        int i = userService.addUser(user);
        return i>0?"redirect:loadAllUser":"error";
    }
    // 注销登录
    @RequestMapping("loginout")
    public String loginout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }



    // 从session里面取出当前用户的名字
    @RequestMapping("loginname")
    @ResponseBody
    public String loginname(HttpServletRequest request) {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        System.out.println(admin);
        return admin!=null?admin.getUserName():"欢迎登录";
    }



}