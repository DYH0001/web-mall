study.kejizhai.bean

public class Items {
    private String Iid;
    private String Iname;
    private int price;
    private String description;
    private String Iimage;
    private String category;
    private String shop;
    private String uptime;
    private int Istatus;  //show=0;hide=1;undercarriage=3;
}

public Items(String Iid, String Iname, int price, String description, String Iimage, String category, String shop, String uptime, int Istatus) {
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
public String getIname(String Iid){ {
    return Iname;
}
public void setIname(String Iid){
}
