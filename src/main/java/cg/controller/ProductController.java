package cg.controller;

import cg.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import cg.service.IProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

        @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("product", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("pro", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView sava(Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }




}
