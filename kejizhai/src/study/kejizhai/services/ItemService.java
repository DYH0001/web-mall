import study.kejizhai.bean.*;

public interface ItemService {
    public Items getItem(int iid) throws SqlException;
    public boolean addItem(Items items) throws SqlException;
    public boolean updateItem(Items items) throws SqlException;
    public boolean deleteItem(int iid) throws SqlException;
    public List<Items> searchItems(String keyword) throws SqlException;
    public List<Items> getItems() throws SqlException;
    public int setIstatus(int iid);
}