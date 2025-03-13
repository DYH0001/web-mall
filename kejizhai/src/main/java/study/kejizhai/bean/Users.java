package study.kejizhai.bean;


import study.kejizhai.bean.Address;
import java.util.Date;


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

public Users() {
    }
public Users(String Uid, String Uname, int age, String address, String telephone, String password_Hash,String addressID) { 
        this.Uid = Uid;
        this.Uname = Uname;
        this.age = age;
        this.addressID = addressID;
        this.password_Hash = password_Hash;
        this.telephone = telephone;
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
}