package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> findAll();

    List<Product> findRelatedProducts(String categoryId1);

    List<Product> findRecentProduct();

    void add(Product product) throws SQLException;

    Product findById(int id);

    List<Product> findByName(String name);

    List<Product> findByPrice(int price);

    List<Product> orderByName();

    boolean delete(int id) throws SQLException;

    boolean update(Product product) throws SQLException;

}
