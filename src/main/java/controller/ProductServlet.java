package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request,response);
                break;
            case "delete":
                try {
                    showDelete(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showEdit(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            default:
                try {
                    showList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        requestDispatcher.forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/products");
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit" :
                try {
                    edit(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case "create":
                try {
                    create(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String action = request.getParameter("action");
        String capacity = request.getParameter("capacity");
        String barrel = request.getParameter("barrel");
        String weight = request.getParameter("weight");
        String img = request.getParameter("img");
        String categoryId = request.getParameter("categoryId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = new Product(id, name, price, description, action, capacity, barrel, weight, img, categoryId, quantity);
        productService.edit(product);
        response.sendRedirect("/products");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String action = request.getParameter("action");
        String capacity = request.getParameter("capacity");
        String barrel = request.getParameter("barrel");
        String weight = request.getParameter("weight");
        String img = request.getParameter("img");
        String categoryId = request.getParameter("categoryId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = new Product(id, name, price, description, action, capacity, barrel, weight, img, categoryId, quantity);
        productService.add(product);
        response.sendRedirect("/products");
    }
}
