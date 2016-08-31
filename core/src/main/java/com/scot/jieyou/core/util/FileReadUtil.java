package com.scot.jieyou.core.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by scot on 2016/8/5.
 */
public class FileReadUtil {

    public static String readEmailTemplate(String path) throws Exception{
        StringBuffer bf = new StringBuffer();
        InputStreamReader read = new InputStreamReader(FileReadUtil.class.getResourceAsStream(path),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTXT = null;
        while ((lineTXT = bufferedReader.readLine()) != null) {
            bf.append(lineTXT.toString());
        }
        read.close();
        return bf.toString();
    }

}
