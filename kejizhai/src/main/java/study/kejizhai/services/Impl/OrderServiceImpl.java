package study.kejizhai.services.Impl;

import study.kejizhai.bean.*;
import study.kejizhai.services.OrderService;
import study.kejizhai.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> getOrders(int uid) throws SqlException {
        try {
            return orderDao.getOrders(uid);
        } catch (SqlException e) {
            throw new SqlException("获取订单列表失败: " + e.getMessage());
        }
    }

    @Override
    public boolean addOrder(Orders orders) throws SqlException {
        try {
            return orderDao.addOrder(orders);
        } catch (SqlException e) {
            throw new SqlException("添加订单失败: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteOrder(int oid) throws SqlException {
        try {
            return orderDao.deleteOrder(oid);
        } catch (SqlException e) {
            throw new SqlException("删除订单失败: " + e.getMessage());
        }
    }

    @Override
    public boolean changeOrder(Orders orders) throws SqlException {
        try {
            return orderDao.changeOrder(orders);
        } catch (SqlException e) {
            throw new SqlException("修改订单失败: " + e.getMessage());
        }
    }

    @Override
    public List<Orders> searchOrders(String keyword) throws SqlException {
        try {
            return orderDao.searchOrders(keyword);
        } catch (SqlException e) {
            throw new SqlException("搜索订单失败: " + e.getMessage());
        }
    }
}
