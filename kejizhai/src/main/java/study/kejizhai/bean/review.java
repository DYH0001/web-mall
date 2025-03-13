package study.kejizhai.bean;
import java.util.List;

public class review{
    private int Iid;
    private int Oid;
    private int sid;
    private int Ireview;//0-5rank;
    private String Icomment;
    private String Uid;

public review(){}

public review(int Iid,int Oid,int sid,int Ireview,String Icomment){
    this.Iid=Iid;
    this.Oid=Oid;
    this.sid=sid;
    this.Ireview=Ireview;  
    this.Icomment=Icomment;
    this.Uid=Uid;
}

public int getIid(){
    return Iid;
}


public int getOid(){
    return Oid;
}


public int getSid(){
    return sid;
}
public int getIreview(){
    return Ireview;
}
public String getIcomment(){
    return Icomment;
}
public String getUid(){
    return Uid;
}
public void setIcomment(int Iid,int Oid,String Uid){
    this.Iid=Iid;
    this.Oid=Oid;
    this.Uid=Uid;
}
}