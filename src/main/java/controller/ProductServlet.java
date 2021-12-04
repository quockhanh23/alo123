package controller;

import model.Product;
import service.IProductDAO;
import service.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private IProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createProduct":
                showCreate(request, response);
                break;
            case "deleteProduct":
                showDelete(request, response);
                break;
            case "editProduct":
                showEdit(request, response);
                break;
            case "showListByOrderName":
                showListByOrderName(request, response);
                break;
            default:
                showListProduct(request, response);
                break;
        }
    }
    private void showListByOrderName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/listProduct.jsp");
        List<Product> products = productDAO.orderByName();
        request.setAttribute("alo", products);
        requestDispatcher.forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/editProduct.jsp");
        request.setAttribute("aloEdit", product);
        dispatcher.forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/deleteProduct.jsp");
        request.setAttribute("aloDelete", product);
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/createProduct.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        List<Product> products;
        products = productDAO.findAll();
        request.setAttribute("alo", products);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createProduct":
                try {
                    createProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteProduct":
                try {
                    deleteProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "editProduct":
                try {
                    saveEdit(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String action = request.getParameter("action");
        String capacity = request.getParameter("capacity");
        String barrel = request.getParameter("barrel");
        String weight = request.getParameter("weight");
        String img = request.getParameter("img");
        String categoryId = request.getParameter("categoryId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        productDAO.add(new Product(id, name, price, description,
                action, capacity, barrel, weight, img, categoryId, quantity));
        response.sendRedirect("/products");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.delete(id);
        response.sendRedirect("/products");
    }

    private void saveEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String action = request.getParameter("action");
        String capacity = request.getParameter("capacity");
        String barrel = request.getParameter("barrel");
        String weight = request.getParameter("weight");
        String img = request.getParameter("img");
        String categoryId = request.getParameter("categoryId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = new Product(id,name, price, description, action,
                capacity, barrel, weight, img, categoryId, quantity);
        productDAO.update(product);
        response.sendRedirect("/products");
    }
}
