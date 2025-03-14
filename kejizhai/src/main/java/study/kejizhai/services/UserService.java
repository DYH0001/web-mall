package study.kejizhai.services;

import study.kejizhai.bean.*;
import java.util.List;
import java.sql.SQLException;

public interface UserService {
    boolean login(Users users) throws SQLException;
    Users signin(Users users) throws SQLException;
    boolean changepsw(Users users, String newpsw) throws SQLException;
    boolean updateuserinfo(Users user) throws SQLException;
    boolean updateAddress(Users user, Address address) throws SQLException;
    Users getUserById(String uid) throws SQLException;
    List<Users> getAllUsers() throws SQLException;
    boolean deleteUser(String uid) throws SQLException;
    boolean verifyPhone(String uid, String phone) throws SQLException;
    boolean verifyEmail(String uid, String email) throws SQLException;
}