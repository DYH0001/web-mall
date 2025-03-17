package study.kejizhai.dao;

import java.util.List;

import study.kejizhai.bean.Users;
import study.kejizhai.bean.Session;


public interface SessionDao {
    public void addSession(List<Users> Session);

    public void deleteSession(String SessionId);

    public Session getSessionByID(String SessionId);

    public void updateSession(Session Session);
} 
