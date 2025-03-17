package study.kejizhai.services;

import study.kejizhai.bean.Session;
import study.kejizhai.bean.Massage;
import study.kejizhai.bean.Users;

import java.sql.SQLException;
import java.util.List;

public interface SessionService {
    public void addSession(List<Users> users) throws SQLException;
    public void deleteSession(String sessionId) throws SQLException;
    public Session getSessionByID(String sessionId) throws SQLException;
    public boolean isActive(Session session) throws SQLException;
    }
    
 
    

