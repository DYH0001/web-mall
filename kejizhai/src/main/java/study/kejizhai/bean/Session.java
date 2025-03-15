package study.kejizhai.bean;

import java.util.Date;
import java.util.List;

public class Session{
    private int sessionId;
    private List<Users> users;
    private Date startTime;
    private Date endTime;
    private boolean isActive;
    private List<Massage> massages;
}