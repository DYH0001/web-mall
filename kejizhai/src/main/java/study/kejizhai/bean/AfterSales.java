package study.kejizhai.bean;

import java.util.Date;

public class AfterSales {
    private String id;
    private String userId;
    private String orderId;
    private String itemId;
    private String reason;
    private String type;    // 退款/退货退款/换货
    private String status;  // 待处理/处理中/已完成/已取消
    private Date createTime;
    private Date updateTime;
    private Date finishTime;

    // 构造函数
    public AfterSales() {}

    public AfterSales(String id, String userId, String orderId, String itemId, String reason, String type, String status, Date createTime, Date updateTime, Date finishTime) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.itemId = itemId;
        this.reason = reason;
        this.type = type;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.finishTime = finishTime;
    }

    // getter 和 setter 方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}