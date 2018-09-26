package com.example.ocr;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.*;

import static com.example.ocr.Utils.*;

public class StartOcr {

    public static void main(String[] args)  {
        String host = "https://ocrapi-document.taobao.com";
        String path = "/ocrservice/document";
        String method = "POST";
        String appcode = "这里填写你的AppCode";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        String bodys = null;
        try {
            bodys = "{\"img\":\""+ changeToBase64("D:\\ocr.jpg")+"\",\"prob\":false}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            prase(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
