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

@WebServlet(name = "ManagerServlet", value = "/manager1")
public class ManagerServlet extends HttpServlet {
    private IProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                try {
                    delete(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showBoard(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.delete(id);
        response.sendRedirect("/manager1");
    }
    private void showBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String key = request.getParameter("key");
        String name = request.getParameter("name1");


        List<Product> products;
        if (key != null) {
            products = productDAO.findByName(key);
        } else if (name != null){
            double price =Double.parseDouble(request.getParameter("price")) ;
            String description = request.getParameter("description");
            String action1 = request.getParameter("action1");
            String capacity = request.getParameter("capacity");
            String barrel = request.getParameter("barrel");
            String weight = request.getParameter("weight");
            String img = request.getParameter("img");
            String category = request.getParameter("category");
            int quantity =Integer.parseInt( request.getParameter("quantity"));
            productDAO.add(new Product(1,name,price,description,action1,capacity,barrel,weight,img,category,quantity));
            response.sendRedirect("/manager1");
        }else {
            products = productDAO.findAll();
            request.setAttribute("products", products);
            request.getRequestDispatcher("manager/managerProduct.jsp").forward(request, response);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
