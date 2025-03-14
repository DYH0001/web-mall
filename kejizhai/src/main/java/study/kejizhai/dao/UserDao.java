package study.kejizhai.dao;

import study.kejizhai.bean.Users;
import study.kejizhai.bean.Address;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    boolean addUser(Users user) throws SQLException;
    boolean deleteUser(String uid) throws SQLException;
    boolean changeUser(Users user) throws SQLException;
    Users getUser(String uid) throws SQLException;
    List<Users> getUsers() throws SQLException;
    boolean updateuserinfo(Users user) throws SQLException;
    boolean login(Users users) throws SQLException;
    Users signin(Users users) throws SQLException;
    boolean changepsw(Users users, String newpsw) throws SQLException;
    boolean updateAddress(Users user, Address address) throws SQLException;
    boolean verifyPhone(String uid, String phone) throws SQLException;
    boolean verifyEmail(String uid, String email) throws SQLException;
}
