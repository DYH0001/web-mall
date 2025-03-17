package study.kejizhai.dao;

import study.kejizhai.bean.Massage;


import java.sql.SQLException;

import java.util.List;

public interface MassageDao {
    void sendMassage(Massage massage) throws SQLException;

    void deleteMassage(String MassageId) throws SQLException;

    void withdrawMessage(String MassageId) throws SQLException;

    Massage getMassageByID(String MassageId) throws SQLException;

    boolean isRead(Massage massage) throws SQLException;
}
