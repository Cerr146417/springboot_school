package com.cerr.school_api.entity;

import java.util.Date;

/**
 * 教室申请信息表
 * status：0表示还没审批，1表示审批成功，2表示不通过审批
 * useTime: 如果是1-2节，则为1-2；如果是1节，则为1-
 */
public class ClassBorrow {
    private Integer id;
    private String appName; //申请人学号
    private Date useDate;   //使用日期
    private String useTime; //使用时间
    private Date appDate;   //申请日期
    private String reason;  //申请理由
    private Integer status; //申请状态
    private Integer classRoomId;    //教室id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }

    public ClassBorrow() {
    }

    public ClassBorrow(Integer id, String appName, Date useDate, String useTime, Date appDate, String reason, Integer status, Integer classRoomId) {
        this.id = id;
        this.appName = appName;
        this.useDate = useDate;
        this.useTime = useTime;
        this.appDate = appDate;
        this.reason = reason;
        this.status = status;
        this.classRoomId = classRoomId;
    }

    public ClassBorrow(String appName, Date useDate, String useTime, Date appDate, String reason, Integer status, Integer classRoomId) {
        this.appName = appName;
        this.useDate = useDate;
        this.useTime = useTime;
        this.appDate = appDate;
        this.reason = reason;
        this.status = status;
        this.classRoomId = classRoomId;
    }

    @Override
    public String toString() {
        return "ClassBorrow{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", useDate=" + useDate +
                ", useTime='" + useTime + '\'' +
                ", appDate=" + appDate +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", classRoomId=" + classRoomId +
                '}';
    }
}
