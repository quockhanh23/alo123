package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {


    public ProductServiceImpl() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybansung?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getInt("price");
                String description = rs.getString("description");
                String action = rs.getString("action");
                String capacity = rs.getString("capacity");
                String barrel = rs.getString("barrel");
                String weight = rs.getString("weight");
                String img = rs.getString("img");
                String categoryId = rs.getString("categoryId");
                int quantity = rs.getInt("quantity");
                products.add(new Product(id, name, price, description, action, capacity, barrel, weight, img, categoryId, quantity));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public List<Product> findAllByPrice() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product order by price desc");) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getInt("price");
                String description = rs.getString("description");
                String action = rs.getString("action");
                String capacity = rs.getString("capacity");
                String barrel = rs.getString("barrel");
                String weight = rs.getString("weight");
                String img = rs.getString("img");
                String categoryId = rs.getString("categoryId");
                int quantity = rs.getInt("quantity");
                products.add(new Product(id, name, price, description, action, capacity, barrel, weight, img, categoryId, quantity));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public List<Product> findByName(String name) throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product order by name like ?");) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                double price = rs.getInt("price");
                String description = rs.getString("description");
                String action = rs.getString("action");
                String capacity = rs.getString("capacity");
                String barrel = rs.getString("barrel");
                String weight = rs.getString("weight");
                String img = rs.getString("img");
                String categoryId = rs.getString("categoryId");
                int quantity = rs.getInt("quantity");
                products.add(new Product(id, name1, price, description, action, capacity, barrel, weight, img, categoryId, quantity));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public void add(Product product) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into product(id, name, price,description,action,capacity,barrel,weight,img,categoryId,quantity) value (?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setString(4, product.getDescription());
        preparedStatement.setString(5, product.getAction());
        preparedStatement.setString(6, product.getCapacity());
        preparedStatement.setString(7, product.getBarrel());
        preparedStatement.setString(8, product.getWeight());
        preparedStatement.setString(9, product.getImg());
        preparedStatement.setString(10, product.getCategoryId());
        preparedStatement.setInt(11, product.getQuantity());
        preparedStatement.executeUpdate();
    }

    @Override
    public void edit(Product product) throws SQLException {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("update product set name=?,price=?,description=?,action=?,capacity=?,barrel=?,weight=?,img=?,categoryId=?,quantity=? where id=?");) {
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
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public Product findById(int id) throws SQLException {
        Product product = null;
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id=?");) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getInt("price");
                String description = rs.getString("description");
                String action = rs.getString("action");
                String capacity = rs.getString("capacity");
                String barrel = rs.getString("barrel");
                String weight = rs.getString("weight");
                String img = rs.getString("img");
                String categoryId = rs.getString("categoryId");
                int quantity = rs.getInt("quantity");
                product = new Product(id1, name, price, description, action, capacity, barrel, weight, img, categoryId, quantity);
            }
        } catch (SQLException e) {
        }
        return product;
    }
}
