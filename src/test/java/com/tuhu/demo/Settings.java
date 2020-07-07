package com.tuhu.demo;

import java.text.SimpleDateFormat;

public class Settings {
    public static String testAuth = "Bearer a2fd985022824746b259fe82cc094861"; //test环境用户验证
    public static String prodAuth = "Bearer 9d63fdf6b4934f45b0fea967d9cc766c"; //正式环境用户验证
    public static String testURL = "https://hushuo-api.tuhutest.cn/api";
    public static String javaworkURL = "http://int-restful-mkt-content-audit.ad.tuhu.work:9010";
    public static String prodURL = "https://hushuo-api.tuhu.cn/api";
    public static int testUserid = 11344091;
    public static int prodUserid = 26150043;
    public static String testBackendAuth = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRGYUJEU2xzd2hJRGwxU190Q2hGdVJyZzJ0ZyIsInR5cCI6IkpXVCIsIng1dCI6IjRGYUJEU2xzd2hJRGwxU190Q2hGdVJyZzJ0ZyJ9.eyJuYmYiOjE1OTM3NzIxMzUsImV4cCI6MTU5Mzc3NTczNSwiaXNzIjoiaHR0cHM6Ly9hY2Nlc3MudHVodS53b3JrIiwiYXVkIjpbImh0dHBzOi8vYWNjZXNzLnR1aHUud29yay9yZXNvdXJjZXMiLCJ5ZXd1YXBpIl0sImNsaWVudF9pZCI6InNpdGVfaHVzaHVvIiwic3ViIjoiMDhkN2RkMmJhMGM2NDdlMDg0MmFmNWNkZjcwZThiNzgiLCJhdXRoX3RpbWUiOjE1OTM3NzIxMzUsImlkcCI6IkVtcGxveWVlIiwibmFtZSI6ImRldnRlYW0iLCJlbWFpbCI6ImRldnRlYW1AdHVodS53b3JrIiwicGhvbmVfbnVtYmVyIjoiMTU4MDAzNjI3OTgiLCJlbXBsb3llZV9pZCI6IjExNTE5Iiwic2NvcGUiOlsib3BlbmlkIiwieWV3dWFwaSJdLCJhbXIiOlsiRW1wbG95ZWUiLCJQYXNzd29yZCJdfQ.nfKLDMQ0KgxDrq0sczdeC5BI48kWmSZ4QPdcUqtbdDOPcfJNV5h643U017_l7rKi3WOcqHJ5MRbftru6iSD90Jl_B9b_pPdyl7fzuVoaay8wBgLdlHDT4dYfBf7IP9k6sSIUjRntqnmvlXtqURpDdPzh9Pz7qnyjdzpCD-QrhHNpWahbelPjNBgPSFINcnF6-s53RzSyr8rXyd_rbpu-YkGHjdI0m5IEKTGvRdGkMlSnJYajPmDEYBzTPfbWF0HdjDSZjozJSMcm9-2mDzFxRkZSeIef6QqhcyDO-tzcnrHgwUAKawQ58XCKzzWRHBzZqa-iz7oVeFzV2PN8N1eFdg";

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
    public static String replyBody = "这是一条评论啊";

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
