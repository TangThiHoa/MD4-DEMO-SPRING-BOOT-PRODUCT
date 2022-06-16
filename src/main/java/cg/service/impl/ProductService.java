package cg.service.impl;

import cg.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import cg.reponsitory.IProductReponsitory;
import cg.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductReponsitory productReponsitory;

    @Override
    public Iterable<Product> findAll() {
        return productReponsitory.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productReponsitory.findById(id);
    }

    @Override
    public void save(Product product) {
        productReponsitory.save(product);

    }

    @Override
    public void remove(Long id) {
        productReponsitory.deleteById(id);

    }

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return productReponsitory.findAllByNameContaining(name);

    }

    @Override
    public Iterable<Product> findAllByOrderByPrice() {
        return productReponsitory.findAllByOrderByPrice();
    }


}
