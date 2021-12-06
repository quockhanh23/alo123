package service;

import model.Cart;
import model.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDAO {
    List<Order> findAll();

    void add(Order order) throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean update(Order order) throws SQLException;

    public Order findById(int id);

}
