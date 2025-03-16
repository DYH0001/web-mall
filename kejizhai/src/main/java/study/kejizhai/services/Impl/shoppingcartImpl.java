package study.kejizhai.services.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.kejizhai.bean.shoppingcart;
import study.kejizhai.dao.shoppingcartDao;
import study.kejizhai.services.shoppingcartService;
@Service
public class shoppingcartImpl implements shoppingcartService {
    
    @Autowired
    private shoppingcartDao shoppingcartDao;

    @Override
    public boolean addshoppingcart(shoppingcart shoppingcart) throws SQLException {
        try {
            return shoppingcartDao.addshoppingcart(shoppingcart);
        } catch (SQLException e) {
            throw new SQLException("添加购物车失败: " + e.getMessage());
        }
    }

    @Override
    public List<shoppingcart> getshoppingcart(int Iuid) throws SQLException {
        try {
            return shoppingcartDao.getshoppingcart(Iuid);
        } catch (SQLException e) {
            throw new SQLException("获取购物车列表失败: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteShoppingcart(int scid) throws SQLException {
        try {
            return shoppingcartDao.deleteShoppingcart(scid);
        } catch (SQLException e) {
            throw new SQLException("删除购物车项目失败: " + e.getMessage());
        }
    }

    @Override
    public double cartValue(int Iuid, int Inums) {
        try {
            List<shoppingcart> cartItems = shoppingcartDao.getshoppingcart(Iuid);
            double totalValue = 0.0;
            for (shoppingcart item : cartItems) {
                totalValue += item.getPrice() * item.getCount();
            }
            return totalValue;
        } catch (Exception e) {
            return 0.0; // 计算购物车总价失败返回0
        }
    }
}
