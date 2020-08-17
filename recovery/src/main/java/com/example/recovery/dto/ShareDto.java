package com.example.recovery.dto;

import java.util.Date;

/**
 * ClassName:ShareDto
 * Package:com.example.recovery.dto
 * Description:
 *
 * @date:2020/8/13 14:39
 * @author:zh
 */
public class ShareDto {

    private String shareId;

    private String patientName;

    private String doctorName;

    private String hospitalName;

    private String doctorTitle;

    private String readFlag;

    private String userId;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDoctorTitle() {
        switch (doctorTitle){
            case "1":
                return "医师";
            case "2":
                return "主治医师";
            case "3":
                return "副主任医师";
            default:
                return "主任医师";
        }
    }

    public void setDoctorTitle(String doctorTitle) {
        this.doctorTitle = doctorTitle;
    }
}
