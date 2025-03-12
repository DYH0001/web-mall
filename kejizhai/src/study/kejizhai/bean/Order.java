package study.kejizhai.bean;

import java.util.Date;
import java.util.List;

import study.kejizhai.bean.Item;
import study.kejizhai.bean.Address;
import study.kejizhai.bean.User;

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
    private List<Item> orderItems; 
    private double totalPrice;
    private Address OrderAddress;
    private String payType;  //weixin,ali, bank;
    private int payStatus;  //paid=0,unpaid=1;
    private String deliveryStatus; //物流信息
    private String deliveryCompany;//快递公司
    private String deliveryNumber; //快递单号
    private Date payDate;  //支付日期
    private Date receiveDate; //收货日期


    public Order(){}
    public Order(int Oid, Date orderDate, int userId, String orderNumber, List<Item> orderItems, double totalPrice, Address address, String payType, int payStatus, String deliveryStatus, String deliveryCompany, String deliveryNumber, Date payDate, Date receiveDate) {
        super();
        this.Oid = Oid;
        this.orderDate = orderDate;
        this.Uid = userId;
        this.orderNumber = orderNumber;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
        this.Address = address;
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
    public void setOid(int id) {
        this.id = id;
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
        return uid;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public List<Item> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(Address OrderAddress) {
        this.Orderaddress = address;
    }
    
}