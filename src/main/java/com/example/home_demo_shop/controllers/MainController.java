package com.example.home_demo_shop.controllers;

import com.example.home_demo_shop.dao.ProductDao;
import com.example.home_demo_shop.model.Product;
import com.example.home_demo_shop.service.iml.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.persistence.Convert;
import javax.xml.soap.SAAJResult;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductDao productDao;

    @GetMapping("/")
    public String initPage(
            Model model
    ){
        List<Product> all = productService.findAll();
        model.addAttribute("all",all);
        return "addProduct";
    }


    @PostMapping("/product/add")
    public String addProduct(
            @RequestParam String productName,
            @RequestParam int price,
            @RequestParam String description
    ){
        Product build = Product.builder().productName(productName).price(price).description(description).build();
        productService.save(build);

        return "redirect:/";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(
            @PathVariable int id
    ){
        productService.DeleteById(id);
        return "redirect:/";
    }

//    @DeleteMapping
//    @PostMapping
//    @PutMapping
//     trace, option


    @GetMapping("/product/{id}")
    public String getProduct(
            @PathVariable int id,
            Model model
    ){
        Optional<Product> byId = productService.findById(id);
        Product product = byId.get();
        model.addAttribute(product);
        return "product";
    }


    @GetMapping("/product/menu")
    public String menu(
        Model model
    ){
        List<Product> all = productService.findAll();
        model.addAttribute("all",all);
        return "menu";
    }

    @GetMapping("/product/menu/moreThan1000")
    public String menuMoreThat1000(
            Model model
    ){
        List<Product> products = productDao.queryProductsByPriceIsGreaterThanEqual(1000);
        model.addAttribute("all",products);
        return "menu";
    }


    @GetMapping("/product/menu/moreThan2000")
    public String menuMoreThat2000(
            Model model
    ){
        List<Product> products = productDao.queryProductsByPriceIsGreaterThanEqual(2000);
        model.addAttribute("all",products);
        return "menu";
    }

    @GetMapping("/product/menu/last10Products")
    public String last10Products(
            Model model
    ){
        List<Product> all = productDao.findTop10ByOrderByIdDesc();
        model.addAttribute("all",all);
        return "menu";
    }

    @GetMapping("/product/menu/sortedByAlphabet")
    public String sortedByAlphabet(
        Model model
    ){
        List<Product> products = productDao.queryProductsByOrderByProductName();
        model.addAttribute("all",products);
        return "menu";
    }

    @GetMapping("/product/menu/showAll")
    public String menuShowAll(
            Model model
    ){
        List<Product> all = productService.findAll();
        model.addAttribute("all",all);

        return "menu";
    }
}
