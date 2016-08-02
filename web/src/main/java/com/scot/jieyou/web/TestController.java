package com.scot.jieyou.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by scot on 2016/7/13.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
