package service;



import model.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDAO {
    List<Account> findAll();

    void add(Account account) throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean update(Account account) throws SQLException;

    public Account findById(int id);
    public void pay(int id,double total);
}
