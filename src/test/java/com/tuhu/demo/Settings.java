package com.tuhu.demo;

import java.text.SimpleDateFormat;

public class Settings {
    public static String testAuth = "Bearer a2fd985022824746b259fe82cc094861"; //test环境用户验证
    public static String prodAuth = "Bearer 9d63fdf6b4934f45b0fea967d9cc766c"; //正式环境用户验证
    public static String testURL = "https://hushuo-api.tuhutest.cn/api";
    public static String prodURL = "https://hushuo-api.tuhu.cn/api";
    public static int testUserid = 11344091;
    public static int prodUserid = 26150043;
    public static String testBackendAuth = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRGYUJEU2xzd2hJRGwxU190Q2hGdVJyZzJ0ZyIsInR5cCI6IkpXVCIsIng1dCI6IjRGYUJEU2xzd2hJRGwxU190Q2hGdVJyZzJ0ZyJ9.eyJuYmYiOjE1OTM0ODMzODUsImV4cCI6MTU5MzQ4Njk4NSwiaXNzIjoiaHR0cHM6Ly9hY2Nlc3MudHVodXRlc3QuY24iLCJhdWQiOlsiaHR0cHM6Ly9hY2Nlc3MudHVodXRlc3QuY24vcmVzb3VyY2VzIiwieWV3dWFwaSJdLCJjbGllbnRfaWQiOiJzaXRlX2h1c2h1byIsInN1YiI6IjA4ZDdkZDJiZmJmYTQ1MGI4NTM3ZGZkMjMzODk3YWEzIiwiYXV0aF90aW1lIjoxNTkzNDgzMzg0LCJpZHAiOiJFbXBsb3llZSIsIm5hbWUiOiJkZXZ0ZWFtIiwiZW1haWwiOiJkZXZ0ZWFtQHR1aHUud29yayIsImVtcGxveWVlX2lkIjoiMTE1MTkiLCJzY29wZSI6WyJvcGVuaWQiLCJ5ZXd1YXBpIl0sImFtciI6WyJFbXBsb3llZSIsIlBhc3N3b3JkIl19.D260h9k1PRnJct48r4tJ8zb5Zu8SNo1GzuvKoOt4fBsfHkBxDdsnkVqH-T3E3JMrr4qXpxDbmBNWLcZ2-fLiuN7mMuqA5M1HkJBzHP36PQXn_wNZuJNb3vOFNwHrnlbEfVbA0PjSD-CprW_xvmB1OJrSV5xMVjfkgPHdptGuPCXgsV3pNAAIk7aEbN_bvHaNizxU8sKkkkmbYY1wAqAbOrbQalxVzm4-p--ox-m2OLMmGHSxle-Kho_YgonwQ8aJ8KPwe2vxzweW99V2sZ6Vo-K6rSk84rAoS919P--LBcr-by1UR4FkrBG0pdPVpWMyDrKqIyG-2cYAc8KkJ6yznw";

    //获取时间戳，转换成string
    public static long timeStamp = System.currentTimeMillis();
    public static SimpleDateFormat temp = new SimpleDateFormat("MMddHHmmss");
    public static String time = temp.format(timeStamp);
    //不可重复的变量使用固定文字+当前时间戳赋值
    public static String topicBody = "apiAutoTest" + time;
    public static String topicTitle = "api自动化" + time;
    public static String hotsearchname_text = "Text" + time;
    public static String hotsearchname_Route = "Route" + time;
    public static String hotsearchname_H5 = "H5" + time;
    public static String hotsearchname_XCX = "XCX" + time;
    public static String naviMenuName = "Navi" + time;

/*    public static String setTimeStamp()
    {
        long timeStamp = System.currentTimeMillis();
        SimpleDateFormat temp = new SimpleDateFormat("MMddHHmmss");
        return temp.format(timeStamp);
    }

    public static String uniqueValue(String value)
    {
        return value + setTimeStamp();
    }*/

    //发帖的body，json转为string
    public static String topicBodyStr = "{\n" +
            "    \"body\": \"" + topicBody +"\",\n" +
            "    \"category_id\": 7,\n" +
            "    \"image_tags\": [\n" +
            "        {\n" +
            "            \"hasAddedTag\": false,\n" +
            "            \"image_url\": \"https://img1.tuhu.org/Yewu/Tousu/FgMr_HoIZN3D5PZHIeHob4jLE2Mc_w563_h562.png\",\n" +
            "            \"imgFilterType\": 0,\n" +
            "            \"tags_list\": []\n" +
            "        }\n" +
            "    ],\n" +
            "    \"title\": \"" + topicTitle +"\",\n" +
            "    \"type\": 4,\n" +
            "    \"vehicle_line_id\": [\n" +
            "        0\n" +
            "    ],\n" +
            "    \"extensions\": {}\n" +
            "}";
}
