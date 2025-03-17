package study.kejizhai.dao;

import study.kejizhai.bean.Massage;

public interface MassageDao {
    void sendMassage(Massage massage);

    void deleteMassage(String MassageId);

    void withdrawMessage(String MassageId);

    Massage getMassageByID(String MassageId);

    boolean isRead(Massage massage);
}
