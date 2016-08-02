package com.scot.jieyou.core.util;

import java.util.Random;

/**
 * 数字工具类
 * Created by scot on 2016/7/27.
 */
public class NumUtil {

    /**
     * 生成随机数
     * @param max 最大值
     * @return
     */
    public static int randomInt(int max) {
        Random random = new Random();
        return random.nextInt(max)%(max+1);
    }
}
