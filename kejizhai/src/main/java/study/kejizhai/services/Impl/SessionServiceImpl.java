package study.kejizhai.services.Impl;

import study.kejizhai.bean.Session;
import study.kejizhai.dao.SessionDao;
import study.kejizhai.bean.Massage;
import study.kejizhai.services.SessionService;
import study.kejizhai.bean.Users;

import java.util.Date;
import java.util.List;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionDao sessionDao;

    @Override
    public void addSession(List<Users> users) {
        try {
            sessionDao.addSession(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deleteSession(String sessionId) {
        try {
            sessionDao.deleteSession(sessionId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Session getSessionByID(String sessionId) {
        try {
            return sessionDao.getSessionByID(sessionId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public boolean isActive(Session session) {
        if (session == null) {
            return false;
        }
        
        // 检查会话是否标记为活跃
        if (!session.getIsActive()) {
            return false;
        }
        Date currentTime = new Date();
        if (session.getEndTime() != null && currentTime.after(session.getEndTime())) {
            // 会话已过期，更新状态
            try {
                session.setIsActive(false);
                sessionDao.updateSession(session);
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        return true;
    }
}
