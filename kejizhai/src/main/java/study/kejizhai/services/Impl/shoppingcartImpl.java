package study.kejizhai.services.Impl;

import study.kejizhai.bean.Users;
import study.kejizhai.bean.Items;
import study.kejizhai.bean.shoppingcart;
import study.kejizhai.services.shoppingcartService;
import study.kejizhai.dao.ShoppingcartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class shoppingcartImpl implements shoppingcartService {
    
    @Autowired
    private ShoppingcartDao shoppingcartDao;

    @Override
    public boolean addshoppingcart(shoppingcart shoppingcart) throws SqlException {
        try {
            return shoppingcartDao.addshoppingcart(shoppingcart);
        } catch (SqlException e) {
            throw new SqlException("添加购物车失败: " + e.getMessage());
        }
    }

    @Override
    public List<shoppingcart> getshoppingcart(int Iuid) throws SqlException {
        try {
            return shoppingcartDao.getshoppingcart(Iuid);
        } catch (SqlException e) {
            throw new SqlException("获取购物车列表失败: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteShoppingcart(int scid) throws SqlException {
        try {
            return shoppingcartDao.deleteShoppingcart(scid);
        } catch (SqlException e) {
            throw new SqlException("删除购物车项目失败: " + e.getMessage());
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
