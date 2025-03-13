import study.kejizhai.bean.*;

public interface ItemService {
    public List<Items> getItem(int iid) throws SqlException; //search
    public boolean addItem(Items items) throws SqlException;  //上架
    public boolean updateItem(Items items) throws SqlException; //更新
    public boolean deleteItem(int iid) throws SqlException; //下架
    
    public List<Items> getItems() throws SqlException;
    public int setIstatus(int iid);
}