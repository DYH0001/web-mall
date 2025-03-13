import study.kejizhai.bean.*;

import java.util.List;

public interface OrderService {
    public List<Orders> getOrders(int uid) throws SqlException;
    public boolean addOrder(Orders orders) throws SqlException;
    public boolean deleteOrder(int oid) throws SqlException;
    public boolean changeOrder(Orders orders) throws SqlException;
    public List<Orders> searchOrders(String keyword) throws SqlException;
}