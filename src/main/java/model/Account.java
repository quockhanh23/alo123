package model;

public class Account {
    private int id ;
    private String name;
    private String password;
    private String re_password;
    private String phoneNumber;
    private String email;
    private String address;
    private int roleId;
    private double balance;
    private int statusId;
    private int age;

    public Account(int id, String name, String password, String re_password, String phoneNumber, String email, String address, int roleId, double balance, int statusId, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.re_password = re_password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.roleId = roleId;
        this.balance = balance;
        this.statusId = statusId;
        this.age = age;
    }

    public Account() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRe_password() {
        return re_password;
    }

    public void setRe_password(String re_password) {
        this.re_password = re_password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
