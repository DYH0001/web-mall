package study.kejizhai.bean;
import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;



public class shoppingcart {
    private int uid;
    private ArrayList iid;
    private int count;
    private int price;

    public shoppingcart() {}

public shoppingcart(int uid, ArrayList iid, int count, int price) { 
    this.uid = uid;
    this.iid = iid;
    this.count = count;
    this.price = price;
}
public int getUid() {
    return uid;
}
public ArrayList getIid() {
    return iid;
}
public int getCount() {
    return count;
}
public int getPrice() {
    return price;
}
}