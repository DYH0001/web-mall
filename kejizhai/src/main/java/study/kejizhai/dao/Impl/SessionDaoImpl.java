package study.kejizhai.dao.Impl;

import study.kejizhai.dao.SessionDao;
import study.kejizhai.bean.Session;
import study.kejizhai.bean.Users;
import study.kejizhai.bean.Massage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class SessionDaoImpl implements SessionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addSession(List<Users> users) {
        try {
            // 生成会话ID
            String sessionId = UUID.randomUUID().toString().replace("-", "");
            
            // 创建会话记录
            String sql = "INSERT INTO sessions (session_id, start_time, is_active) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, sessionId, new Date(), true);
            
            // 添加用户到会话中
            for (Users user : users) {
                String userSessionSql = "INSERT INTO user_sessions (session_id, user_id) VALUES (?, ?)";
                jdbcTemplate.update(userSessionSql, sessionId, user.getUid());
            }
        } catch (Exception e) {
            throw new RuntimeException("创建会话失败: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteSession(String sessionId) {
        try {
            // 先删除用户会话关联
            jdbcTemplate.update("DELETE FROM user_sessions WHERE session_id = ?", sessionId);
            
            // 删除会话消息
            jdbcTemplate.update("DELETE FROM messages WHERE session_id = ?", sessionId);
            
            // 删除会话
            jdbcTemplate.update("DELETE FROM sessions WHERE session_id = ?", sessionId);
        } catch (Exception e) {
            throw new RuntimeException("删除会话失败: " + e.getMessage(), e);
        }
    }

    @Override
    public Session getSessionByID(String sessionId) {
        try {
            // 查询会话基本信息
            String sql = "SELECT * FROM sessions WHERE session_id = ?";
            Session session = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Session.class), sessionId);
            
            if (session != null) {
                // 查询会话中的用户
                String userSql = "SELECT u.* FROM users u JOIN user_sessions us ON u.uid = us.user_id WHERE us.session_id = ?";
                List<Users> users = jdbcTemplate.query(userSql, new BeanPropertyRowMapper<>(Users.class), sessionId);
                session.setUsers(users);
                
                // 查询会话中的消息
                String messageSql = "SELECT * FROM messages WHERE session_id = ? ORDER BY send_time ASC";
                List<Massage> messages = jdbcTemplate.query(messageSql, new BeanPropertyRowMapper<>(Massage.class), sessionId);
                session.setMassages(messages);
            }
            
            return session;
        } catch (Exception e) {
            throw new RuntimeException("获取会话失败: " + e.getMessage(), e);
        }
    }

    @Override
    public void updateSession(Session session) {
        try {
            String sql = "UPDATE sessions SET end_time = ?, is_active = ? WHERE session_id = ?";
            jdbcTemplate.update(sql, 
                session.getEndTime(), 
                session.getIsActive(), 
                session.getSessionId());
        } catch (Exception e) {
            throw new RuntimeException("更新会话失败: " + e.getMessage(), e);
        }
    }
}
