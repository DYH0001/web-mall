

import study.kejizhai.bean.Users;
import study.kejizhai.dao.UserDao;
import study.kejizhai.dao.Impl.UserDaoImpl;
import study.kejizhai.services.UserService;
import java.util.List;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Users login(Users users) throws SQLException {
        try {
            return userDao.login(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Users signin(Users users) {
        try {
            return userDao.signin(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean changepsw(Users users,String newpsw) {
        try {
            return userDao.changepsw(users,newpsw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateuserinfo(Users user) {
        try {
            return userDao.updateuserinfo(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }