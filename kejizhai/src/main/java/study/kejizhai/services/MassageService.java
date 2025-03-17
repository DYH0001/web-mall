package study.kejizhai.services;

import study.kejizhai.bean.Massage;
import study.kejizhai.bean.Users;

import java.sql.SQLException;

public interface  MassageService {
    public void sendMassage(Massage massage) throws SQLException;
    public void deleteMassage(String massageId) throws SQLException;
    public void withdrawMessage(String massageId) throws SQLException;
    public Massage getMassageByID(String massageId) throws SQLException;
    public boolean isRead(Massage massage) throws SQLException;
}
