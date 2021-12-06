package service;

import model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccountDAO {
    public AccountDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybansung?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    public Account login(String name,String pass){
        Account account1 = null ;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from account where name =? and password = ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pass);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String password = rs.getString("password");
                String rePassword = rs.getString("re_password");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int roleId = rs.getInt("roleId");
                double balance = rs.getDouble("balance");
                int statusId = rs.getInt("statusId");
                int age = rs.getInt("age");
                account1 = new Account(id, name1, password,rePassword,phoneNumber,email,address,roleId,balance,statusId,age);
            }
        } catch (SQLException e) {
        }
        return account1;

    }
    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from account ");) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String rePassword = rs.getString("re_password");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int roleId = rs.getInt("roleId");
                double balance = rs.getDouble("balance");
                int statusId = rs.getInt("statusId");
                int age = rs.getInt("age");
                accounts.add(new Account(id, name, password,rePassword,phoneNumber,email,address,roleId,balance,statusId,age));
            }
        } catch (SQLException e) {
        }
        return accounts;

    }

    @Override
    public void add(Account account) throws SQLException {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into account(name,password,re_password,phoneNumber,email,address,roleId,statusId,age) values (?,?,?,?,?,?,?,?,?)");) {
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getRe_password());
            preparedStatement.setString(4, account.getPhoneNumber());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setString(6, account.getAddress());
            preparedStatement.setInt(7, account.getRoleId());
            preparedStatement.setInt(8, account.getStatusId());
            preparedStatement.setInt(9, account.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Account account) throws SQLException {
        return false;
    }

    @Override
    public Account findById(int id) {
        return null;
    }
}
