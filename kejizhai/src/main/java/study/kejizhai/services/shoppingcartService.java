package study.kejizhai.services;

import java.sql.SQLException;
import java.util.List;

import study.kejizhai.bean.shoppingcart;

public interface shoppingcartService {
    public boolean addshoppingcart(shoppingcart shoppingcart) throws SQLException;
    public List<shoppingcart> getshoppingcart(int Iuid) throws SQLException;
    public boolean deleteShoppingcart(int scid) throws SQLException;
    public double cartValue(int Iuid,int Inums);
}