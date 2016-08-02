package dao;

import com.scot.jieyou.core.bo.LetterBo;
import com.scot.jieyou.core.constant.CoreConstant;
import com.scot.jieyou.core.dao.ICoreLetterDao;
import com.scot.jieyou.core.dao.ICoreUserDao;
import com.scot.jieyou.core.entity.LetterEntity;
import com.scot.jieyou.core.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-base.xml"})
@ActiveProfiles("localhost")
public class LetterDaoTest {

    @Resource(name="letterDao")
    private ICoreLetterDao letterDao;

    @Test
    public void insert() {
        LetterEntity letterEntity = new LetterEntity();
        letterEntity.setInitialId(1l);
        letterEntity.setTitle("标题..");
        letterEntity.setIsInitial(true);
        letterEntity.setConsultId(1l);
        letterEntity.setReplyId(2l);
        letterEntity.setContentId(1l);
        letterEntity.setLetterType(CoreConstant.LetterType.CONSULT);
        letterEntity.setLetterStatus(CoreConstant.LetterStatus.TO_BE_CLAIM);
        letterEntity.setDisable(false);
        letterEntity.setCreateTime(new Date());
        letterEntity.setUpdateTime(new Date());
        letterEntity.setCreateUser(1l);
        letterEntity.setUpdateUser(1l);
        letterDao.insert(letterEntity);
        System.out.println(letterEntity.getId());
    }

   @Test
    public void selectById() {
       LetterEntity letterEntity = letterDao.selectById(2l);
        System.out.println(letterEntity.getId()+letterEntity.getTitle());
    }


    @Test
    public void update() {
        LetterEntity letterEntity = letterDao.selectById(2l);
        letterEntity.setTitle("update title..");
        letterDao.update(letterEntity);
    }

    @Test
    public void selectList() {
        LetterEntity letterEntity = new LetterEntity();
        letterEntity.setTitle("update title");
        letterEntity.setDisable(false);
        List<LetterEntity> letterEntities = letterDao.select(letterEntity);
        System.out.println(letterEntities);
    }

    @Test
    public void toBeClaim() {
        List<LetterBo> bo = letterDao.toBeClaim(1,2l);
        System.out.println(bo);
    }

    @Test
    public void toBeReply() {
        LetterEntity entity = new LetterEntity();
        entity.setReplyId(2l);
        List<LetterBo> bo = letterDao.toBeReply(entity);
        System.out.println(bo);
    }

    @Test
    public void timeLine() {
        List<LetterBo> bo = letterDao.timeLine(14l);
        System.out.println(bo);
    }

    @Test
    public void zixun() {
        Long initialId = letterDao.queryByConsult(4l);
        Long id = letterDao.queryLastByInitial(initialId);
        boolean isReceive = letterDao.isReceive(id);
        System.out.println(isReceive);
    }

}
