package study.kejizhai.services;

import study.kejizhai.bean.*;

import java.util.List;
import java.sql.SQLException;

public interface UserService {
    public boolean login(Users users) throws SQLException;
    public Users signin(Users users);
    public boolean changepsw(Users users,String newpsw);
    public boolean updateuserinfo(Users user);
    public boolean updateAddress(Users user,Address address);
}