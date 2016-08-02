package com.scot.jieyou.core.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量类
 * Created by scot on 2016/7/24.
 */
public class CoreConstant {

    /**
     * 信件类型
     */
    public interface LetterType {

        final Map<Integer,String>map = new HashMap<Integer,String>() {
            {
                put(1,"咨询");
                put(2,"回复");
            }
        };

        Integer CONSULT = 1;
        Integer REPLY = 2;
    }


    /**
     * 信件状态
     * 待认领:1，已认领：2，回写中：3，已回写：4，已结束：5
     */
   public interface LetterStatus {
        final Map<Integer,String> map = new HashMap<Integer,String>() {
            {
                put(1,"待认领");
                put(2,"已认领");
                put(3,"回写中");
                put(4,"已回写");
                put(5,"已结束");
            }
        };

        Integer TO_BE_CLAIM = 1;
        Integer ALREADY_CLAIM = 2;
        Integer TO_WRITE_IN = 3;
        Integer ALREADY_WRITE = 4;
        Integer END = 5;

    }

}
