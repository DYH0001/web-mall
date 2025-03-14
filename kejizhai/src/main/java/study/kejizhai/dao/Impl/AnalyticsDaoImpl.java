package study.kejizhai.dao.Impl;

import study.kejizhai.dao.AnalyticsDao;
import study.kejizhai.bean.Items;
import study.kejizhai.bean.Users;
import study.kejizhai.bean.review;
import study.kejizhai.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;

@Repository
@Transactional
public class AnalyticsDaoImpl implements AnalyticsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<review> getUserReviews(String userId) throws SQLException {
        String sql = "SELECT * FROM reviews WHERE uid = ?";
        try {
            return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(review.class),
                userId);
        } catch (Exception e) {
            throw new SQLException("获取用户评价失败: " + e.getMessage());
        }
    }

    @Override
    public List<Items> getUserPurchasedItems(String userId) throws SQLException {
        String sql = "SELECT DISTINCT i.* FROM items i " +
                    "JOIN order_items oi ON i.iid = oi.item_id " +
                    "JOIN orders o ON oi.order_id = o.oid " +
                    "WHERE o.uid = ? AND o.pay_status = 0";
        try {
            return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Items.class),
                userId);
        } catch (Exception e) {
            throw new SQLException("获取用户购买商品失败: " + e.getMessage());
        }
    }

    @Override
    public List<Order> getUserOrders(String userId) throws SQLException {
        String sql = "SELECT * FROM orders WHERE uid = ? AND pay_status = 0 ORDER BY order_date DESC";
        try {
            return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Order.class),
                userId);
        } catch (Exception e) {
            throw new SQLException("获取用户订单失败: " + e.getMessage());
        }
    }

    @Override
    public double getItemCost(String itemId) throws SQLException {
        String sql = "SELECT cost_price FROM items WHERE iid = ?";
        try {
            return jdbcTemplate.queryForObject(sql, Double.class, itemId);
        } catch (Exception e) {
            throw new SQLException("获取商品成本失败: " + e.getMessage());
        }
    }

    @Override
    public List<Order> getOrdersByDateRange(String userId, Date startDate, Date endDate) throws SQLException {
        String sql = "SELECT * FROM orders WHERE uid = ? AND order_date BETWEEN ? AND ? AND pay_status = 0";
        try {
            return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Order.class),
                userId, startDate, endDate);
        } catch (Exception e) {
            throw new SQLException("获取时间范围内订单失败: " + e.getMessage());
        }
    }

    @Override
    public int getRepeatPurchaseCount(String userId, String itemId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM orders o " +
                    "JOIN order_items oi ON o.oid = oi.order_id " +
                    "WHERE o.uid = ? AND oi.item_id = ? AND o.pay_status = 0";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class, userId, itemId);
        } catch (Exception e) {
            throw new SQLException("获取重复购买次数失败: " + e.getMessage());
        }
    }

    @Override
    public double getTotalRevenue(String userId) throws SQLException {
        String sql = "SELECT SUM(total_price) FROM orders WHERE uid = ? AND pay_status = 0";
        try {
            Double result = jdbcTemplate.queryForObject(sql, Double.class, userId);
            return result != null ? result : 0.0;
        } catch (Exception e) {
            throw new SQLException("获取总收入失败: " + e.getMessage());
        }
    }

    @Override
    public double getAverageOrderValue(String userId) throws SQLException {
        String sql = "SELECT AVG(total_price) FROM orders WHERE uid = ? AND pay_status = 0";
        try {
            Double result = jdbcTemplate.queryForObject(sql, Double.class, userId);
            return result != null ? result : 0.0;
        } catch (Exception e) {
            throw new SQLException("获取平均订单金额失败: " + e.getMessage());
        }
    }
}