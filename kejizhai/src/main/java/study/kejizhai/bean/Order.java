package study.kejizhai.bean;

import java.util.Date;
import java.util.List;

import study.kejizhai.bean.Items;
import study.kejizhai.bean.Address;
import study.kejizhai.bean.Users;

/**
 * 订单类
 * @author Administrator
 *
 */
public class Order {
    private int Oid; //订单号
    private Date orderDate;  
    private int Uid; //userId
    private String orderNumber; //订单号
    private List<Items> orderItems; 
    private double totalPrice;
    private Address orderAddress;
    private String payType;  //weixin,ali, bank;
    private int payStatus;  //paid=0,unpaid=1;
    private String deliveryStatus; //物流信息
    private String deliveryCompany;//快递公司
    private String deliveryNumber; //快递单号
    private Date payDate;  //支付日期
    private Date receiveDate; //收货日期


    public Order(){}
    public Order(int Oid, Date orderDate, int userId, String orderNumber, List<Items> orderItems, double totalPrice, Address orderAddress, String payType, int payStatus, String deliveryStatus, String deliveryCompany, String deliveryNumber, Date payDate, Date receiveDate) {
        super();
        this.Oid = Oid;
        this.orderDate = orderDate;
        this.Uid = userId;
        this.orderNumber = orderNumber;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
        this.orderAddress = orderAddress;
        this.payType = payType;
        this.payStatus = payStatus;
        this.deliveryStatus = deliveryStatus;
        this.deliveryCompany = deliveryCompany;
        this.deliveryNumber = deliveryNumber;
        this.payDate = payDate;
        this.receiveDate = receiveDate;
    }

    public int getOid() {
        return Oid;
    }
    public void setOid(int Oid) {
        this.Oid = Oid;
    }
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public int getUserId() {
        return Uid;
    }
    public void setUserId(int Uid) {
        this.Uid = Uid;
    }
    public List<Items> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<Items> orderItems) {
        this.orderItems = orderItems;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Address getAddress() {
        return orderAddress;
    }
    public void setAddress(Address orderAddress) {
        this.orderAddress = orderAddress;
    }
    
}