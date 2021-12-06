package service;

import model.Comment;
import model.Order;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ICommentDAO {
    List<Comment> findAll();

    List<Comment> CommentOfProduct(int idProduct);

    void add(Comment comment) throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean update(Comment comment) throws SQLException;

    public Comment findById(int id);
}
