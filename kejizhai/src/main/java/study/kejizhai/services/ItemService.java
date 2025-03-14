package study.kejizhai.services;

import study.kejizhai.bean.*;
import java.util.List;
import java.sql.SQLException;  // 添加这个导入

public interface ItemService {
    public List<Items> getItems(String iid) throws SQLException;
    public boolean addItem(Items items) throws SQLException;
    public boolean updateItem(Items items) throws SQLException;
    public boolean deleteItem(int iid) throws SQLException;
    
    public List<Items> getItems() throws SQLException;
    public int setIstatus(int iid) throws SQLException;
}