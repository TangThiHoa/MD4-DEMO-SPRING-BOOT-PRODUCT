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

@CrossOrigin
@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

//    @GetMapping("")
//    public ModelAndView showForm() {
//
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("product", productService.findAll());
//        return modelAndView;
        @GetMapping("")
        public ModelAndView listProduct(@RequestParam("search") Optional<String> search) {
            Iterable<Product> products;
            if(search.isPresent()){   //check tồn tại của optuon
                products = productService.findAllByNameContaining(search.get());
            } else {
                products = productService.findAllByOrderByPrice();
            }
            ModelAndView modelAndView = new ModelAndView("/list");
            modelAndView.addObject("product", products);
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

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productService.findById(id).get();
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;

    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("product", productService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView remove(Product product) {
        productService.remove(product.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("product", productService.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/top4New")
    public ModelAndView top4New() {
        ModelAndView modelAndView = new ModelAndView("new");
        modelAndView.addObject("name",productService.getTop4New());
        return modelAndView;
    }




}
