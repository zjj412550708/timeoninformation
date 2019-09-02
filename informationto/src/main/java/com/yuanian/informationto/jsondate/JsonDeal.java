package com.yuanian.informationto.jsondate;

import com.yuanian.informationto.model.User;
import com.yuanian.informationto.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ：mmzs
 * @date ：Created in 2019/8/30 15:35
 * @description：
 * @modified By：
 * @version: $
 */
public class JsonDeal {
    @Autowired
    private UserService userService;

    public static void main(String[] args) throws ParseException {
        String o = StrData();
        List<User> list = new ArrayList<>();
        SimpleDateFormat datedeal = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(o);
        JSONObject obj = JSONObject.fromObject(o);
        String b = obj.getString("result");
        obj = JSONObject.fromObject(b);
        b = obj.getString("data");
        System.out.println(b);
        JSONArray msg = JSONArray.fromObject(b);
        for (int i = 0; i < msg.size(); i++) {
            JSONObject json = msg.getJSONObject(i);
            System.out.println(json);
            User user = new User();
            Date date = datedeal.parse(json.getString("hiredate"));
            user.setUsercode(json.getString("usercode"));
            user.setUsername(json.getString("username"));
            user.setDepartment(json.getString("department"));
            user.setHiredate(new java.sql.Date(date.getTime()));
            list.add(user);
            System.out.println(user.getUsercode());
        }
//        System.out.println(list);
//        for(int i = 0;i < list.size(); i ++){
//            System.out.println(list.get(i).getHiredate());
//        }


    }
    public static String StrData(){
        String url = "http://192.168.51.84:8099/get";

        Map Field = new HashMap();

        Calendar time = new GregorianCalendar();
        time.setTime(new Date());
        time.add(time.DATE,-1);

        Date date = time.getTime();
        String startTime=new java.sql.Date(date.getTime()).toString();
        String lastTime=new java.sql.Date(new Date().getTime()).toString() ;
        System.out.println(startTime);
        System.out.println(lastTime);

        Field.put("StartTime",startTime);
        Field.put("LastTime",lastTime);

        String result = HttpDeal(url,Field);

        return result;
    }

    public static String HttpDeal(String url,Map Field){
        String result = "";
        BufferedReader read = null;
        try {
            URL Url = new URL(url + "?" + urlencode(Field));
            URLConnection connection = Url.openConnection();
            connection.connect();
            read = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = read.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public static String urlencode(Map<String, Object> data) {
        //将map里的参数变成像 showapi_appid=###&showapi_sign=###&的样子
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
