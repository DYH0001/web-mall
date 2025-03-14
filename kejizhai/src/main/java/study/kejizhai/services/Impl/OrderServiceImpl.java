package study.kejizhai.services.Impl;

import study.kejizhai.bean.*;
import study.kejizhai.services.OrderService;
import study.kejizhai.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.sql.SQLException;

@Service
public class OrderServiceImpl implements OrderService {

    
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getOrders(String uid) throws SQLException {
        try {
            return orderDao.getOrders(uid);
        } catch (SQLException e) {
            throw new SQLException("获取订单列表失败: " + e.getMessage());
        }
    }

    @Override
    public boolean addOrder(Order orders) throws SQLException {
        try {
            return orderDao.addOrder(orders);
        } catch (SQLException e) {
            throw new SQLException("添加订单失败: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteOrder(String oid) throws SQLException {
        try {
            return orderDao.deleteOrder(oid);
        } catch (SQLException e) {
            throw new SQLException("删除订单失败: " + e.getMessage());
        }
    }

    @Override
    public boolean changeOrder(Order orders) throws SQLException {
        try {
            return orderDao.changeOrder(orders);
        } catch (SQLException e) {
            throw new SQLException("修改订单失败: " + e.getMessage());
        }
    }

    @Override
    public List<Order> searchOrders(String keyword) throws SQLException {
        try {
            return orderDao.searchOrders(keyword);
        } catch (SQLException e) {
            throw new SQLException("搜索订单失败: " + e.getMessage());
        }
    }
}
