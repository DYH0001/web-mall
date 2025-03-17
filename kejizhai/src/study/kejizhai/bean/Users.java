package study.kejizhai.bean;

import java.util.Date;

public class Users {
    private String Uuid;
    private String Uname;
    private int age;
    private String password_Hash;
    private String telephone;




private enum role {
    guest,
    user,
    admin,
    support,
}

private boolean isPhoneVerified;
private boolean isEmailVerified;
private boolean CreateTime;
private boolean UpdateTime;


public Users(String Uuid, String Uname, int age, String address, String password, String telephone) { 
        this.Uuid = Uuid;
        this.Uname = Uname;
        this.age = age;
        this.address = address;
        this.password = password;
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
public String getTelephone() {
    return telephone;
}
public void setTelephone(String telephone) {
}
public String getPassword() {
    return password_hash;
}
public void setPassword(String password) {
}

public String getUuid() {
    return Uuid;
}
}