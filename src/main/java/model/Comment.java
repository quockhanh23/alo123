package model;

public class Comment {
    private int id;
    private int accountId;
    private int productId;
    private String content;
    private int orderId;

    public Comment() {
    }

    public Comment(int id, int accountId, int productId, String content, int orderId) {
        this.id = id;
        this.accountId = accountId;
        this.productId = productId;
        this.content = content;
        this.orderId = orderId;
    }

    public Comment(int accountId, int productId, String content, int orderId) {
        this.accountId = accountId;
        this.productId = productId;
        this.content = content;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
