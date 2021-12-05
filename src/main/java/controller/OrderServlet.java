package controller;

import model.Order;
import model.Product;
import service.IOrderDAO;
import service.OrderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
//            case "createCart":
//                showOrder(request, response);
//                break;
//            case "editCart":
//                showEdit(request, response);
//                break;
//            case "deleteCart":
//                showDelete(request, response);
//                break;
//        }
        }
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

    }
}
