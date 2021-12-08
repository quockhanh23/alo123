package service;

import model.Order;
import model.OrderDetail;
import model.TotalBill;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDAO {
    List<Order> findAll();

    void add(Order order) throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean update(Order order) throws SQLException;

    public Order findById(int id);
    public List<Order> findOrder(int id);
    public List<OrderDetail> findDetailById(int id);
    public List<TotalBill> findAllTotal(int id);
    public Order findNewOrder(int id);
}
