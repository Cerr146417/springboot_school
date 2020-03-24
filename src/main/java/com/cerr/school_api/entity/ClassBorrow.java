package com.cerr.school_api.entity;

import java.util.Date;

/**
 * 教室申请信息表
 * status：0表示还没审批，1表示审批成功，2表示不通过审批
 * useTime: 如果是1-2节，则为1-2；如果是1节，则为1-
 */
public class ClassBorrow {
    private Integer id;
    private String AppName; //申请人姓名
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
        return AppName;
    }

    public void setAppName(String appName) {
        AppName = appName;
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
}
