package service;

import model.Order;
import model.OrderDetail;
import model.TotalBill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    public OrderDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/quanlybansung?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select  * from orderofcustomer")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int acc = rs.getInt("accountId");
                String time = rs.getString("time");
                String status = rs.getString("status");
                String address = rs.getString("address");
                list.add(new Order(id, acc, time, status,address));
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return list;
    }

    @Override
    public void add(Order order) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("insert into orderofcustomer(accountId, time, status,address )  values (?,?,?,?) ")) {
            preparedStatement.setInt(1, order.getAccountId());
            preparedStatement.setString(2, order.getTime());
            preparedStatement.setString(3, order.getStatus());
            preparedStatement.setString(4, order.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error");
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("delete from orderofcustomer where id = ?;")) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    @Override
    public List<TotalBill> findAllTotal(int id){
        List<TotalBill> list= new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select  total from totalbill1 where accountId = ?")) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                double total = rs.getDouble("total");
                list.add(new TotalBill(total));
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return list;
    }
    @Override
    public List<Order> findOrder(int id){
        List<Order> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select  * from orderofcustomer where accountId = 1 group by id")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                int acc = rs.getInt("accountId");
                String time = rs.getString("time");
                String status = rs.getString("status");
                String address = rs.getString("address");
                list.add(new Order(id1, acc, time, status,address));
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return list;
    }
    @Override
    public Order findNewOrder(int id){
        Order order =null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select  * from orderofcustomer order by id desc limit 1")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                int acc = rs.getInt("accountId");
                String time = rs.getString("time");
                String status = rs.getString("status");
                String address = rs.getString("address");
                order = new Order(id1, acc, time, status,address);
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return order;
    }
    @Override
    public List<OrderDetail> findDetailById(int id){
        List<OrderDetail> list = new ArrayList<>();
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement
//                     ("select  * from orderdetail where accountId = 1 group by id")) {
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//
//                list.add(new OrderDetail(orderId, productId, quantity));
//            }
//        } catch (SQLException e) {
//            System.out.println("");
//        }
        return list;
    }
    @Override
    public boolean update(Order order) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("update orderofcustomer set accountId =?,time=?,status=? where id = ?;")) {
            preparedStatement.setInt(1, order.getAccountId());
            preparedStatement.setString(2, order.getTime());
            preparedStatement.setString(3, order.getStatus());
            preparedStatement.setInt(4, order.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Order findById(int id) {
        Order order = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from orderofcustomer where id =?")) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = Integer.parseInt(resultSet.getString("id"));
                int acc = Integer.parseInt(resultSet.getString("accountId"));
                String time = resultSet.getString("time");
                String stt = resultSet.getString("status");
                String address = resultSet.getString("address");
                order = new Order(id1, acc, time, stt,address);
            }
        } catch (SQLException ignored) {
        }
        return order;
    }
}

