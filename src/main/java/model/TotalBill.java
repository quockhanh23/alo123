package model;

public class TotalBill {
    private int accountId;
    private int orderId;
    private double total;

    public TotalBill(int accountId, int orderId, double total) {
        this.accountId = accountId;
        this.orderId = orderId;
        this.total = total;
    }

    public TotalBill(double total) {
        this.total = total;
    }

    public TotalBill() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
