package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lucifer on 2019.7.22.0022.
 */
@Controller
public class ViewController {
    public ViewController() {
        System.out.println("viewController");
    }
    @RequestMapping("/{path1}"+"view")
    public String show1(@PathVariable("path1") String path1) {
        System.out.println(path1);
        return path1;
    }
    @RequestMapping("/{path1}/{path2}"+"view")
    public String show1(@PathVariable("path1") String path1,@PathVariable("path2") String path2){
        return path1+"/"+path2;
    }
}
