package com.qf.controller;

import com.qf.domain.Admin;
import com.qf.domain.AgricultureProduct;
import com.qf.service.impl.ProductServiceImpl;
import com.qf.service.impl.SubclassProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lucifer on 2019.7.22.0022.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private  SubclassProductServiceImpl subclassProductService;

    //查询所有
    @RequestMapping(value = "/findAll")
    public String loadAll(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer size, Model model,HttpServletRequest request) {

         if (page<1) {
             page = 1;
         }
        Page<AgricultureProduct> all = productService.findAll(page-1, size);
        int  totalRows =(int) all.getTotalElements();
        int totalPages = all.getTotalPages();

        if(page>totalPages){
            page=totalPages;
        }
        List<AgricultureProduct> agricultureProductList = all.getContent();

        Admin admin = (Admin)request.getSession().getAttribute("admin");

        System.out.println(admin);
        System.out.println(totalRows);
        System.out.println(totalPages);
        System.out.println(agricultureProductList);
        model.addAttribute("product", agricultureProductList);
        System.out.println(totalPages);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("page",page);
        model.addAttribute("admin",admin);
        return "productIndex";
    }

    //增加

    @RequestMapping("/save")
    public String save(AgricultureProduct agricultureProduct) {
        AgricultureProduct product = productService.save(agricultureProduct);
        return product != null ? "redirect:findAll" : "error";
    }

    //删除
    @RequestMapping(value = "/delete")
    public String delete(Integer productId) {
        subclassProductService.deleteop(productId);
        subclassProductService.deletepp(productId);
        subclassProductService.deletesp(productId);
        subclassProductService.deletesup(productId);
        subclassProductService.deletesop(productId);
        int i = productService.delete(productId);

        return i > 0 ? "redirect:findAll" : "error";
    }

    //修改
    @RequestMapping(value = "/update")
    public String update(AgricultureProduct agricultureProduct) {
        AgricultureProduct product = productService.update(agricultureProduct);
        return product != null ? "redirect:findAll" : "error";
    }

    //修改先查询
    @RequestMapping(value = "/loadById")
    public String loadById(Integer productId, Model model) {
        AgricultureProduct product = productService.loadById(productId);
        model.addAttribute("product",product);
        return product != null ? "productEdit" : "error";

    }

}
