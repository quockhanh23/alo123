package controller;

import model.*;
import service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/carts")
public class CartServlet extends HttpServlet {
    private ICartDAO cartDAO = new CartDAO();
    private IAccountDAO accountDAO = new AccountDAO();
    private IProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createCart":
                showCreate(request, response);
                break;
            case "editCart":
                showEdit(request, response);
                break;
            case "deleteCart":
                showDelete(request, response);
                break;
            case "showCusCart":
                showCart(request,response);
                break;
            case "addPToCart":
                addPToCart(request,response);
                break;
            case "minus":
                minusQuantity(request,response);
                break;
            case "plus":
                plusQuantity(request,response);
                break;
            default:
                showListCart(request, response);
                break;
        }
    }

    private void plusQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        int proId = Integer.parseInt(request.getParameter("productId"));
        int cusId = account.getId();
        cartDAO.addProductToCart(cusId,proId);
        List<CartDetail> details = cartDAO.findDetailById(cusId);
        session.setAttribute("cartDetails",details);
        response.sendRedirect("/carts?action=showCusCart");
    }

    private void minusQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        int proId = Integer.parseInt(request.getParameter("productId"));
        int cusId = account.getId();
        cartDAO.minusProductToCart(cusId,proId);
        List<CartDetail> details = cartDAO.findDetailById(cusId);
        session.setAttribute("cartDetails",details);
        response.sendRedirect("/carts?action=showCusCart");
    }

    private void addPToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        int proId = Integer.parseInt(request.getParameter("id"));
        if(account==null){
            response.sendRedirect("/accounts");
        }else {
            int cusId = account.getId();
            cartDAO.addProductToCart(cusId,proId);
            List<CartDetail> details = cartDAO.findDetailById(cusId);
            session.setAttribute("cartDetails",details);
            response.sendRedirect("/products");
        }
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        if (account == null){
            response.sendRedirect("/accounts");
        }else {
            int id = account.getId();
//            select product.name, product.price,cartdetail.quantity,sum(product.price*cartdetail.quantity) as total1
//            from cartdetail join product on cartdetail.productId = product.id where cartId=? group by product.name
            List<Product> productsInCart = productDAO.findProductInCart(id);
            List<CartDetail> details = cartDAO.findDetailById(id);
            session.setAttribute("productsInCart",productsInCart);
            session.setAttribute("cartDetails",details);
            double total = 0;
            for (int i = 0; i < productsInCart.size(); i++) {
               total+= productsInCart.get(i).getPrice()* details.get(i).getQuantity();
            }
            session.setAttribute("totalInCart",total);
            request.getRequestDispatcher("cart/customerCart.jsp").forward(request,response);
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



