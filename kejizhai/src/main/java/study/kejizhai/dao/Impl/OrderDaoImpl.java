package study.kejizhai.dao.Impl;
import study.kejizhai.bean.Order;
import study.kejizhai.bean.Items;
import study.kejizhai.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> getOrders(String uid) throws SQLException {
        String sql = "SELECT o.*, oi.iid, oi.count, oi.price FROM orders o " +
                    "LEFT JOIN order_items oi ON o.oid = oi.oid " +
                    "WHERE o.uid = ?";
        try {
            return jdbcTemplate.query(sql, 
                new BeanPropertyRowMapper<>(Order.class), 
                uid);
        } catch (Exception e) {
            throw new SQLException("查询订单列表失败", e);
        }
    }

    @Override
    @Transactional
    public boolean addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (uid, order_number, order_date, total_price, " +
                    "pay_type, pay_status, delivery_status, delivery_company, " +
                    "delivery_number, pay_date, receive_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            int result = jdbcTemplate.update(sql,
                order.getUserId(),
                order.getOrderNumber(),
                order.getOrderDate(),
                order.getTotalPrice(),
                order.getPayType(),      
                order.getPayStatus(),
                order.getDeliveryStatus(),
                order.getDeliveryCompany(),
                order.getDeliveryNumber(),
                order.getPayDate(),
                order.getReceiveDate()
            );
            
            if (result > 0 && order.getOrderItems() != null) {
                String itemSql = "INSERT INTO order_items (oid, iid, count, price) VALUES (?, ?, ?, ?)";
                for (Items item : order.getOrderItems()) {
                    jdbcTemplate.update(itemSql,
                        order.getOid(),
                        item.getIid(),
                        1,  // 默认数量为1
                        item.getPrice()
                    );
                }
            }
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("添加订单失败", e);
        }
    }

    @Override
    @Transactional
    public boolean deleteOrder(String oid) throws SQLException {
        try {
            String deleteItemsSql = "DELETE FROM order_items WHERE oid = ?";
            jdbcTemplate.update(deleteItemsSql, oid);
            
            String deleteOrderSql = "DELETE FROM orders WHERE oid = ?";
            int result = jdbcTemplate.update(deleteOrderSql, oid);
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("删除订单失败", e);
        }
    }

    @Override
    public boolean changeOrder(Order order) throws SQLException {
        String sql = "UPDATE orders SET pay_status = ?, delivery_status = ?, " +
                    "delivery_company = ?, delivery_number = ?, " +
                    "pay_date = ?, receive_date = ? WHERE oid = ?";
        try {
            int result = jdbcTemplate.update(sql,
                order.getPayStatus(),
                order.getDeliveryStatus(),
                order.getDeliveryCompany(),
                order.getDeliveryNumber(),
                order.getPayDate(),
                order.getReceiveDate(),
                order.getOid()
            );
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("修改订单失败", e);
        }
    }

    @Override
    public List<Order> searchOrders(String keyword) throws SQLException {
        String sql = "SELECT * FROM orders WHERE order_number LIKE ? OR delivery_number LIKE ?";
        String searchPattern = "%" + keyword + "%";
        try {
            return jdbcTemplate.query(sql, 
                new BeanPropertyRowMapper<>(Order.class),
                searchPattern, searchPattern);
        } catch (Exception e) {
            throw new SQLException("搜索订单失败", e);
        }
    }
}