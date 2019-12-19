package com.yjlc.utill;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by dashang001 on 2018/7/31.
 */
public class AuthUtil {
    public static final String APPID="wxd4c3a9593db2da9c";

    public static final String APPSECRET="7d009a25e29661e4fd0faa024a68def7";

    public static JSONObject DoGet(String url) throws IOException {
        JSONObject jsonObject=null;
        DefaultHttpClient defaultHttpClient=new DefaultHttpClient();
        HttpGet httpGet=new HttpGet(url);
        HttpResponse httpResponse= null;

            httpResponse = defaultHttpClient.execute( httpGet );
            HttpEntity httpEntity=httpResponse.getEntity();
            if (httpEntity!=null){
                String result= EntityUtils.toString( httpEntity,"utf-8");
                jsonObject=JSONObject.fromObject( result );
            }
        return jsonObject;
    }
}