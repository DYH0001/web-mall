package study.kejizhai.bean;

public class Items {
    private String Iid;
    private String Iname;
    private double price;
    private String description; //商品描述
    private String info;  //商品参数，对于不同分类的商品需要填写的参数应该不同，可能需要单独分个类？
    private String Iimage;
    private String category;  //要不要做个list或者枚举类？
    private String shop;
    private String uptime;
    private int Istatus;  //show=0;hide=1;undercarriage=3;

    public Items() {};
public Items(String Iid, String Iname, double price, String description, String Iimage, String category, String shop, String uptime, int Istatus) {
    this.Iid = Iid;
    this.Iname = Iname;
    this.price = price;
    this.description = description;
    this.Iimage = Iimage;
    this.category = category;
    this.shop = shop;
    this.uptime = uptime;
    this.Istatus = Istatus;

}
public String getIid() {
    return Iid;
}
public String getIname(String Iid){
    return Iname;
}
public void setIname(String Iid){
}
public double getPrice() {
    return price;
}
public void setPrice(int price) {
    this.price = price;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public String getIimage() {
    return Iimage;
}
public void setIimage(String Iimage) {
    this.Iimage = Iimage;
}
public String getCategory() {
    return category;
}
public void setCategory(String category) {
    this.category = category;
}
public String getShop() {
    return shop;
}
public String getUptime() {
    return uptime;
}
public int getIstatus() {
    return Istatus;
}
public void setIstatus(int Istatus) {
    this.Istatus = Istatus;
}
public String getInfo() {
    return info;
}
public void setInfo(String info) {
    this.info = info;
}
}
