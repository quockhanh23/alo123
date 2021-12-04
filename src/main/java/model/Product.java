package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String action;
    private String capacity;
    private String barrel;
    private String weight;
    private String img;
    private String categoryId;
    private int quantity;

    public Product(int id, String name, double price, String description, String action, String capacity, String barrel, String weight, String img, String categoryId, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.action = action;
        this.capacity = capacity;
        this.barrel = barrel;
        this.weight = weight;
        this.img = img;
        this.categoryId = categoryId;
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getBarrel() {
        return barrel;
    }

    public void setBarrel(String barrel) {
        this.barrel = barrel;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
