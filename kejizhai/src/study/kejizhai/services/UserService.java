import study.kejizhai.bean.*;

import java.util.List;

public interface UserService {
    public boolean login(Users users) throws SqlException;
    public User signin(Users users);
    public boolean changepsw(Users users,String newpsw);
    public boolean updateuserinfo(Users user);
    public boolean updateAddress(Users user,Address address);
}