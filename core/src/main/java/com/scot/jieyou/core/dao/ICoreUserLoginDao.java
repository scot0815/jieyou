package com.scot.jieyou.core.dao;

import com.scot.jieyou.core.entity.UserLoginEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userLoginDao")
public interface ICoreUserLoginDao {

    int deleteById(Long id);

    int insert(UserLoginEntity userLoginEntity);

    UserLoginEntity selectById(Long id);

    int update(UserLoginEntity userLoginEntity);

    List<UserLoginEntity> select(UserLoginEntity userLoginEntity);
}