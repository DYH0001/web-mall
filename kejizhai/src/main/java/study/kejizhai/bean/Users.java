package study.kejizhai.bean;

import study.kejizhai.bean.Order;
import study.kejizhai.bean.Address;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class Users {
    private String Uid;
    private String Uname;
    private int age;
    private String password_Hash;
    private String telephone;
    private enum role {
        guest,
        user,
        admin,
        support,}

    private String addressID;

    private boolean isPhoneVerified;
    private boolean isEmailVerified;
    private Date CreateTime;
    private Date UpdateTime;
    private List<Order> userOrders;

public Users() {
    }
public Users(String Uid, String Uname, int age, String address, String telephone, String password_Hash,String addressID, boolean isPhoneVerified, boolean isEmailVerified, Date CreateTime, Date UpdateTime) { 
        this.Uid = Uid;
        this.Uname = Uname;
        this.age = age;
        this.addressID = addressID;
        this.password_Hash = password_Hash;
        this.telephone = telephone;
        this.isPhoneVerified = isPhoneVerified;
        this.isEmailVerified = isEmailVerified;
        this.CreateTime = CreateTime;
        this.UpdateTime = UpdateTime;
        this.userOrders = userOrders;
    }





public String getUname() {
    return Uname;
}
public void setUname(String Uname) {
}
public int getAge() {
    return age;
}
public void setAge(int age) {

}
public String getAddress() {
    return addressID;
}
public void setAddress(String address) {
}
public String getTelephone() {
    return telephone;
}
public void setTelephone(String telephone) {
}
public String getPassword() {
    return password_Hash;
}
public void setPassword(String password) {
}

public String getUid() {
    return Uid;
}
public boolean isPhoneVerified() {
    return isPhoneVerified;
}
public boolean isEmailVerified() {
    return isEmailVerified;
}
public Date getCreateTime() {
    return CreateTime;
}
public Date getUpdateTime() {
    return UpdateTime;
}

// 添加缺失的 setter 方法
public void setUid(String uid) {
    this.Uid = uid;
}

public void setPhoneVerified(boolean isPhoneVerified) {
    this.isPhoneVerified = isPhoneVerified;
}

public void setEmailVerified(boolean isEmailVerified) {
    this.isEmailVerified = isEmailVerified;
}

public void setCreateTime(Date createTime) {
    this.CreateTime = createTime;
}

public void setUpdateTime(Date updateTime) {
    this.UpdateTime = updateTime;
}

public List<Order> getUserOrders() {
    return userOrders;
}

public void setUserOrders(List<Order> userOrders) {
    this.userOrders = userOrders;
}
}