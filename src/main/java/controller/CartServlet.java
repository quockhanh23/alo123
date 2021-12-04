package controller;

import model.Cart;
import model.Product;
import service.CartDAO;
import service.ICartDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/carts")
public class CartServlet extends HttpServlet {
    private ICartDAO cartDAO = new CartDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showListCart(request, response);
                break;
            case "createCart":
                showCreate(request, response);
                break;
            case "editCart":
                showEdit(request, response);
                break;
            case "deleteCart":
                showDelete(request, response);
                break;
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cart cart = cartDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart/deleteCart.jsp");
        request.setAttribute("aloDelete", cart);
        dispatcher.forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cart cart = cartDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart/editCart.jsp");
        request.setAttribute("aloEdit", cart);
        dispatcher.forward(request, response);
    }

    private void showListCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cart/listCart.jsp");
        List<Cart> carts;
        carts = cartDAO.findAll();
        request.setAttribute("alo", carts);
        requestDispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cart/createCart.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createCart":
                try {
                    createCart(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "editCart":
                try {
                    saveEdit(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteCart":
                try {
                    deleteCart(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        cartDAO.delete(id);
        response.sendRedirect("/carts");
    }

    private void saveEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int acc = Integer.parseInt(request.getParameter("accountId"));
        Cart cart = new Cart(id, acc);
        cartDAO.update(cart);
        response.sendRedirect("/carts");
    }

    private void createCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int acc = Integer.parseInt(request.getParameter("accountId"));
        cartDAO.add(new Cart(id, acc));
        response.sendRedirect("/carts");
    }
}



