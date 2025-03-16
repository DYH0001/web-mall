package study.kejizhai.services;

import study.kejizhai.bean.Massage;

public interface  MassageService {
    public String getMassageId(Massage massage);
    public void addMassage(Massage massage);
    public void deleteMassage(Massage massage);
    public void withdrawMessage(Massage massage);
    public Massage getMassageByID(String massageId);
    public boolean isRead(Massage massage);
}
