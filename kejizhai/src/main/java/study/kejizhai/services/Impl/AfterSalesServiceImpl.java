package study.kejizhai.services.Impl;

import study.kejizhai.bean.Items;
import study.kejizhai.bean.Order;
import study.kejizhai.bean.Users;
import study.kejizhai.services.AfterSalesService;
import study.kejizhai.dao.AfterSalesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.kejizhai.bean.AfterSales;

import java.sql.SQLException;
import java.util.Date;

@Service
@Transactional
public class AfterSalesServiceImpl implements AfterSalesService {
    
    @Autowired
    private AfterSalesDao afterSalesDao;

    @Override
    public void addAfterSales(Users user, Order order, Items item, String reason, String type) {
        try {
            AfterSales afterSales = new AfterSales();
            afterSales.setUserId(user.getUid());
            afterSales.setOrderId(order.getOid());
            afterSales.setItemId(item.getIid());
            afterSales.setReason(reason);
            afterSales.setType(type);
            afterSales.setStatus("待处理");
            afterSales.setCreateTime(new Date());
            
            afterSalesDao.addAfterSales(afterSales);
        } catch (SQLException e) {
            throw new RuntimeException("创建售后申请失败: " + e.getMessage());
        }
    }

    @Override
    public void updateAfterSales(Users user, Order order, Items item, String reason, String type) {
        try {
            AfterSales afterSales = afterSalesDao.getAfterSales(user.getUid(), order.getOid(), item.getIid());
            if (afterSales != null) {
                afterSales.setReason(reason);
                afterSales.setType(type);
                afterSales.setUpdateTime(new Date());
                afterSalesDao.updateAfterSales(afterSales);
            }
        } catch (SQLException e) {
            throw new RuntimeException("更新售后申请失败: " + e.getMessage());
        }
    }

    @Override
    public void finishAfterSales(Users user, Order order, Items item) {
        try {
            AfterSales afterSales = afterSalesDao.getAfterSales(user.getUid(), order.getOid(), item.getIid());
            if (afterSales != null) {
                afterSales.setStatus("已完成");
                afterSales.setFinishTime(new Date());
                afterSalesDao.updateAfterSales(afterSales);
            }
        } catch (SQLException e) {
            throw new RuntimeException("完成售后申请失败: " + e.getMessage());
        }
    }

    @Override
    public void deleteAfterSales(Users user, Order order, Items item) {
        try {
            afterSalesDao.deleteAfterSales(user.getUid(), order.getOid(), item.getIid());
        } catch (SQLException e) {
            throw new RuntimeException("删除售后申请失败: " + e.getMessage());
        }
    }

    @Override
    public void queryAfterSales(Users user, Order order, Items item) {
        try {
            AfterSales afterSales = afterSalesDao.getAfterSales(user.getUid(), order.getOid(), item.getIid());
            if (afterSales == null) {
                throw new RuntimeException("未找到相关售后申请");
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询售后申请失败: " + e.getMessage());
        }
    }
}