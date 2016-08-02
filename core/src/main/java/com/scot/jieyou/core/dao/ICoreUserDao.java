package com.scot.jieyou.core.dao;

import com.scot.jieyou.core.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface ICoreUserDao {

    int deleteById(Long id);

    int insert(UserEntity record);

    UserEntity selectById(Long id);

    int update(UserEntity record);

    List<UserEntity> select(UserEntity entity);
}