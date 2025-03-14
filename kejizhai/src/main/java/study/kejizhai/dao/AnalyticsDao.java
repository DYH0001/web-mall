package study.kejizhai.dao;

import study.kejizhai.bean.Items;
import study.kejizhai.bean.Users;
import study.kejizhai.bean.review;
import study.kejizhai.bean.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;

public interface AnalyticsDao {
    List<review> getUserReviews(String userId) throws SQLException;
    List<Items> getUserPurchasedItems(String userId) throws SQLException;
    List<Order> getUserOrders(String userId) throws SQLException;
    double getItemCost(String itemId) throws SQLException;
    List<Order> getOrdersByDateRange(String userId, Date startDate, Date endDate) throws SQLException;
    int getRepeatPurchaseCount(String userId, String itemId) throws SQLException;
    double getTotalRevenue(String userId) throws SQLException;
    double getAverageOrderValue(String userId) throws SQLException;
}