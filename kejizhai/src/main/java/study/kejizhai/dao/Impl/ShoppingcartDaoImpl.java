package study.kejizhai.dao.Impl;

import study.kejizhai.bean.shoppingcart;
import study.kejizhai.dao.shoppingcartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.List;

@Repository
public class shoppingcartDaoImpl implements shoppingcartDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addshoppingcart(shoppingcart shoppingcart) throws SQLException {
        String sql = "INSERT INTO shopping_cart (uid, iid, count, price) VALUES (?, ?, ?, ?)";
        try {
            int result = jdbcTemplate.update(sql,
                shoppingcart.getUid(),
                shoppingcart.getIid(),
                shoppingcart.getCount(),
                shoppingcart.getPrice()
            );
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("添加购物车数据失败", e);
        }
    }

    
    public List<shoppingcart> getshoppingcart(int Iuid) throws SQLException {
        String sql = "SELECT sc.*, i.price FROM shopping_cart sc " +
                    "JOIN items i ON sc.iid = i.iid " +
                    "WHERE sc.uid = ?";
        try {
            return jdbcTemplate.query(sql, 
                new BeanPropertyRowMapper<>(shoppingcart.class), 
                Iuid);
        } catch (Exception e) {
            throw new SQLException("查询购物车数据失败", e);
        }
    }

    
    public boolean deleteShoppingcart(int scid) throws SQLException {
        String sql = "DELETE FROM shopping_cart WHERE scid = ?";
        try {
            int result = jdbcTemplate.update(sql, scid);
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("删除购物车数据失败", e);
        }
    }
}