package cg.service;

import cg.model.Product;

import java.util.Optional;

public interface IGeneralService<T> { // interface sử dụng generic mô tả các phương chung mà tất cả các cg.service cần có
    Iterable<T> findAll();

    Optional<Product> findById(Long id);

    void save(T t);

    void remove(Long id);
}