package model;

public class Order {
    private int id;
    private int accountId;
    private String time;
    private String status;
    private String address;

    public Order(int id, int accountId, String time, String status,String address) {
        this.id = id;
        this.accountId = accountId;
        this.time = time;
        this.status = status;
        this.address=address;
    }

    public Order() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
