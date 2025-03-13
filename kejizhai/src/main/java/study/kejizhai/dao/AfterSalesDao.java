package study.kejizhai.dao;

import study.kejizhai.bean.AfterSales;
import java.sql.SQLException;
import java.util.List;

public interface AfterSalesDao {
    void addAfterSales(AfterSales afterSales) throws SQLException;
    void updateAfterSales(AfterSales afterSales) throws SQLException;
    void deleteAfterSales(int userId, int orderId, int itemId) throws SQLException;
    AfterSales getAfterSales(int userId, int orderId, int itemId) throws SQLException;
    List<AfterSales> getAfterSalesByUserId(int userId) throws SQLException;
}