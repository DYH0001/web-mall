package study.kejizhai.bean;

public class Address {
    private String Address_telephone;
    private String AddressID;
    private String province;
    private String city;
    private String Street;
    private String detail;


public Address( String telephone, String AddressID, String province, String city, String Street, String detail) {
    this.telephone = telephone;
    this.AddressID = AddressID;
    this.province = province;
    this.city = city;
    this.Street = Street;
    this.detail = detail;
}
}