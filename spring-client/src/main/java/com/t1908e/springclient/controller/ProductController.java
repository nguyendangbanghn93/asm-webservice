package com.t1908e.springclient.controller;

import com.t1908e.springclient.service.Product;
import com.t1908e.springclient.service.ProductService;
import com.t1908e.springclient.service.ProductServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    ProductServiceService productServiceService = new ProductServiceService();
    ProductService service = productServiceService.getProductServicePort();

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("product", service.getAllProducts());
        return "product/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }
    @RequestMapping( method = RequestMethod.POST)
    public String store(Product product, BindingResult result) {
        service.addProduct(product);
        return "redirect:/product";
    }
}
