package study.kejizhai.services.Impl;

import study.kejizhai.bean.*;
import study.kejizhai.services.ItemService;
import study.kejizhai.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Items> getItem(int iid) throws SqlException {
        try {
            return itemDao.getItem(iid);
        } catch (SqlException e) {
            throw new SqlException("获取商品信息失败: " + e.getMessage());
        }
    }

    @Override
    public boolean addItem(Items items) throws SqlException {
        try {
            return itemDao.addItem(items);
        } catch (SqlException e) {
            throw new SqlException("添加商品失败: " + e.getMessage());
        }
    }

    @Override
    public boolean updateItem(Items items) throws SqlException {
        try {
            return itemDao.updateItem(items);
        } catch (SqlException e) {
            throw new SqlException("更新商品信息失败: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteItem(int iid) throws SqlException {
        try {
            return itemDao.deleteItem(iid);
        } catch (SqlException e) {
            throw new SqlException("下架商品失败: " + e.getMessage());
        }
    }

    @Override
    public List<Items> getItems() throws SqlException {
        try {
            return itemDao.getItems();
        } catch (SqlException e) {
            throw new SqlException("获取商品列表失败: " + e.getMessage());
        }
    }

    @Override
    public int setIstatus(int iid) {
        try {
            return itemDao.setIstatus(iid);
        } catch (Exception e) {
            return 0; // 设置状态失败返回0
        }
    }
}