package com.scot.jieyou.core.service.Impl;

import com.scot.jieyou.core.bo.LetterBo;
import com.scot.jieyou.core.constant.CoreConstant;
import com.scot.jieyou.core.dao.ICoreLetterContentDao;
import com.scot.jieyou.core.dao.ICoreLetterDao;
import com.scot.jieyou.core.entity.LetterContentEntity;
import com.scot.jieyou.core.entity.LetterEntity;
import com.scot.jieyou.core.service.ILetterService;
import com.scot.jieyou.core.util.NumUtil;
import com.scot.jieyou.core.vo.LetterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by scot on 2016/7/24.
 */
@Service("letterService")
public class LetterServiceImpl implements ILetterService {

    private final static int LETTER_COUNT = 5;

    @Resource(name="letterDao")
    private ICoreLetterDao letterDao;

    @Resource(name="letterContentDao")
    private ICoreLetterContentDao letterContentDao;


    public LetterEntity getLetterById(Long letterId) {
        return letterDao.selectById(letterId);
    }

    /**
     * 写信
     * @param letterVo
     * @return
     */
    @Transactional
    public Long writeLetter(LetterVo letterVo) {

        //1、创建信件内容
        LetterContentEntity contentEntity = new LetterContentEntity();
        contentEntity.setCreateUser(letterVo.getCreateUser());
        contentEntity.setUpdateUser(letterVo.getUpdateUser());
        contentEntity.setContent(letterVo.getContent());
        letterContentDao.insert(contentEntity);

        //2、创建信件
        LetterEntity letterEntity = new LetterEntity();
        letterEntity.setContentId(contentEntity.getId());
        letterEntity.setTitle(letterVo.getTitle());
        letterEntity.setInitialId(letterVo.getInitialId());
        letterEntity.setIsInitial(letterVo.getIsInitial());
        letterEntity.setConsultId(letterVo.getConsultId());
        letterEntity.setReplyId(letterVo.getReplyId());
        letterEntity.setLetterType(letterVo.getLetterType());
        letterEntity.setLetterStatus(letterVo.getLetterStatus());
        letterEntity.setDisable(letterVo.getDisable());
        letterEntity.setCreateUser(letterVo.getCreateUser());
        letterEntity.setUpdateUser(letterVo.getUpdateUser());
        letterDao.insert(letterEntity);

        //3、如果是初始信件 更新初始id
        if(letterVo.getIsInitial()) {
            letterEntity.setInitialId(letterEntity.getId());
            letterDao.update(letterEntity);
        }
        return letterEntity.getId();
    }

    @Override
    public LetterEntity queryLastLetterByConsultId(Long ConsultId) {
        return null;
    }

    @Override
    public List<LetterBo> toBeClaimLetter(Integer sum) {
        return letterDao.toBeClaim(sum,null);
    }

    @Override
    public Long extractLetter(Long userId) {
        List<LetterBo> letterBos = letterDao.toBeClaim(LETTER_COUNT,userId);
        if(null != letterBos && letterBos.size()>0) {
            int i = NumUtil.randomInt(letterBos.size());
            LetterBo bo = letterBos.get(i);
            bo.setReplyId(userId);//设置领取人id
            bo.setUpdateUser(userId);
            bo.setLetterStatus(CoreConstant.LetterStatus.ALREADY_CLAIM);//更新为已认领
            LetterEntity entity = new LetterEntity();
            BeanUtils.copyProperties(bo,entity);
            letterDao.update(entity);
            return entity.getId();
        }
        return null;
    }

    @Override
    public Long getInitialIdForConsult(Long consultId) {
        return letterDao.queryByConsult(consultId);
    }

    @Override
    public boolean isReceive(Long initialId){
        Long id = letterDao.queryLastByInitial(initialId);
        if(null != id) {
            return letterDao.isReceive(id);
        }
        return false;
    }

    @Override
    public LetterBo getLastReceiveForConsult(Long consultId){
        Long initialId = this.getInitialIdForConsult(consultId);
        Long id = letterDao.queryLastByInitial(initialId);
        if(null != id) {
            if(letterDao.isReceive(id)) {
                return this.queryLetterById(id);
            }
        }
        return null;
    }

    @Override
    public void letterEnd(Long initialId,Long updateUser) {
        letterDao.letterEnd(initialId,updateUser);
    }

    @Override
    public LetterBo queryLetterById(Long letterId) {
        return letterDao.queryDetailById(letterId);
    }

    public boolean consultIsExist(Long consultId) {
        return letterDao.consultIsExist(consultId);
    }

    public List<LetterBo> toReplyLetter(Integer type,Long userId) {
        return letterDao.toBeReply(type,userId);
    }

    public List<LetterBo> timeLine(long initialId) {
        return letterDao.timeLine(initialId);
    }
}