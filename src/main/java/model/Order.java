package model;

public class Order {
    private int id;
    private int accountId;
    private String time;
    private int status;

    public Order(int id, int accountId, String time, int status) {
        this.id = id;
        this.accountId = accountId;
        this.time = time;
        this.status = status;
    }

    public Order() {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
