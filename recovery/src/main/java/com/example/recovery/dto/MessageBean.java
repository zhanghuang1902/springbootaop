package com.example.recovery.dto;

import java.util.Date;

/**
 * ClassName:MessageBean
 * Package:com.example.recovery.dto
 * Description:
 *
 * @date:2020/8/13 15:02
 * @author:zh
 */
public class MessageBean {

        private String id;

        private String title;

        private String content;

        private String relationId;

        private String relationType;

        private String deleteFlag;

        private String readFlag;

        private String userId;

        private String userDiv;

        private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserDiv() {
        return userDiv;
    }

    public void setUserDiv(String userDiv) {
        this.userDiv = userDiv;
    }
}
