package controller;

import model.Comment;
import model.Product;
import service.CommentDAO;
import service.ICommentDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CommentServlet", value = "/comments")
public class CommentServlet extends HttpServlet {
    ICommentDAO commentDAO =new CommentDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showComment(request, response);
                break;
            case "createComment":
                showCreate(request, response);
                break;
        }
    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("comment/createComment.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("comment/listComment.jsp");
        List<Comment> comments;
        comments = commentDAO.findAll();
        request.setAttribute("alo", comments);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createComment":
                try {
                    createComment(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void createComment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String content = request.getParameter("content");
        commentDAO.add(new Comment(id,accountId,productId,content,orderId));
        response.sendRedirect("/comments");
    }
}
