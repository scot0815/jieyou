package com.scot.jieyou.core.service.Impl;

import com.scot.jieyou.core.constant.CoreConstant;
import com.scot.jieyou.core.dao.ICoreUserDao;
import com.scot.jieyou.core.dao.ICoreUserLoginDao;
import com.scot.jieyou.core.entity.UserEntity;
import com.scot.jieyou.core.entity.UserLoginEntity;
import com.scot.jieyou.core.service.IUserService;
import com.scot.jieyou.core.util.FileReadUtil;
import com.scot.jieyou.core.util.MailUtil;
import com.scot.jieyou.core.util.TokenUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by scot on 2016/8/2.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{


    @Resource(name="userDao")
    private ICoreUserDao userDao;

    @Resource(name="userLoginDao")
    private ICoreUserLoginDao userLoginDao;

    @Override
    @Transactional
    public void register(String userName,String email,String password) {

        //用户信息
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        user.setEmail(email);
        user.setDisable(false);
        user.setCreateUser(0l);
        user.setUpdateUser(0l);
        userDao.insert(user);

        //用户登录信息
        UserLoginEntity userLogin = new UserLoginEntity();
        userLogin.setLoginName(user.getEmail());
        userLogin.setPassword(password);
        userLogin.setUserId(user.getId());
        userLogin.setStatus(CoreConstant.UserStatus.UNAUTHORIZED);//未认证
        userLogin.setDisable(false);
        userLogin.setCreateUser(0l);
        userLogin.setUpdateUser(0l);
        userLoginDao.insert(userLogin);
    }

    @Override
    public UserLoginEntity login(String email,String password) {
        UserLoginEntity query = new UserLoginEntity();
        query.setLoginName(email);
        query.setPassword(password);
        query.setDisable(false);
        List<UserLoginEntity> logins = userLoginDao.select(query);
        if(null != logins && logins.size() == 1) {
            return logins.get(0);
        }
        return null;
    }

    @Override
    public boolean isExist(String loginName) {
        UserLoginEntity query = new UserLoginEntity();
        query.setLoginName(loginName);
        query.setDisable(false);
        List<UserLoginEntity> users = userLoginDao.select(query);
        return users !=null ? users.size() > 0 : false;
    }

    @Override
    public boolean authorized(String email,String token) throws Exception{
        UserLoginEntity query = new UserLoginEntity();
        query.setLoginName(email);
        query.setDisable(false);
        List<UserLoginEntity> logins = userLoginDao.select(query);
        if(null != logins && logins.size() == 1) {
            UserLoginEntity user = logins.get(0);
            String name = user.getLoginName();
            String password = user.getPassword();
            boolean result = TokenUtil.emailToken(name,password).equals(token);
            if(result) {
                user.setStatus(CoreConstant.UserStatus.AUTHORIZED);
            }
            return result;
        }else{
            return false;
        }
    }

}
