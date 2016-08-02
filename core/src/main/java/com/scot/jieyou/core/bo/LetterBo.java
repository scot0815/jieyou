package com.scot.jieyou.core.bo;

import com.alibaba.druid.util.StringUtils;
import com.scot.jieyou.core.constant.CoreConstant;
import com.scot.jieyou.core.util.HtmlUtil;

import java.util.Date;

/**
 * 信件
 * Created by scot on 2016/7/24.
 */
public class LetterBo {

    private Long id;

    private String title;

    private Long initialId;

    private Boolean isInitial;

    private Long consultId;

    private Long replyId;

    private Long contentId;

    private String content;

    private String contentIntro;

    private Integer letterType;

    private String letterTypeName;

    private Integer letterStatus;

    private String letterStatusName;

    private Boolean disable;

    private Date createTime;

    private Long createUser;

    private Long updateUser;

    private Date updateTime;

    private Long maxInitialId;

    private Integer maxLetterType;

    private Integer maxLetterStatus;

    private Date maxUpdateTime;

    private String maxContent;

    private String maxContentIntro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getInitialId() {
        return initialId;
    }

    public void setInitialId(Long initialId) {
        this.initialId = initialId;
    }

    public Boolean getIsInitial() {
        return isInitial;
    }

    public void setIsInitial(Boolean isInitial) {
        this.isInitial = isInitial;
    }

    public Long getConsultId() {
        return consultId;
    }

    public void setConsultId(Long consultId) {
        this.consultId = consultId;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        if(!StringUtils.isEmpty(content)) {
            String temp = HtmlUtil.getTextFromHtml(content);
            temp = temp.substring(0,10);
            this.setContentIntro(temp);
        }
    }

    public Integer getLetterType() {
        return letterType;
    }

    public void setLetterType(Integer letterType) {
        this.letterType = letterType;
        this.setLetterTypeName(CoreConstant.LetterType.map.get(letterType));
    }

    public Integer getLetterStatus() {
        return letterStatus;
    }

    public void setLetterStatus(Integer letterStatus) {
        this.letterStatus = letterStatus;
        this.setLetterStatusName(CoreConstant.LetterStatus.map.get(letterStatus));
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getMaxInitialId() {
        return maxInitialId;
    }

    public void setMaxInitialId(Long maxInitialId) {
        this.maxInitialId = maxInitialId;
    }

    public Integer getMaxLetterType() {
        return maxLetterType;
    }

    public void setMaxLetterType(Integer maxLetterType) {
        this.maxLetterType = maxLetterType;
    }

    public Integer getMaxLetterStatus() {
        return maxLetterStatus;
    }

    public void setMaxLetterStatus(Integer maxLetterStatus) {
        this.maxLetterStatus = maxLetterStatus;
    }

    public String getLetterTypeName() {
        return letterTypeName;
    }

    public void setLetterTypeName(String letterTypeName) {
        this.letterTypeName = letterTypeName;
    }

    public String getLetterStatusName() {
        return letterStatusName;
    }

    public void setLetterStatusName(String letterStatusName) {
        this.letterStatusName = letterStatusName;
    }

    public Date getMaxUpdateTime() {
        return maxUpdateTime;
    }

    public void setMaxUpdateTime(Date maxUpdateTime) {
        this.maxUpdateTime = maxUpdateTime;
    }

    public String getContentIntro() {
        return contentIntro;
    }

    public void setContentIntro(String contentIntro) {
        this.contentIntro = contentIntro;
    }

    public String getMaxContent() {
        return maxContent;
    }

    public void setMaxContent(String maxContent) {
        this.maxContent = maxContent;
        if(!StringUtils.isEmpty(maxContent)) {
            String temp = HtmlUtil.getTextFromHtml(maxContent);
            temp = temp.substring(0,10);
            this.setMaxContentIntro(temp);
        }
    }

    public String getMaxContentIntro() {
        return maxContentIntro;
    }

    public void setMaxContentIntro(String maxContentIntro) {
        this.maxContentIntro = maxContentIntro;
    }
}
