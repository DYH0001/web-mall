package study.kejizhai.services;

import  study.kejizhai.bean.Items;
import study.kejizhai.bean.Order;
import study.kejizhai.bean.Users;

import study.kejizhai.services.ItemService;
import study.kejizhai.services.OrderService;
import study.kejizhai.services.UserService;

public interface AfterSalesService {
    public void  addAfterSales(Users user, Order order, Items item, String reason, String type);
    public void  updateAfterSales(Users user, Order order, Items item, String reason, String type);
    public void  finishAfterSales(Users user, Order order, Items item);
    public void  deleteAfterSales(Users user, Order order, Items item);
    public void  queryAfterSales(Users user, Order order, Items item);
}