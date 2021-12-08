package controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.*;
import service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/orders")
public class OrderServlet extends HttpServlet {
    private IOrderDAO orderDAO = new OrderDAO();
    private IProductDAO productDAO = new ProductDAO();
    private ICartDAO cartDAO = new CartDAO();
    private IOrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createOrder":
                showCreate(request, response);
                break;
            case "deleteOrder":
                try {
                    deleteOrder(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "editOrder":
                showEdit(request, response);
                break;
            case "showUserOrder":
                showUserOrder(request,response);
                break;
            case "placeOrder":
                try {
                    placeOrder(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                showUserOrder(request,response);
        }
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        int cusId = account.getId();
        int id = Integer.parseInt(request.getParameter("orderId"));
        orderDAO.delete(id);
        orderDetailDAO.delete(id);
        List<Order> orders = orderDAO.findOrder(cusId);
        session.setAttribute("orderList", orders);
        response.sendRedirect("/orders");
    }
    private void placeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        int cusId = account.getId();
        String address =account.getAddress();
        String time = LocalDateTime.now().toString();
        Order newOrder = new Order(1,account.getId(),time,"pending",address);
        orderDAO.add(newOrder);
        List<Order> orders = orderDAO.findOrder(cusId);
        Order lastOrder = orderDAO.findNewOrder(cusId);
        session.setAttribute("orderList", orders);
        List<CartDetail> details = cartDAO.findDetailById(cusId);
        for (int i = 0; i < details.size(); i++) {
            orderDetailDAO.add(new OrderDetail(lastOrder.getId(),details.get(i).getProductId(),details.get(i).getQuantity() ));
        }
        cartDAO.deleteAllProduct(cusId);
        List<CartDetail> details1 = cartDAO.findDetailById(cusId);
        session.setAttribute("cartDetails",details1);
//        session.setAttribute("orderDetail", orderDetails);
        response.sendRedirect("/orders?action=showUserOrder");
    }

    private void showUserOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        if (account == null) {
            response.sendRedirect("/accounts");
        } else {
            int id = account.getId();
            List<Order> orders = orderDAO.findOrder(id);
            List<TotalBill> totalBill = orderDAO.findAllTotal(id);
            session.setAttribute("orderList", orders);
            session.setAttribute("allTotalBill",totalBill);
//            session.setAttribute("orderDetail", orderDetails);
            request.getRequestDispatcher("order/orderList.jsp").forward(request,response);
        }

    }

    private void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        if (account == null) {
            response.sendRedirect("/accounts");
        } else {
            int id = account.getId();
            List<Product> productsInCart = productDAO.findProductInCart(id);
            List<CartDetail> details = cartDAO.findDetailById(id);
            session.setAttribute("productsInCart", productsInCart);
            session.setAttribute("cartDetails", details);
            double total = 0;
            for (int i = 0; i < productsInCart.size(); i++) {
                total += productsInCart.get(i).getPrice() * details.get(i).getQuantity();
            }
            session.setAttribute("totalInCart", total);
            request.getRequestDispatcher("order/checkout.jsp").forward(request, response);
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
    }

}
