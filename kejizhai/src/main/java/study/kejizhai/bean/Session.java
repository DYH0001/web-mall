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

    public Session(){}

    public Session(int sessionId, List<Users> users, Date startTime, Date endTime, boolean isActive, List<Massage> massages){
        this.sessionId = sessionId;
        this.users = users;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isActive = isActive;
        this.massages = massages;
    }

    public int getSessionId(){
        return sessionId;
    }
    public void setSessionId(int sessionId){
        this.sessionId = sessionId;
    }   
    public List<Users> getUsers(){
        return users;
    }   
    public void setUsers(List<Users> users){
        this.users = users;
    }
    public Date getStartTime(){
        return startTime;
    }
    public void setStartTime(Date startTime){
        this.startTime = startTime;
    }
    public Date getEndTime(){
        return endTime;
    }
    public void setEndTime(Date endTime){
        this.endTime = endTime;
    }
    public boolean getIsActive(){
        return isActive;
    }
    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    
    // 添加获取消息列表的方法
    public List<Massage> getMassages() {
        return massages;
    }
    
    // 添加设置消息列表的方法
    public void setMassages(List<Massage> massages) {
        this.massages = massages;
    }
}