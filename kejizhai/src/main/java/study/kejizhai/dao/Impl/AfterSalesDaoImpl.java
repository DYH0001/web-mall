package study.kejizhai.dao.Impl;

import study.kejizhai.bean.AfterSales;
import study.kejizhai.dao.AfterSalesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class AfterSalesDaoImpl implements AfterSalesDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addAfterSales(AfterSales afterSales) throws SQLException {
        String sql = "INSERT INTO after_sales (user_id, order_id, item_id, reason, type, status, " +
                    "create_time, update_time, finish_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,
                afterSales.getUserId(),
                afterSales.getOrderId(),
                afterSales.getItemId(),
                afterSales.getReason(),
                afterSales.getType(),
                afterSales.getStatus(),
                afterSales.getCreateTime(),
                afterSales.getUpdateTime(),
                afterSales.getFinishTime()
            );
        } catch (Exception e) {
            throw new SQLException("添加售后记录失败", e);
        }
    }
@Override
    public void updateAfterSales(AfterSales afterSales) throws SQLException {
        String sql = "UPDATE after_sales SET reason=?, type=?, status=?, update_time=?, " +
                    "finish_time=? WHERE user_id=? AND order_id=? AND item_id=?";
        try {
            jdbcTemplate.update(sql,
                afterSales.getReason(),
                afterSales.getType(),
                afterSales.getStatus(),
                afterSales.getUpdateTime(),
                afterSales.getFinishTime(),
                afterSales.getUserId(),
                afterSales.getOrderId(),
                afterSales.getItemId()
            );
        } catch (Exception e) {
            throw new SQLException("更新售后记录失败", e);
        }
    }


    @Override  
    public void deleteAfterSales(String userId, String orderId, String itemId) throws SQLException {
        String sql = "DELETE FROM after_sales WHERE user_id=? AND order_id=? AND item_id=?";
        try {
            jdbcTemplate.update(sql, userId, orderId, itemId);
        } catch (Exception e) {
            throw new SQLException("删除售后记录失败", e);
        }
    }

    @Override  
    public AfterSales getAfterSales(String userId, String orderId, String itemId) throws SQLException {
        String sql = "SELECT * FROM after_sales WHERE user_id=? AND order_id=? AND item_id=?";
        try {
            List<AfterSales> results = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(AfterSales.class),
                userId, orderId, itemId);
            return results.isEmpty() ? null : results.get(0);
        } catch (Exception e) {
            throw new SQLException("查询售后记录失败", e);
        }
    }

    @Override 
    public List<AfterSales> getAfterSalesByUserId(String userId) throws SQLException {
        String sql = "SELECT * FROM after_sales WHERE user_id=? ORDER BY create_time DESC";
        try {
            return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(AfterSales.class),
                userId);
        } catch (Exception e) {
            throw new SQLException("查询用户售后记录列表失败", e);
        }
    }
}