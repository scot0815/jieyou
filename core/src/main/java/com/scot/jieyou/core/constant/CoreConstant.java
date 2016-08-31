package com.scot.jieyou.core.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量类
 * Created by scot on 2016/7/24.
 */
public class CoreConstant {

    public final static String SESSION_USER_ID = "session_user_id";

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
                put(1,"在路上");
                put(2,"通信中");
                put(3,"回写中");
                put(4,"已回写");
                put(5,"烦恼消散");
            }
        };

        Integer TO_BE_CLAIM = 1;
        Integer ALREADY_CLAIM = 2;
        Integer TO_WRITE_IN = 3;
        Integer ALREADY_WRITE = 4;
        Integer END = 5;

    }

    /**
     * 用户状态
     * 0:未认证 1：已认证 2：禁用
     */
    public interface UserStatus {

        final Map<Integer,String> map = new HashMap<Integer,String>() {
            {
                put(0,"未认证");
                put(1,"已认证");
                put(2,"禁用");
            }
        };

        Integer UNAUTHORIZED = 0;
        Integer AUTHORIZED = 1;
        Integer DISABLE = 2;

    }

}
