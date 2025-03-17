package study.kejizhai.services;

import study.kejizhai.bean.Massage;

public interface  MassageService {
    public String getMassageId(Massage massage);
    public void deleteMassage(String massageId);
    public void withdrawMessage(String massageId);
    public Massage getMassageByID(String massageId);
    public boolean isRead(Massage massage);
}
