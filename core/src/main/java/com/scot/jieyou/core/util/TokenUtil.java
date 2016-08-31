package com.scot.jieyou.core.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by scot on 2016/8/5.
 */
public class TokenUtil {

    public static String emailToken(String userName,String password) throws Exception{
        String date = DateFormatUtils.format(new Date(),"yyyy-MM-dd");
        StringBuffer bf = new StringBuffer()
                .append(userName).append(password).append(date);
        System.out.println(bf.toString());
        String token = MD5Util.getMD5(bf.toString())+MD5Util.getMD5ByBase64(bf.toString());

        System.out.println(token);
        return token;
    }
}
