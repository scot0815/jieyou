package com.scot.jieyou.core.service;

import com.scot.jieyou.core.bo.LetterBo;
import com.scot.jieyou.core.entity.LetterEntity;
import com.scot.jieyou.core.vo.LetterVo;

import java.util.List;

/**
 * 信件service
 * Created by scot on 2016/7/24.
 */
public interface ILetterService {


    /**
     * 根据ID获取新建
     * @param letterId
     * @return
     */
    public LetterEntity getLetterById(Long letterId);

    /**
     * 写信
     * @param letterVo
     * @return
     */
    public Long writeLetter(LetterVo letterVo);

    /**
     * 根据咨询者id获取最近的信件
     * @param consultId
     * @return
     */
    public LetterEntity queryLastLetterByConsultId(Long consultId);

    /**
     * 获取待认领信件
     * @param sum 为null则取出全部
     * @return
     */
    public List<LetterBo> toBeClaimLetter(Integer sum);

    /**
     * 抽取信件
     * @param userId
     * @return
     */
    public Long extractLetter(Long userId);

    /**
     * 根据信件id获取信件详细内容
     * @param letterId
     * @return
     */
    public LetterBo queryLetterById(Long letterId);

    /**
     * 回复列表
     * @param entity
     * @return
     */
    public List<LetterBo> toReplyLetter(LetterEntity entity);

    /**
     * 时间轴
     * @param initialId
     * @return
     */
    public List<LetterBo> timeLine(long initialId);

    /**
     * 获取当前登录用户咨询信件的初始信件id
     * @param consultId
     * @return
     */
    public Long getInitialIdForConsult(Long consultId);

    /**
     * 当前登录用户是否有回信
     * @param initialId
     * @return
     */
    public boolean isReceive(Long initialId);

    /**
     * 获取咨询者最新回复信件
     * @param consultId
     * @return
     */
    public LetterBo getLastReceiveForConsult(Long consultId);

    /**
     * 咨询是否存在
     * @param consultId
     * @return
     */
    public boolean consultIsExist(Long consultId);
}
