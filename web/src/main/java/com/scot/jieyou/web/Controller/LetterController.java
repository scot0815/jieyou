package com.scot.jieyou.web.Controller;

import com.scot.jieyou.core.bo.LetterBo;
import com.scot.jieyou.core.constant.CoreConstant;
import com.scot.jieyou.core.entity.LetterEntity;
import com.scot.jieyou.core.service.ILetterService;
import com.scot.jieyou.core.vo.LetterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 信件controller
 * Created by scot on 2016/7/24.
 */
@Controller
@RequestMapping("/letter")
public class LetterController {

    public static Long userId = 3l;
    private final static String ACTIVE_JIEYOUBOX = "jieyouBox";
    private final static String ACTIVE_CONSULT_TIMELINE = "consultTimeLine";
    private final static String ACTIVE_ZHDRECEIVE = "zhdReceive";
    private final static String ACTIVE_TUSU = "tusu";

    @Resource(name="letterService")
    private ILetterService letterService;


    /**
     * 吐诉吧
     * @return
     */
    @RequestMapping("/tusu")
    public ModelAndView tusu(HttpSession httpSession) {
        //session暂无
        Long userId = (Long)httpSession.getAttribute("userId");
        userId = 4l;
        boolean isExist = letterService.consultIsExist(userId);

        StringBuffer bf = new StringBuffer();
        if(!isExist) {
            bf.append("redirect:/letter/writeView?")
                    .append("letterType="+CoreConstant.LetterType.CONSULT)
                    .append("&isInitial="+true)
                    .append("&isReply="+false);
        }else {
            ModelAndView view = new ModelAndView();
            view.setViewName("/letter/letterMsg");
            view.addObject("msg","您还有信件未结束,请继续咨询或者完结它。");
            view.addObject("active",ACTIVE_TUSU);
            return view;
        }
        return new ModelAndView(bf.toString());
    }

    /**
     * 写信页面
     * @return
     */
    @RequestMapping("/writeView")
    public ModelAndView writeView(@ModelAttribute LetterVo vo) {
            if(null != vo.getId()) {
            LetterEntity entity = letterService.getLetterById(vo.getId());
            BeanUtils.copyProperties(entity, vo);
        }
        return new ModelAndView("letter/writeLetter","vo",vo);
    }

    /**
     * 发送信件
     * @param vo
     * @param httpSession
     * @return
     */
    @RequestMapping("/send")
    public ModelAndView writeLetter(LetterVo vo,HttpSession httpSession) {

        //session暂无
        //Long userId = (Long)httpSession.getAttribute("userId");
        userId = 4l;
        if(vo.getIsReply()) {//如果是回复
            vo.setReplyId(userId);
            vo.setLetterStatus(CoreConstant.LetterStatus.ALREADY_WRITE);
            vo.setLetterType(CoreConstant.LetterType.REPLY);
            vo.setIsInitial(false);
        }else{//咨询
            vo.setConsultId(userId);
            if(vo.getIsInitial()) {//如果是首次咨询
                vo.setLetterStatus(CoreConstant.LetterStatus.TO_BE_CLAIM);//
            }else {
                vo.setLetterStatus(CoreConstant.LetterStatus.ALREADY_WRITE);
            }
            vo.setLetterType(CoreConstant.LetterType.CONSULT);
        }
        vo.setDisable(false);
        vo.setCreateUser(userId);
        vo.setUpdateUser(userId);
        letterService.writeLetter(vo);
        return new ModelAndView("letter/writeLetter","status","success");
    }

    /**
     * 解忧箱页面
     * @return
     */
    @RequestMapping("/boxView")
    public ModelAndView boxView() {
        return new ModelAndView("letter/letterBox");
    }

    /**
     * 抽取信件
     * @param httpSession
     * @return
     */
    @RequestMapping("/extractLetter")
    public ModelAndView extractLetter(HttpSession httpSession) {
        //session暂无
        //Long userId = (Long)httpSession.getAttribute("userId");
        Long letterId = letterService.extractLetter(2l);
        //转向信件查看页面
        return new ModelAndView("redirect:/letter/letterView?letterId="+letterId+"&active="+ACTIVE_JIEYOUBOX);
    }

    /**
     * 读取信件
     * @param letterId
     * @param active 页面标示
     * @return
     */
    @RequestMapping("/letterView")
    public ModelAndView letterView(Long letterId,String active,boolean isReply) {
        LetterBo letter = letterService.queryLetterById(letterId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/letter/readLetter");
        modelAndView.addObject("letter",letter);
        modelAndView.addObject("active",active);
        modelAndView.addObject("isReply",isReply);
        return modelAndView;
    }

    /**
     * 回复列表
     * @return
     */
    @RequestMapping("/replyList")
    public ModelAndView replyList() {
        LetterEntity entity = new LetterEntity();
        entity.setReplyId(2l);
        List<LetterBo> letters  = letterService.toReplyLetter(entity);
        return new ModelAndView("letter/replyList","letters",letters);
    }

    /**
     * 时间轴
     * @param initialId
     * @param active
     * @param isReply
     * @return
     */
    @RequestMapping("/timeLine")
    public ModelAndView timeLine(Long initialId,String active,boolean isReply) {
        List<LetterBo> letters = null;
        if(null != initialId) {
            letters  = letterService.timeLine(initialId);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/letter/timeLine");
        modelAndView.addObject("letters",letters);
        modelAndView.addObject("initialId",initialId);
        modelAndView.addObject("active",active);
        modelAndView.addObject("isReply",isReply);
        return modelAndView;
    }

    /**
     * 咨询时间轴
     * @param httpSession
     * @return
     */
    @RequestMapping("/consultTimeLine")
    public ModelAndView consultTimeLine(HttpSession httpSession) {
        //session暂无
        Long userId = (Long)httpSession.getAttribute("userId");
        userId = 4l;
        Long initialId = letterService.getInitialIdForConsult(userId);
        StringBuffer bf = new StringBuffer()
                .append("redirect:/letter/timeLine?")
                .append("initialId="+initialId)
                .append("&active="+ACTIVE_CONSULT_TIMELINE)
                .append("&isReply="+false);
        return new ModelAndView(bf.toString());
    }

    /**
     * 杂货店来信
     * @return
     */
    @RequestMapping("/zhdReceive")
    public ModelAndView zhdReceive(HttpSession httpSession) {
        //session暂无
        Long userId = (Long)httpSession.getAttribute("userId");
        userId = 4l;
        LetterBo bo = letterService.getLastReceiveForConsult(userId);
        StringBuffer bf = new StringBuffer();
        if(null != bo) {
            bf.append("redirect:/letter/letterView?")
            .append("letterId=" + bo.getId())
            .append("&active=" + ACTIVE_ZHDRECEIVE)
            .append("&isReply=" + false);
        }else {
            ModelAndView view = new ModelAndView();
            view.setViewName("/letter/letterMsg");
            view.addObject("msg","杂货店暂时还没有回复，请耐心等待。");
            view.addObject("active",ACTIVE_ZHDRECEIVE);
            return view;
        }
        return new ModelAndView(bf.toString());
    }

    /**
     *  提示信息
     * @param msg
     * @param active
     * @return
     */
    @RequestMapping("/letterMsg")
    public ModelAndView letterMsg(String msg,String active) {
        ModelAndView view = new ModelAndView();
        view.setViewName("/letter/letterMsg");
        view.addObject("msg",msg);
        view.addObject("active",active);
        return view;
    }

}
