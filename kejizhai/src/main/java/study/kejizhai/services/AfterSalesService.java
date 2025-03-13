package study.kejizhai.services;

import study.kejizhai.bean.Items;
import study.kejizhai.bean.Order;
import study.kejizhai.bean.Users;

public interface AfterSalesService {
    void addAfterSales(Users user, Order order, Items item, String reason, String type);
    void updateAfterSales(Users user, Order order, Items item, String reason, String type);
    void finishAfterSales(Users user, Order order, Items item);
    void deleteAfterSales(Users user, Order order, Items item);
    void queryAfterSales(Users user, Order order, Items item);
}