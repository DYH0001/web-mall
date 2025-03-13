import  study.kejizhai.bean.Items;
import study.kejizhai.bean.Orders;
import study.kejizhai.bean.Users;

import study.kejizhai.services.ItemService;
import study.kejizhai.services.OrderService;
import study.kejizhai.services.UserService;

public interface AfterSalesService {
    public void  addAfterSales(Users user, Orders order, Items item, String reason, String type);
    public void  updateAfterSales(Users user, Orders order, Items item, String reason, String type);
    public void  finishAfterSales(Users user, Orders order, Items item);
    public void  deleteAfterSales(Users user, Orders order, Items item);
    public void  queryAfterSales(Users user, Orders order, Items item);
}