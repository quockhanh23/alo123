package service;

import model.Order;
import model.OrderDetail;

import java.sql.SQLException;

public interface IOrderDetailDAO {
    void add(OrderDetail orderDetail) throws SQLException;

    boolean delete(int id) throws SQLException;
}
