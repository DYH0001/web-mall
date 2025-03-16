package study.kejizhai.bean;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Massage {
    private String senderId;
    private String massageId;
    private List<String> Content;
    private Date startTime;
    private Date endTime;
    private Optional<String> receiverId;
    private int MassageType;  //以后做消息内容识别判断是string还是int

    public Massage(){}

    public Massage(String senderId, String massageId, List<String> Content, Date startTime, Date endTime, Optional<String> receiverId, int MassageType){
        this.senderId = senderId;
        this.massageId = massageId;
        this.Content = Content;
        this.startTime = startTime;
        this.receiverId = receiverId;
        this.MassageType = MassageType;
    }
    public String getSenderId(){
        return senderId;
    }
    public void setSenderId(String senderId){
        this.senderId = senderId;
    }
    public String getMassageId(){
        return massageId;
    }
    public void setMassageId(String massageId){
        this.massageId = massageId;
    }
    public List<String> getContent(){
        return Content;
    }
    public void setContent(List<String> Content){
        this.Content = Content;
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
    public String getReceiverIdOrNull(){
        return receiverId.orElse(null);
    }   
    public void setReceiverId(String receiverId){
        this.receiverId = Optional.ofNullable(receiverId);
    }
    public int getMassageType(){
        return MassageType;
    }
    public void setMassageType(int MassageType){
        this.MassageType = MassageType;
    }


}