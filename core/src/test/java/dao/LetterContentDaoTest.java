package dao;

import com.scot.jieyou.core.dao.ICoreLetterContentDao;
import com.scot.jieyou.core.entity.LetterContentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-base.xml"})
@ActiveProfiles("localhost")
public class LetterContentDaoTest {

    @Resource(name="letterContentDao")
    private ICoreLetterContentDao letterContentDao;

    @Test
    public void insert() {
        LetterContentEntity letterContentEntity = new LetterContentEntity();
        letterContentEntity.setContent("这是一封信的内容");
        letterContentEntity.setCreateTime(new Date());
        letterContentEntity.setUpdateTime(new Date());
        letterContentEntity.setCreateUser(1l);
        letterContentEntity.setUpdateUser(1l);
        letterContentDao.insert(letterContentEntity);
        System.out.println(letterContentEntity.getId());
    }

    @Test
    public void selectById() {
        LetterContentEntity letterContentEntity = letterContentDao.selectById(1l);
        System.out.println(letterContentEntity.getId()+ letterContentEntity.getContent());
    }


    @Test
    public void update() {
        LetterContentEntity letterContentEntity = new LetterContentEntity();
        letterContentEntity.setId(1l);
        letterContentEntity.setContent("这是一封信的内容....");
        letterContentEntity.setCreateUser(1l);
        letterContentEntity.setUpdateUser(1l);
        letterContentDao.update(letterContentEntity);
    }

    @Test
    public void selectList() {
        LetterContentEntity letterContentEntity = new LetterContentEntity();
        List<LetterContentEntity> letterContentEntities = letterContentDao.select(letterContentEntity);
        System.out.println(letterContentEntities);
    }
}
