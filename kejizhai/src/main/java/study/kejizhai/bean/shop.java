package study.kejizhai.bean;
public class shop {
    private int sid;
    private int uid;
    private int Iid;
    private int count;
    private int inum;

    public shop() {
    }

public shop(int sid, int uid, int iid, int count, int inum) {
        this.sid = sid;
        this.uid = uid;
        this.Iid = iid;
        this.count = count;
        this.inum = inum;
    }


    public int getsid() {
        return sid;
    }
    public int getUid(){
        return uid;
    }
    public int getIid(){
        return Iid;
    }
    public int getCount(){
        return count;
    }
    public int getInum(){
        return inum;
    }
    }
