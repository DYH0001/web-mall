package study.kejizhai.services.Impl;

import study.kejizhai.bean.Users;
import study.kejizhai.bean.Address;
import study.kejizhai.dao.UserDao;
import study.kejizhai.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.sql.SQLException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean login(Users users) throws SQLException {
        try {
            return userDao.login(users);
        } catch (SQLException e) {
            throw new SQLException("登录失败: " + e.getMessage());
        }
    }

    @Override
    public Users signin(Users users) throws SQLException {
        try {
            return userDao.signin(users);
        } catch (SQLException e) {
            throw new SQLException("注册失败: " + e.getMessage());
        }
    }

    @Override
    public boolean changepsw(Users users, String newpsw) throws SQLException {
        try {
            return userDao.changepsw(users, newpsw);
        } catch (SQLException e) {
            throw new SQLException("修改密码失败: " + e.getMessage());
        }
    }

    @Override
    public boolean updateuserinfo(Users user) throws SQLException {
        try {
            return userDao.updateuserinfo(user);
        } catch (SQLException e) {
            throw new SQLException("更新用户信息失败: " + e.getMessage());
        }
    }

    @Override
    public boolean updateAddress(Users user, Address address) throws SQLException {
        try {
            return userDao.updateAddress(user, address);
        } catch (SQLException e) {
            throw new SQLException("更新地址失败: " + e.getMessage());
        }
    }

    @Override
    public Users getUserById(String uid) throws SQLException {
        try {
            return userDao.getUser(uid);
        } catch (SQLException e) {
            throw new SQLException("获取用户信息失败: " + e.getMessage());
        }
    }

    @Override
    public List<Users> getAllUsers() throws SQLException {
        try {
            return userDao.getUsers();
        } catch (SQLException e) {
            throw new SQLException("获取用户列表失败: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteUser(String uid) throws SQLException {
        try {
            return userDao.deleteUser(uid);
        } catch (SQLException e) {
            throw new SQLException("删除用户失败: " + e.getMessage());
        }
    }

    @Override
    public boolean verifyPhone(String uid, String phone) throws SQLException {
        try {
            return userDao.verifyPhone(uid, phone);
        } catch (SQLException e) {
            throw new SQLException("手机验证失败: " + e.getMessage());
        }
    }

    @Override
    public boolean verifyEmail(String uid, String email) throws SQLException {
        try {
            return userDao.verifyEmail(uid, email);
        } catch (SQLException e) {
            throw new SQLException("邮箱验证失败: " + e.getMessage());
        }
    }
}
