import study.kejizhai.bean.Users;
import study.kejizhai.bean.Items;
import study.kejizhai.bean.shoppingcart;
import study.kejizhai.services.shop;

import java.util.List;

public interface shoppingcartService {
    public boolean addshoppingcart(shoppingcart shoppingcart) throws SqlException;
    public List<shoppingcart> getshoppingcart(int Iuid) throws SqlException;
    public boolean deleteShoppingcart(int scid) throws SqlException;
    public double cartValue(int Iuid,int Inums);
}