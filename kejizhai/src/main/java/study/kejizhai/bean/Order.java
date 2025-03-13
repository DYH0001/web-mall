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
    private String Oid; //订单号
    private Date orderDate;  
    private String Uid; //userId
    private String orderNumber; //订单号
    private List<Items> orderItems; 
    private double totalPrice;
    private Address orderAddress;
    private String payType;  //weixin,ali, bank
    private int payStatus;  //paid=0,unpaid=1
    private String paymentId;  // 支付流水号
    private String paymentResponse; // 支付响应信息 // 支付时间
    private String deliveryStatus; //物流信息
    private String deliveryCompany;//快递公司
    private String deliveryNumber; //快递单号
    private Date payDate;  //支付日期
    private Date receiveDate; //收货日期


    public Order(){}
    public Order(String Oid, Date orderDate, String userId, String orderNumber, List<Items> orderItems, double totalPrice, Address orderAddress, String payType, int payStatus, String deliveryStatus, String deliveryCompany, String deliveryNumber, Date payDate, Date receiveDate) {
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

    public String getOid() {
        return Oid;
    }
    public void setOid(String Oid) {
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
    public String getUserId() {
        return Uid;
    }
    public void setUserId(String Uid) {
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
    
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    // 添加新的 getter 和 setter
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentResponse() {
        return paymentResponse;
    }

    public void setPaymentResponse(){
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus() {
    }
    public String getDeliveryStatus() {
        return deliveryStatus;
    }
    public void setDeliveryStatus() {
    }
    public String getDeliveryCompany() {
        return deliveryCompany;
    }
    public void setDeliveryCompany() {
    }
    public String getDeliveryNumber() {
        return deliveryNumber;
    }
    public void setDeliveryNumber() {
    }
    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate() {
    }
    public Date getReceiveDate() {
        return receiveDate;
    }
    public void setReceiveDate() {
    }
}