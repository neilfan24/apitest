package com.tuhu.demo;

import java.text.SimpleDateFormat;

public class Settings {
    public static String testAuth = "Bearer a2fd985022824746b259fe82cc094861"; //test环境用户验证
    public static String prodAuth = "Bearer 9d63fdf6b4934f45b0fea967d9cc766c"; //正式环境用户验证
    public static String testURL = "https://hushuo-api.tuhutest.cn/api";
    public static String prodURL = "https://hushuo-api.tuhu.cn/api";
    public static int testUserid = 11344091;
    public static int prodUserid = 26150043;
    public static String testBackendAuth = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRGYUJEU2xzd2hJRGwxU190Q2hGdVJyZzJ0ZyIsInR5cCI6IkpXVCIsIng1dCI6IjRGYUJEU2xzd2hJRGwxU190Q2hGdVJyZzJ0ZyJ9.eyJuYmYiOjE1OTI5OTMwMzAsImV4cCI6MTU5Mjk5NjYzMCwiaXNzIjoiaHR0cHM6Ly9hY2Nlc3MudHVodXRlc3QuY24iLCJhdWQiOlsiaHR0cHM6Ly9hY2Nlc3MudHVodXRlc3QuY24vcmVzb3VyY2VzIiwieWV3dWFwaSJdLCJjbGllbnRfaWQiOiJzaXRlX2h1c2h1byIsInN1YiI6IjA4ZDdkZDJiZmJmYTQ1MGI4NTM3ZGZkMjMzODk3YWEzIiwiYXV0aF90aW1lIjoxNTkyOTkzMDMwLCJpZHAiOiJFbXBsb3llZSIsIm5hbWUiOiJkZXZ0ZWFtIiwiZW1haWwiOiJkZXZ0ZWFtQHR1aHUud29yayIsImVtcGxveWVlX2lkIjoiMTE1MTkiLCJzY29wZSI6WyJvcGVuaWQiLCJ5ZXd1YXBpIl0sImFtciI6WyJFbXBsb3llZSIsIlBhc3N3b3JkIl19.NdaDUUgnuI2X2j4Sla0imfF0TOgXan0QyNMunE-R5RN7a7R-po3ac4dMc_fLGaJiUCuVmNks4bsmSqiNzeeLTCn-2SIjtW7pw5Y2W04SyWOmgMFgQocgd-gsb0K6bXoGPiwar7Cr9SSVqKiWlmM6mAQZUjogs5TYxOQfmD9Hp6oU--Jx66XKPfU2XCorLrfhxWyxys5BQ6q4UOXJVYwqTLFE-W67kEpfvmsJIfe36Bj7530m9Qsx5Ur6dqxWxB0Zt7ofV3Z5j2xMAOUPaA9w-URxE-rh9_CsqC1RGs5y9h9LT9Cx07UoEYhPTz9wmNwbr0nOR44h3iBKfuynZu7ErQ";

    //获取时间戳，转换成string
    public static long timeStamp = System.currentTimeMillis();
    public static SimpleDateFormat temp = new SimpleDateFormat("MMddHHmmss");
    public static String time = temp.format(timeStamp);
    //不可重复的变量使用固定文字+当前时间戳赋值
    public static String topicBody = "apiAutoTest";
    public static String topicTitle = "api自动化" + time;
    public static String hotsearchname_text = "Text" + time;
    public static String hotsearchname_Route = "Route" + time;
    public static String hotsearchname_H5 = "H5" + time;
    public static String hotsearchname_XCX = "XCX" + time;

    public static String setTimeStamp()
    {
        long timeStamp = System.currentTimeMillis();
        SimpleDateFormat temp = new SimpleDateFormat("MMddHHmmss");
        return temp.format(timeStamp);
    }

    public static String uniqueValue(String pre)
    {
        return pre + setTimeStamp();
    }

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
