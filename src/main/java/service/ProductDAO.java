package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/quanlybansung?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select  * from product")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String action = rs.getString("action");
                String capacity = rs.getString("capacity");
                String barrel = rs.getString("barrel");
                String weight = rs.getString("weight");
                String img = rs.getString("img");
                String categoryId = rs.getString("categoryId");
                int quantity = rs.getInt("quantity");
                list.add(new Product(id, name, price, description,
                        action, capacity, barrel, weight, img, categoryId, quantity));
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return list;
    }

    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("insert into product(name, price,description,action" +
                             ",capacity,barrel,weight,img,categoryId, quantity)  values (?,?,?,?,?,?,?,?,?,?) ")) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getAction());
            preparedStatement.setString(5, product.getCapacity());
            preparedStatement.setString(6, product.getBarrel());
            preparedStatement.setString(7, product.getWeight());
            preparedStatement.setString(8, product.getImg());
            preparedStatement.setString(9, product.getCategoryId());
            preparedStatement.setInt(10, product.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error");
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from product where id =?")) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = Double.parseDouble(resultSet.getString("price"));
                String description = resultSet.getString("description");
                String action = resultSet.getString("action");
                String capacity = resultSet.getString("capacity");
                String barrel = resultSet.getString("barrel");
                String weight = resultSet.getString("weight");
                String img = resultSet.getString("img");
                String categoryId = resultSet.getString("categoryId");
                int quantity = Integer.parseInt(resultSet.getString("quantity"));
                product = new Product(id, name, price, description, action,
                        capacity, barrel, weight, img, categoryId, quantity);
            }
        } catch (SQLException ignored) {
        }
        return product;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> product = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from product where name like ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name1 = rs.getString("name");
                    double price = rs.getDouble("price");
                    String img = rs.getString("img");
                    product.add(new Product(id, name1, price, img));
                }
            }
        } catch (SQLException ignored) {

        }
        return product;
    }

    @Override
    public List<Product> orderByName() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from product order by name");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String action = rs.getString("action");
                String capacity = rs.getString("capacity");
                String barrel = rs.getString("barrel");
                String weight = rs.getString("weight");
                String img = rs.getString("img");
                String categoryId = rs.getString("categoryId");
                int quantity = rs.getInt("quantity");
                list.add(new Product(id, name, price, description,
                        action, capacity, barrel, weight, img, categoryId, quantity));
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return list;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("delete from product where id = ?;")) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("update product set name =?, price=?,description=?,action=?," +
                             "capacity=?,barrel=?,weight=?,img=?,categoryId=?, quantity=? where id = ? ");) {
            preparedStatement.setInt(11, product.getId());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getAction());
            preparedStatement.setString(5, product.getCapacity());
            preparedStatement.setString(6, product.getBarrel());
            preparedStatement.setString(7, product.getWeight());
            preparedStatement.setString(8, product.getImg());
            preparedStatement.setString(9, product.getCategoryId());
            preparedStatement.setInt(10, product.getQuantity());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
