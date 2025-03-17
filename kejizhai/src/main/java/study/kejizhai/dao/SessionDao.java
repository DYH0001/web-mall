package study.kejizhai.dao;

import java.util.List;

import study.kejizhai.bean.Users;
import study.kejizhai.bean.Session;

import java.sql.SQLException;


public interface SessionDao {
    public void addSession(List<Users> Session) throws SQLException;

    public void deleteSession(String SessionId) throws SQLException;

    public Session getSessionByID(String SessionId) throws SQLException;

    public void updateSession(Session Session) throws SQLException;
} 
