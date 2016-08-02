package com.scot.jieyou.core.dao;

import com.scot.jieyou.core.bo.LetterBo;
import com.scot.jieyou.core.entity.LetterEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("letterDao")
public interface ICoreLetterDao {

    int deleteById(Long id);

    int insert(LetterEntity record);

    LetterEntity selectById(Long id);

    int update(LetterEntity record);

    List<LetterEntity> select(LetterEntity record);

    /**
     * 查询待认领信件
     * @param limitNumber
     * @param userId
     * @return
     */
    List<LetterBo> toBeClaim(@Param("limitNumber")Integer limitNumber,@Param("userId")Long userId);

    /**
     * 根据ID查询信件详情信息
     * @param id
     * @return
     */
    LetterBo queryDetailById(@Param("id")Long id);

    /**
     * 查询回复列表
     * @param entity
     * @return
     */
    List<LetterBo> toBeReply(LetterEntity entity);

    /**
     * 时间轴
     * @param initialId
     * @return
     */
    List<LetterBo> timeLine(@Param("initialId")Long initialId);

    /**
     * 获取咨询者信件初始Id
     * @param consultId
     * @return
     */
    Long queryByConsult(@Param("consultId")Long consultId);

    /**
     * 根据初始Id获取最新回复信件
     * @param initialId
     * @return
     */
    Long queryLastByInitial(@Param("initialId")Long initialId);

    /**
     * 咨询者是否收到信件
     * @param id
     * @return
     */
    Boolean isReceive(@Param("id")Long id);

    /**
     *
     * @param consultId
     * @return
     */
    Boolean consultIsExist(@Param("consultId")Long consultId);
}