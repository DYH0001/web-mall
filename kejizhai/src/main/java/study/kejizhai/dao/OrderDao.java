package study.kejizhai.dao;

import study.kejizhai.bean.Order;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    List<Order> getOrders(String uid) throws SQLException;
    boolean addOrder(Order order) throws SQLException;
    boolean deleteOrder(String oid) throws SQLException;
    boolean changeOrder(Order order) throws SQLException;
    List<Order> searchOrders(String keyword) throws SQLException;
}
