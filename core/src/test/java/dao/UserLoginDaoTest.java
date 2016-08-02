package dao;

import com.scot.jieyou.core.dao.ICoreUserDao;
import com.scot.jieyou.core.dao.ICoreUserLoginDao;
import com.scot.jieyou.core.entity.UserEntity;
import com.scot.jieyou.core.entity.UserLoginEntity;
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
public class UserLoginDaoTest {

    @Resource(name="userLoginDao")
    private ICoreUserLoginDao userLoginDao;

    @Test
    public void insert() {
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        userLoginEntity.setLoginName("scot");
        userLoginEntity.setPassword("123456");
        userLoginEntity.setUserId(2l);
        userLoginEntity.setDisable(false);
        userLoginEntity.setCreateTime(new Date());
        userLoginEntity.setUpdateTime(new Date());
        userLoginEntity.setCreateUser(1l);
        userLoginEntity.setUpdateUser(1l);
        userLoginDao.insert(userLoginEntity);
    }

    @Test
    public void selectById() {
        UserLoginEntity userLoginEntity = userLoginDao.selectById(1l);
        System.out.println(userLoginEntity.getId()+userLoginEntity.getLoginName());
    }


    @Test
    public void update() {
        UserLoginEntity userLoginEntity = userLoginDao.selectById(1l);
        userLoginEntity.setPassword("22222");
        userLoginDao.update(userLoginEntity);
    }
    @Test
    public void selectList() {
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        List<UserLoginEntity> userEntityList = userLoginDao.select(userLoginEntity);
        System.out.println(userEntityList);
    }
}
