package controller;

import model.Cart;
import model.Order;
import service.IOrderDAO;
import service.OrderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/orders")
public class OrderServlet extends HttpServlet {
    private IOrderDAO orderDAO = new OrderDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showListOrder(request, response);
                break;
            case "createOrder":
                showCreate(request, response);
                break;
            case "deleteOrder":
                showDelete(request, response);
                break;
            case "editOrder":
                showEdit(request, response);
                break;

        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/order/editOrder.jsp");
        request.setAttribute("aloEdit", order);
        dispatcher.forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/order/deleteOrder.jsp");
        request.setAttribute("aloDelete", order);
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("order/createOrder.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("order/listOrder.jsp");
        List<Order> orders;
        orders = orderDAO.findAll();
        request.setAttribute("alo", orders);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createOrder":
                try {
                    createOrder(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteOrder":
                try {
                    deleteOrder(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "editOrder":
                try {
                    saveEdit(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void saveEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int acc = Integer.parseInt(request.getParameter("accountId"));
        String time = request.getParameter("time");
        int status = Integer.parseInt(request.getParameter("status"));
        Order order = new Order(id, acc, time, status);
        orderDAO.update(order);
        response.sendRedirect("/orders");
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        orderDAO.delete(id);
        response.sendRedirect("/orders");
    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        int acc = Integer.parseInt(request.getParameter("accountId"));
        String time = request.getParameter("time");
        int stt = Integer.parseInt(request.getParameter("status"));
        orderDAO.add(new Order(id, acc, time, stt));
        response.sendRedirect("/orders");
    }
}
