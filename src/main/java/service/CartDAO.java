package service;

import model.Cart;
import model.CartDetail;

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
    public List<CartDetail> findDetailById(int id) {
        List<CartDetail> details = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from cartdetail where cartId = ?")) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int cartId = resultSet.getInt("cartId");
                int productId = resultSet.getInt("productId");
                int quantity = resultSet.getInt("quantity");
                details.add(new CartDetail(cartId, productId, quantity));
            }
        } catch (SQLException e) {
        }
        return details;
    }
    @Override
    public void deleteProductFromCart(int cusId,int proId){
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("delete from cartdetail where productId=? and cartId=?")) {
            preparedStatement.setInt(1, proId);
            preparedStatement.setInt(2, cusId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error");
        }
    }
    @Override
    public void deleteAllProduct(int cusId){
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("update cartdetail set quantity = ? where cartId =?")) {
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, cusId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error");
        }
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
    public void addProductToCart(int cusId, int proId) {
        CartDetail cartDetail = checkCart(cusId, proId);
        if (cartDetail == null) {
//            thêm sp
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement
                         ("insert into cartdetail(cartId, productId,quantity)  values (?,?,?) ")) {
                preparedStatement.setInt(1, cusId);
                preparedStatement.setInt(2, proId);
                preparedStatement.setInt(3, 1);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("error");
            }
        } else {
            int quantity = cartDetail.getQuantity();
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement
                         ("update cartdetail set quantity = ? where cartId =? and productId =?")) {
                preparedStatement.setInt(1, quantity + 1);
                preparedStatement.setInt(2, cusId);
                preparedStatement.setInt(3, proId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("error");
            }
        }
    }

    @Override
    public void minusProductToCart(int cusId, int proId) {
        CartDetail cartDetail = checkCart(cusId, proId);

        int quantity = cartDetail.getQuantity();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("update cartdetail set quantity = ? where cartId =? and productId =?")) {
            preparedStatement.setInt(1, quantity - 1);
            preparedStatement.setInt(2, cusId);
            preparedStatement.setInt(3, proId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error");
        }

    }

    @Override
    public CartDetail checkCart(int cartId, int proId) {
        CartDetail cartDetail = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from cartdetail where cartId =? and productId =?;")) {
            preparedStatement.setInt(1, cartId);
            preparedStatement.setInt(2, proId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int cartId1 = Integer.parseInt(resultSet.getString("cartId"));
                int productId = Integer.parseInt(resultSet.getString("productId"));
                int quantity = Integer.parseInt(resultSet.getString("quantity"));
                cartDetail = new CartDetail(cartId1, productId, quantity);
            }
            ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cartDetail;
    }

    @Override
    public void add(Cart cart) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("insert into cart(id, accountId)  values (?,?) ")) {
            preparedStatement.setInt(1, cart.getId());
            preparedStatement.setInt(2, cart.getAccountId());
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
                     ("delete from cart where id = ?;")) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Cart cart) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("update cart set accountId =? where id = ?;")) {
            preparedStatement.setInt(1, cart.getAccountId());
            preparedStatement.setInt(2, cart.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Cart findById(int id) {
        Cart cart = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from cart where id =?")) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = Integer.parseInt(resultSet.getString("id"));
                int acc = Integer.parseInt(resultSet.getString("accountId"));
                cart = new Cart(id1, acc);
            }
        } catch (SQLException ignored) {
        }
        return cart;
    }
}
