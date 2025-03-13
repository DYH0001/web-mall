package study.kejizhai.services;

import java.sql.SQLException;


import study.kejizhai.bean.*;

import java.util.List;

public interface OrderService {
    public List<Order> getOrders(int uid) throws SQLException;
    public boolean addOrder(Order orders) throws SQLException;
    public boolean deleteOrder(int oid) throws SQLException;
    public boolean changeOrder(Order orders) throws SQLException;
    public List<Order> searchOrders(String keyword) throws SQLException;
}