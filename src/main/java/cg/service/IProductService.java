package cg.service;


import cg.model.Product;

public interface IProductService extends IGeneralService<Product>{
    Iterable<Product>findAllByNameContaining(String name);
    Iterable<Product>findAllByOrderByPrice();
    Iterable<Product> getTop4New();
}
