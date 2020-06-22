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
    public static String testBackendAuth = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRGYUJEU2xzd2hJRGwxU190Q2hGdVJyZzJ0ZyIsInR5cCI6IkpXVCIsIng1dCI6IjRGYUJEU2xzd2hJRGwxU190Q2hGdVJyZzJ0ZyJ9.eyJuYmYiOjE1OTI4MTYwNDgsImV4cCI6MTU5MjgxOTY0OCwiaXNzIjoiaHR0cHM6Ly9hY2Nlc3MudHVodXRlc3QuY24iLCJhdWQiOlsiaHR0cHM6Ly9hY2Nlc3MudHVodXRlc3QuY24vcmVzb3VyY2VzIiwieWV3dWFwaSJdLCJjbGllbnRfaWQiOiJzaXRlX2h1c2h1byIsInN1YiI6IjA4ZDdkZDJiZmJmYTQ1MGI4NTM3ZGZkMjMzODk3YWEzIiwiYXV0aF90aW1lIjoxNTkyNTUwNzc1LCJpZHAiOiJFbXBsb3llZSIsIm5hbWUiOiJkZXZ0ZWFtIiwiZW1wbG95ZWVfaWQiOiIxMTUxOSIsImVtYWlsIjoiZGV2dGVhbUB0dWh1LndvcmsiLCJzY29wZSI6WyJvcGVuaWQiLCJ5ZXd1YXBpIl0sImFtciI6WyJFbXBsb3llZSIsIlBhc3N3b3JkIl19.L_aiDKYvWwhCiWb58yCV_uw0yb1Pu9EduZVGfimcPd18b-6-5EyY3rbxwuJ1U42nY5HyydOuPAcgdaSAdUirJMoQ72zPMleyqn5SOd0Y3dk7uc0udPO5wuYHzjK1O_f88KaMhv_FlOwJlsmkop1_ppC_j-BC5JzRa_VjfelS9kdOohbrEEsF1sW6wLtYSZM_XIdgyLH97HOOCPFaXE3jPlER_CMAsKoudJFmxFZL18ifKEfWYTYwnEbWk939Hr_AjBAtZHiTfUMWPUQNASc0qpJZBucNjZbNwouY_mNQfnSPxoXoYF5cBUrmLaTkB9w2B5ubha5J-QWgle3isWiexg";

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
    public static String topicBodyStr = "{\n" +
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
