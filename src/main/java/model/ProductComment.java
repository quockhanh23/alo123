package model;

public class ProductComment {
    private int id;
    private int accountId;
    private int productId;
    private String content;

    public ProductComment(int id, int accountId, int productId, String content) {
        this.id = id;
        this.accountId = accountId;
        this.productId = productId;
        this.content = content;
    }

    public ProductComment() {
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
}
