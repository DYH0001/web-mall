package study.kejizhai.services;

import study.kejizhai.bean.Users;
import study.kejizhai.bean.Items;
import study.kejizhai.bean.shoppingcart;
import study.kejizhai.bean.shop;

import java.util.List;
import java.sql.SQLException;

public interface shoppingcartService {
    public boolean addshoppingcart(shoppingcart shoppingcart) throws SQLException;
    public List<shoppingcart> getshoppingcart(int Iuid) throws SQLException;
    public boolean deleteShoppingcart(int scid) throws SQLException;
    public double cartValue(int Iuid,int Inums);
}