package com.tom.blog;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @Author ： YingZhang
 * @Description:
 * @Date : Create in 3:50 PM 1/10/2019
 */
@Slf4j
public class HttpUtils {

    private static final RequestConfig defaultConfig;

    // 获取返回的cookie（访问Url前塞进HttpClient）
    private static  BasicCookieStore cookieStore = new BasicCookieStore();

    static {
        // 设置超时时间等配置
        defaultConfig = RequestConfig.custom().
                setSocketTimeout(10000).
                setConnectTimeout(10000).
                setConnectionRequestTimeout(10000).
                build();
    }

    /**
     * 获取client
     *
     * @return
     */
    public static CloseableHttpClient getClient() {
        // 采用默认方式获取client，默认方式会通过连接池建立连接
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        return client;
    }

    public static String postWithHttp(Map<String, Object> map, String url) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(defaultConfig);
        StringEntity stringEntity = new StringEntity(JSON.toJSONString(map), Consts.UTF_8);
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        return execute(httpPost);
    }

    public static String getWithHttp(Map<String, Object> map, String url, String token) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(defaultConfig);
        return execute(httpGet);
    }

    public static String getWithHttp(String url){
        return getWithHttp(null,url,null);
    }

    /**
     * 执行请求并响应
     *
     * @param httpPost httpPost
     * @return 结果流字符串
     */
    private static String execute(HttpRequestBase httpPost) {
        if (httpPost == null) {
            return "";
        }
        try {
            CloseableHttpResponse response = getClient().execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

//                 打印cookie
//                List<Cookie> cookies = cookieStore.getCookies();
//                if (cookies.isEmpty()) {
//                    System.out.println("Cookie is None");
//                } else {
//                    for (int i = 0; i < cookies.size(); i++) {
//                        System.out.println("- " + cookies.get(i).toString());
//                    }
//                }
                HttpEntity resEntity = response.getEntity();
                return EntityUtils.toString(resEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("请求出错,", e);
        }
        return "";
    }

    /**
     * 文件下载
     *
     * @param url   url
     * @param token token
     * @return 响应流
     * @throws IOException
     */
    public boolean downFileByGet(String url, String token, File targetFile) {

        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        // 设置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        httpGet.setConfig(requestConfig);

        httpGet.setHeader("token", token);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
        } catch (IOException e) {
            log.error("", e);
        }
        assert response != null;
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            try {
                // org.apache.commons.io.IOUtils.copy(response.getEntity().getContent(), new FileOutputStream(targetFile));
                response.getEntity().writeTo(new FileOutputStream(targetFile)); // 写入文件
            } catch (IOException e) {
                log.error("", e);
            }
        }
        return true;

    }


    /**
     * 表单提交 post请求
     *
     * @param map   参数对
     * @param url   url
     * @param token token
     * @return 响应流
     * @throws IOException
     */
    public String postFormWithHttp(Map<String, Object> map, String url, String token) {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);
        // 设置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        httpPost.setConfig(requestConfig);

        httpPost.setHeader("token", token);
        ContentType contentType = ContentType.create("text/plain", Consts.UTF_8);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            builder.addPart(entry.getKey(), new StringBody(entry.getValue().toString(), contentType));
        }
        HttpEntity httpEntity = null;
        try {
            httpEntity = builder.setCharset(CharsetUtils.get("UTF-8")).build();
        } catch (UnsupportedEncodingException e) {
            log.error("", e);
        }
        httpPost.setEntity(httpEntity);

        return execute(httpPost);
    }

}
