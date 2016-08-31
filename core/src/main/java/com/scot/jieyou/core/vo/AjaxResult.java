package com.scot.jieyou.core.vo;

/**
 * Ajax返回对象类
 *
 * @author kimi.hua
 * @Time 2015-10-19
 */
public class AjaxResult {

    //是否访问返回成功
    private Boolean isSuccess;

    //返回数据对象
    private Object resultData;

    //返回消息提示
    private String resultMsg;

    //返回Code标示
    private String resultCode;

    public AjaxResult() {
        super();
    }

    //只提示成功失败时使用
    public AjaxResult(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    //默认成功，返回数据时使用
    public AjaxResult(Object resultData) {
        this();
        this.resultData = resultData;
        this.isSuccess = true;
    }

    //提示成功失败和提示信息时使用
    public AjaxResult(Boolean isSuccess, String resultMsg) {
        this();
        this.isSuccess = isSuccess;
        this.resultMsg = resultMsg;
    }

    public AjaxResult(Boolean isSuccess, Object resultData, String resultMsg) {
        super();
        this.isSuccess = isSuccess;
        this.resultData = resultData;
        this.resultMsg = resultMsg;
    }

    public AjaxResult(Boolean isSuccess, Object resultData, String resultMsg, String resultCode) {
        this();
        this.isSuccess = isSuccess;
        this.resultData = resultData;
        this.resultMsg = resultMsg;
        this.resultCode = resultCode;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

}
