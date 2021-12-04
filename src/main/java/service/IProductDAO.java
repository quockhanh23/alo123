package service;

import model.Product;

import java.util.List;

public interface IProductDAO {
    public List<Product> findAll();
}
