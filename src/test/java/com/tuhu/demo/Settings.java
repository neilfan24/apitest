package com.tuhu.demo;

import java.text.SimpleDateFormat;

public class Settings {
    public static String testAuth = "Bearer a2fd985022824746b259fe82cc094861"; //test环境用户验证
    public static String prodAuth = "Bearer 9d63fdf6b4934f45b0fea967d9cc766c"; //正式环境用户验证
    public static String testURL = "https://hushuo-api.tuhutest.cn/api";
    public static String prodURL = "https://hushuo-api.tuhu.cn/api";
    public static int testUserid = 11344091;
    public static int prodUserid = 26150043;
    public static String testBackendAuth = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRGYUJEU2xzd2hJRGwxU190Q2hGdVJyZzJ0ZyIsInR5cCI6IkpXVCIsIng1dCI6IjRGYUJEU2xzd2hJRGwxU190Q2hGdVJyZzJ0ZyJ9.eyJuYmYiOjE1OTM0OTg1NjcsImV4cCI6MTU5MzUwMjE2NywiaXNzIjoiaHR0cHM6Ly9hY2Nlc3MudHVodXRlc3QuY24iLCJhdWQiOlsiaHR0cHM6Ly9hY2Nlc3MudHVodXRlc3QuY24vcmVzb3VyY2VzIiwieWV3dWFwaSJdLCJjbGllbnRfaWQiOiJzaXRlX2h1c2h1byIsInN1YiI6IjA4ZDdkZDJiZmJmYTQ1MGI4NTM3ZGZkMjMzODk3YWEzIiwiYXV0aF90aW1lIjoxNTkzNDk4NTY3LCJpZHAiOiJFbXBsb3llZSIsIm5hbWUiOiJkZXZ0ZWFtIiwiZW1haWwiOiJkZXZ0ZWFtQHR1aHUud29yayIsImVtcGxveWVlX2lkIjoiMTE1MTkiLCJzY29wZSI6WyJvcGVuaWQiLCJ5ZXd1YXBpIl0sImFtciI6WyJFbXBsb3llZSIsIlBhc3N3b3JkIl19.iPTx259rhDSW9MlJAxW9jBK_fDhEFvnhPvMbLeW4tmBnH1fB_cYm-ztk_Np1EmQ0-l8WqhoS4bR2tdM2CUspXCOGgFHMYcX8JgDMNol_l6ZlQwEPQqvUlGfUzBAbj18tDsssBgpxG_JDu5wMxLfFky6aRiGJ-WUEa1j9SdTABVMV1a554SiTnhzTVibj93opEGupsx0UK4DtEBtNbaA51nCXiwx_rPGfONn6zzWR-iOLbw2w0HCZO-z-EkbIrKq_xLIqcU2BGDDx3mfGR9HvRKNi6yg_V1PGlf2Hodxi3GzUhZcsxHNXj057l0pLTmpQNyODcBSdp_U86Qkji88-Kw";

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
