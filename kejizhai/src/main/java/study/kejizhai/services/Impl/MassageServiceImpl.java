package study.kejizhai.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.kejizhai.bean.Massage;
import study.kejizhai.services.MassageService;
import study.kejizhai.dao.MassageDao;

import java.sql.SQLException;

@Service
public class MassageServiceImpl implements MassageService {
    @Autowired
    private MassageDao massageDao;

    @Override
    public void sendMassage(Massage massage) {
        try {
            massageDao.sendMassage(massage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMassage(String massageId) {
        try {
            massageDao.deleteMassage(massageId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdrawMessage(String massageId) {
        try {
            massageDao.withdrawMessage(massageId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Massage getMassageByID(String massageId) {
        try {
            return massageDao.getMassageByID(massageId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isRead(Massage massage) {
        try {
            return massageDao.isRead(massage);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
