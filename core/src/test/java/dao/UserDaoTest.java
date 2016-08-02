package dao;

import com.scot.jieyou.core.dao.ICoreUserDao;
import com.scot.jieyou.core.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-base.xml"})
@ActiveProfiles("localhost")
public class UserDaoTest {

    @Resource(name="userDao")
    private ICoreUserDao userDao;

    @Test
    public void insert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setRealName("scot");
        userEntity.setQq(234324);
        userEntity.setEmail("wdak@qq.com");
        userEntity.setDisable(false);
        userEntity.setCreateTime(new Date());
        userEntity.setUpdateTime(new Date());
        userEntity.setCreateUser(1l);
        userEntity.setUpdateUser(1l);
        userDao.insert(userEntity);
    }

    @Test
    public void selectById() {
        UserEntity userEntity = userDao.selectById(1l);
        System.out.println(userEntity.getId()+userEntity.getEmail());
    }


    @Test
    public void update() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1l);
        userEntity.setRealName("scot");
        userEntity.setQq(11111);
        userEntity.setEmail("wdak@qq.com");
        userEntity.setDisable(true);
        userEntity.setCreateUser(1l);
        userEntity.setUpdateUser(1l);
        userDao.update(userEntity);
    }

    @Test
    public void selectList() {
        UserEntity userEntity = new UserEntity();
        userEntity.setRealName("scot");
        List<UserEntity> userEntityList = userDao.select(userEntity);
        System.out.println(userEntityList);
    }
}
