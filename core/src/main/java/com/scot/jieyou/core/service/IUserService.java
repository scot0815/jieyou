package com.scot.jieyou.core.service;

import com.scot.jieyou.core.entity.UserLoginEntity;

/**
 * 用户service
 * Created by scot on 2016/8/2.
 */
public interface IUserService {

    /**
     * 注册
     * @param userName
     * @param email
     * @param password
     */
    public void register(String userName,String email,String password);

    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    public UserLoginEntity login(String email,String password);

    /**
     * 用户名是否存在
     * @param loginName
     * @return
     */
    public boolean isExist(String loginName);

    /**
     * 认证
     * @param email
     * @param token
     * @return
     */
    public boolean authorized(String email,String token) throws Exception;
}
