package study.kejizhai.dao;

import study.kejizhai.bean.Users;


import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    boolean addUser(Users user) throws SQLException;
    boolean deleteUser(String uid) throws SQLException;
    boolean changeUser(Users user) throws SQLException;
    Users getUser(String uid) throws SQLException;
    List<Users> getUsers() throws SQLException;
}
