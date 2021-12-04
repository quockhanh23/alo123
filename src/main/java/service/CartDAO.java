package service;

import model.Cart;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDAO {
    public CartDAO() {
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
    public List<Cart> findAll() {
        List<Cart> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from cart")) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int acc = resultSet.getInt("accountId");
                list.add(new Cart(id, acc));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public void add(Cart cart) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("insert into cart(id, accountId)  values (?,?) ");) {
            preparedStatement.setInt(1, cart.getId());
            preparedStatement.setInt(1, cart.getAccountId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error");
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Cart cart) throws SQLException {
        return false;
    }
}
