package model;

public class Cart {
    private int id;
    private int accountId;

    public Cart(int id, int accountId) {
        this.id = id;
        this.accountId = accountId;
    }

    public Cart() {
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
}
