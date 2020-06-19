package com.tuhu.demo;

import java.text.SimpleDateFormat;

public class Settings
{
    public static String testAuth = "Bearer a2fd985022824746b259fe82cc094861"; //test环境用户验证
    public static String prodAuth = "Bearer 9d63fdf6b4934f45b0fea967d9cc766c"; //正式环境用户验证
    public static String testURL = "https://hushuo-api.tuhutest.cn/api";
    public static String prodURL = "https://hushuo-api.tuhu.cn/api";
    public static int testUserid = 11344091;
    public static int prodUserid = 26150043;

    //获取时间戳，转换成string
    public static long timeStamp = System.currentTimeMillis();
    public static SimpleDateFormat temp = new SimpleDateFormat("yyyyMMddHHmm");
    public static String time = temp.format(timeStamp);
    //给body和title字段赋值为固定内容+时间戳,目的为防止重复的title和body
    public static String topicBody = "apiAutoTest" + time;
    public static String body = topicBody;
    public static String topicTitle = "api自动化" + time;
    public static String title = topicTitle;

    //发帖的body，json转为string
    public static String bodyStr = "{\n" +
            "    \"body\": \"" + body +"\",\n" +
            "    \"category_id\": 7,\n" +
            "    \"image_tags\": [\n" +
            "        {\n" +
            "            \"hasAddedTag\": false,\n" +
            "            \"image_url\": \"https://img1.tuhu.org/Yewu/Tousu/FgMr_HoIZN3D5PZHIeHob4jLE2Mc_w563_h562.png\",\n" +
            "            \"imgFilterType\": 0,\n" +
            "            \"tags_list\": []\n" +
            "        }\n" +
            "    ],\n" +
            "    \"title\": \"" + title +"\",\n" +
            "    \"type\": 4,\n" +
            "    \"vehicle_line_id\": [\n" +
            "        0\n" +
            "    ],\n" +
            "    \"extensions\": {}\n" +
            "}";
}
