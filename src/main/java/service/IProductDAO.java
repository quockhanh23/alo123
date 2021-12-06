package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> findAll();

    void add(Product product) throws SQLException;

    Product findById(int id);

    List<Product> findByName(String name);

    List<Product> orderByName();

    boolean delete(int id) throws SQLException;

    boolean update(Product product) throws SQLException;

}
