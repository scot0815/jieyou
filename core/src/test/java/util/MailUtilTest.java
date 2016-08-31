package util;

import com.scot.jieyou.core.util.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by scot on 2016/8/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-base.xml"})
@ActiveProfiles("localhost")
public class MailUtilTest {

    @Test
    public void send() {
        MailUtil se = new MailUtil(true);
        se.doSendHtmlEmail("邮件主题", "邮件内容", "729593559@qq.com");
    }
}
