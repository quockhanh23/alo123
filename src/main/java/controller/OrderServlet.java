package controller;

import model.Cart;
import model.Order;
import model.Product;
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

        }
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
        }
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
