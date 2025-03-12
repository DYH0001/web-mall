public class shop {
    private int usid;
    private int uid;
    private int Iid;
    private int count;
    private int inum;

public shop(int usid, int uid, int iid, int count, int inum) {
        this.usid = usid;
        this.uid = uid;
        this.Iid = iid;
        this.count = count;
        this.inum = inum;
    }

    public int getUsid() {
        return usid;
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
