package controller;

import model.Account;
import service.AccountDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AccountServlet", value = "/accounts")
public class AccountServlet extends HttpServlet {
    AccountDAO accountDAO =new AccountDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action) {
            case "signup":
                showSignup(request,response);
                break;
            case "login":
                showLogin(request, response);
                break;
            case "logout":
                logout(request,response);
                break;
            default:
                showLogin(request,response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("acc");
        request.getRequestDispatcher("index1.jsp").forward(request,response);
    }

    private void showSignup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("account/signup.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("account/login.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action) {
            case "login":
                login(request,response);
                break;
            case "signup":
                try {
                    signup(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name1= request.getParameter("username");
        String password = request.getParameter("pass");
        String rePass= request.getParameter("repass");
        String phoneNum = request.getParameter("tel");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int age = Integer.parseInt(request.getParameter("age"));
        this.accountDAO.add(new Account(1,name1,password,rePass,phoneNum,email,address,2,0,1,age));
//        request.setAttribute("resultSignup","Signup success");
       response.sendRedirect("index1.jsp");
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name1 = request.getParameter("name2");
        String pass = request.getParameter("pass2");
        Account account = this.accountDAO.login(name1,pass);
        if (account == null){
            request.setAttribute("mess","Wrong user or pass");
            request.getRequestDispatcher("account/login.jsp").forward(request,response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("acc",account);
            request.getRequestDispatcher("index1.jsp").forward(request,response);
        }
    }
}
