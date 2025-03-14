package study.kejizhai.bean;

public class Address {
    private String Address_telephone;
    private String AddressID;
    private String province;
    private String city;
    private String Street;
    private String detail;

    public Address() {};

public Address( String Address_telephone, String AddressID, String province, String city, String Street, String detail) {
    this.Address_telephone = Address_telephone;
    this.AddressID = AddressID;
    this.province = province;
    this.city = city;
    this.Street = Street;
    this.detail = detail;
}
public String getAddress_telephone() {
        return Address_telephone;
    }

    public void setAddress_telephone(String address_telephone) {
        Address_telephone = address_telephone;
    }

    public String getAddressID() {
        return AddressID;
    }

    public void setAddressID(String addressID) {
        AddressID = addressID;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}