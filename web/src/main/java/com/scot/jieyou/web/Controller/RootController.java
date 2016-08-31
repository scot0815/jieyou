package com.scot.jieyou.web.Controller;

import com.scot.jieyou.core.constant.CoreConstant;
import com.scot.jieyou.core.entity.UserLoginEntity;
import com.scot.jieyou.core.service.IUserService;
import com.scot.jieyou.core.util.FileReadUtil;
import com.scot.jieyou.core.util.MailUtil;
import com.scot.jieyou.core.util.TokenUtil;
import com.scot.jieyou.core.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by scot on 2016/8/2.
 */
@Controller
@RequestMapping("/")
public class RootController {

    private static final String REGISTER_TEMPLATE = "/template/register.jy";
    private static final String REGISTER_SUBJECT = "解忧杂货店-注册认证";

    @Resource(name="userService")
    private IUserService userService;

    /**
     * 注册
     * @param userName
     * @param email
     * @param password
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public AjaxResult register(String userName,String email,String password) throws Exception{
        boolean isExist = userService.isExist(email);
        if(isExist) {
            AjaxResult result = new AjaxResult(false);
            result.setResultMsg("邮箱已被注册。");
            return result;
        }
        userService.register(userName,email,password);
        //邮件发送
        try{
            String templateStr = FileReadUtil.readEmailTemplate("REGISTER_TEMPLATE");
            String token = TokenUtil.emailToken(email, password);
            String temp = "email="+email+"&token="+token;
            templateStr = templateStr.replace("${0}",userName).replaceAll("${1}", temp);
            MailUtil mailUtil = new MailUtil(false);
            mailUtil.doSendHtmlEmail(REGISTER_SUBJECT,templateStr,email);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return new AjaxResult(true);
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @param httpSession
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public AjaxResult login(String userName,String password,HttpSession httpSession) {
        UserLoginEntity user = userService.login(userName,password);
        AjaxResult result = new AjaxResult(false);
        if(null != user) {
            if(!CoreConstant.UserStatus.AUTHORIZED.equals(user.getStatus())) {
                if(CoreConstant.UserStatus.UNAUTHORIZED.equals(user.getStatus())) {
                    //为认证
                    result.setResultData(CoreConstant.UserStatus.UNAUTHORIZED);
                    result.setResultMsg("您的账户未认证，请查收邮件认证。");
                }else if(CoreConstant.UserStatus.DISABLE.equals(user.getStatus())) {
                    //禁用
                    result.setResultData(CoreConstant.UserStatus.DISABLE);
                    result.setResultMsg("您的账户已被禁用，如有疑问联系管理员。");
                }
            }else{
                httpSession.setAttribute(CoreConstant.SESSION_USER_ID,user.getId());
                return new AjaxResult(true);
            }

        }
        return result;
    }

    /**
     * 用户认证
     * @param email
     * @return
     */
    @RequestMapping("/authorized")
    public ModelAndView authorized(String email,String token) throws Exception{
        boolean isSuccess = userService.authorized(email,token);
        return null;
    }

}
