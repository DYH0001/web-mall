package study.kejizhai.dao.Impl;

import study.kejizhai.bean.Users;
import study.kejizhai.dao.UserDao;
import study.kejizhai.bean.Address;
import study.kejizhai.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean addUser(Users user) throws SQLException {
        String sql = "INSERT INTO users (uid, uname, age, password_hash, telephone, address_id, " +
                    "is_phone_verified, is_email_verified, create_time, update_time) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            int result = jdbcTemplate.update(sql,
                user.getUid(),
                user.getUname(),
                user.getAge(),
                user.getPassword(),
                user.getTelephone(),
                user.getAddress(),
                user.isPhoneVerified(),
                user.isEmailVerified(),
                new Date(),
                new Date()
            );
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("添加用户失败: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteUser(String uid) throws SQLException {
        String sql = "DELETE FROM users WHERE uid = ?";
        try {
            int result = jdbcTemplate.update(sql, uid);
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("删除用户失败: " + e.getMessage());
        }
    }

    @Override
    public boolean changeUser(Users user) throws SQLException {
        String sql = "UPDATE users SET uname=?, age=?, telephone=?, address_id=?, " +
                    "is_phone_verified=?, is_email_verified=?, update_time=? WHERE uid=?";
        try {
            int result = jdbcTemplate.update(sql,
                user.getUname(),
                user.getAge(),
                user.getTelephone(),
                user.getAddress(),
                user.isPhoneVerified(),
                user.isEmailVerified(),
                new Date(),
                user.getUid()
            );
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("更新用户信息失败: " + e.getMessage());
        }
    }

    @Override
    public Users getUser(String uid) throws SQLException {
        String sql = "SELECT * FROM users WHERE uid = ?";
        try {
            List<Users> users = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Users.class), uid);
            return users.isEmpty() ? null : users.get(0);
        } catch (Exception e) {
            throw new SQLException("查询用户失败: " + e.getMessage());
        }
    }

    @Override
    public List<Users> getUsers() throws SQLException {
        String sql = "SELECT * FROM users";
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Users.class));
        } catch (Exception e) {
            throw new SQLException("查询用户列表失败: " + e.getMessage());
        }
    }

    @Override
    public boolean login(Users users) throws SQLException {
        String sql = "SELECT * FROM users WHERE uid = ? AND password_hash = ?";
        try {
            List<Users> result = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Users.class),
                users.getUid(),
                users.getPassword()
            );
            return result.isEmpty() ? false : true;
        } catch (Exception e) {
            throw new SQLException("用户登录失败: " + e.getMessage());
        }
    }

    public Users signin(Users users) throws SQLException {
        if (addUser(users)) {
            return getUser(users.getUid());
        }
        return null;
    }

    public boolean changepsw(Users users, String newpsw) throws SQLException {
        String sql = "UPDATE users SET password_hash = ?, update_time = ? WHERE uid = ? AND password_hash = ?";
        try {
            int result = jdbcTemplate.update(sql,
                newpsw,
                new Date(),
                users.getUid(),
                users.getPassword()
            );
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("修改密码失败: " + e.getMessage());
        }
    }

    public boolean updateuserinfo(Users user) throws SQLException {
        return changeUser(user);
    }

    @Override
    public boolean updateAddress(Users user, Address address) throws SQLException {
        String sql = "UPDATE users SET address_id = ?, update_time = ? WHERE uid = ?";
        try {
            int result = jdbcTemplate.update(sql,
                address.getAddressID(),
                new Date(),
                user.getUid()
            );
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("更新地址失败: " + e.getMessage());
        }
    }

    @Override
    public boolean verifyPhone(String uid, String phone) throws SQLException {
        String sql = "UPDATE users SET telephone = ?, is_phone_verified = true, update_time = ? WHERE uid = ?";
        try {
            int result = jdbcTemplate.update(sql, phone, new Date(), uid);
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("手机验证失败: " + e.getMessage());
        }
    }

    @Override
    public boolean verifyEmail(String uid, String email) throws SQLException {
        String sql = "UPDATE users SET email = ?, is_email_verified = true, update_time = ? WHERE uid = ?";
        try {
            int result = jdbcTemplate.update(sql, email, new Date(), uid);
            return result > 0;
        } catch (Exception e) {
            throw new SQLException("邮箱验证失败: " + e.getMessage());
        }
    }
}


