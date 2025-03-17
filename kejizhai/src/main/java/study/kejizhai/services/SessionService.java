package study.kejizhai.services;

import study.kejizhai.bean.Session;
import study.kejizhai.bean.Massage;
import study.kejizhai.bean.Users;

import java.sql.SQLException;
import java.util.List;

public interface SessionService {
    public void addSession(List<Users> users);
    public void deleteSession(String sessionId);
    public Session getSessionByID(String sessionId);
    public boolean isActive(Session session);
    }
    
 
    

