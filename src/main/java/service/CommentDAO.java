package service;

import model.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO implements ICommentDAO {
    public CommentDAO() {
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
    public List<Comment> findAll() {
        List<Comment> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select  * from comment")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idA = rs.getInt("accountId");
                int idP = rs.getInt("productId");
                String content = rs.getString("content");
                int idO = rs.getInt("orderId");
                list.add(new Comment(id, idA, idP, content, idO));
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return list;
    }

    @Override
    public List<Comment> CommentOfProduct(int idProduct) {
        List<Comment> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from comment where productId =?")) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, idProduct);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int accountId = rs.getInt("accountId");
                int productId = rs.getInt("productId");
                String content = rs.getString("content");
                int orderId = rs.getInt("orderId");
                list.add(new Comment(id, accountId, productId, content, orderId));
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return list;
    }

    @Override
    public void add(Comment comment) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("insert into comment (id,accountId,productId,content,orderId) values(?,?,?,?,?)")) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, comment.getId());
            preparedStatement.setInt(2, comment.getAccountId());
            preparedStatement.setInt(3, comment.getProductId());
            preparedStatement.setString(4, comment.getContent());
            preparedStatement.setInt(5, comment.getOrderId());
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
                     ("delete from comment where id = ?;")) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Comment comment) throws SQLException {

        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("update comment set accountId=?, productId=?,content=?,orderId=? where id = ?")) {
            preparedStatement.setInt(1, comment.getAccountId());
            preparedStatement.setInt(2, comment.getProductId());
            preparedStatement.setString(3, comment.getContent());
            preparedStatement.setInt(4, comment.getOrderId());
            preparedStatement.setInt(5, comment.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Comment findById(int id) {
        Comment comment = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from comment where Id =?")) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                int accountId = rs.getInt("accountId");
                int productId = rs.getInt("productId");
                String content = rs.getString("content");
                int orderId = rs.getInt("orderId");
                comment = new Comment(id1, accountId, productId, content, orderId);
            }
        } catch (SQLException ignored) {
        }
        return comment;
    }
}
