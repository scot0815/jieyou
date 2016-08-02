package gzip;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by scot on 2016/7/20.
 */
public class Gzip {
    @Test
    public void testGzip() {
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod("http://localhost:8080/jieyou/");
        try {
            getMethod.addRequestHeader("accept-encoding", "gzip,deflate");
            getMethod.addRequestHeader("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; Alexa Toolbar; Maxthon 2.0)");
            int result = httpClient.executeMethod(getMethod);
            if (result == 200) {
                System.out.println(getMethod.getResponseContentLength());
                String html = getMethod.getResponseBodyAsString();
                System.out.println(html);
                System.out.println(html.getBytes().length);
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getMethod.releaseConnection();
        }
    }
}
