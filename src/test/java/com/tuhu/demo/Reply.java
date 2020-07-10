package com.tuhu.demo;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import static org.hamcrest.Matchers.*;

public class Reply
{
    //private String test;
    private int id;
    private int commentId;
    @BeforeClass
    public void setUP(){
        //指定 URL
        RestAssured.baseURI = Settings.testURL;
        //test = Settings.uniqueValue(Settings.topicBody);
    }

    @Test(priority = 1, description = "c端接口发布评论")
    public void sendReply() throws InterruptedException {
        id = RestAssured.given()
                .header("Accept", "application/json")
                .header("Authorization",Settings.testAuth)
                .contentType("application/json")
                .body("{\n" +
                        "\"body\":\""+ Settings.replyBody +"\",\n" +
                        "\"image_urls\":[\"https://img3.tuhu.org/Comment/FgWGMxIaxgfYp838EckBy_epq018_w1240_h1654.jpg\"],\n" +
                        "\"topic_id\": 3213477\n" +
                        "}")
                .post("/replies")
                .then()
                .statusCode(201)
                .body("body", containsString(Settings.replyBody))
                .extract().path("id");
        System.out.println(id);
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "校验回复列表第一条数据正确性")
    public void replyList() throws InterruptedException
    {
        Thread.sleep(10000);
        RestAssured.given()
                .header("Accept","application/json")
                .param("topic_id","3213477").param("is_blocked","no").get("/replies")
                //.prettyPrint();
                .then()
                .body("data.id[0]", equalTo(id))
                .body("data.body_original.content[0]",hasItem(Settings.replyBody));
    }

    @Test(priority = 3, description = "点赞评论")
    public void voteReply()
    {
        RestAssured.given()
                .header("Authorization",Settings.testAuth)
                .header("Accept","application/json")
                .param("votable_id",id)
                .param("vote_type","reply")
                .post("/votes")
                .then()
                .statusCode(201);
                //.prettyPrint();
    }

    @Test(priority = 4, description = "评论取消点赞")
    public void deleteVoteReply()
    {
        RestAssured.given()
                .param("votable_id",id)
                .param("vote_type","reply")
                .header("Authorization",Settings.testAuth)
                .header("Accept","application/json")
                .delete("/votes/1")
                .then()
                .statusCode(200);
    }

    @Test(priority = 5, description = "后台编辑评论")
    public void editReply()
    {
        RestAssured.given()
                .header("Authorization",Settings.testBackendAuth)
                .header("Accept","application/json")
                .contentType("application/json")
                .body("{\n" +
                        "\"body\": \"编辑一下评论哈\"\n" +
                        "}")
                .patch("/replies/" + id)
                .then()
                .body("body", containsString("编辑一下评论哈"));
    }

    @Test(priority = 6, description = "后台屏蔽评论")
    public void blockedReply()
    {
        RestAssured.given()
                .header("Authorization",Settings.testBackendAuth)
                .header("Accept","application/json")
                .contentType("application/json")
                .body("{\n" +
                        "\"is_blocked\": \"yes\"\n" +
                        "}")
                .patch("/replies/" +id)
                .then()
                .body("is_blocked", equalTo("yes"));
    }

    @Test(priority = 7, description = "后台回复当前评论")
    public void commentReply()
    {
        commentId = RestAssured.given()
                .header("Authorization",Settings.testBackendAuth)
                .header("Accept","application/json")
                .contentType("application/json")
                .body("{\n" +
                        "\"body\": \""+ Settings.commentReply+ "\",\n" +
                        "\"normal_user_id\": 37,\n" +
                        "\"source\": \"BACKEND\",\n" +
                        "\"source_id\": "+ id +",\n" +
                        "\"topic_id\": 3213477,\n" +
                        "\"type\": \"normal\",\n" +
                        "\"user_id\": 37\n" +
                        "}")
                .post("/replies")
                //.prettyPrint();
                .then()
                .statusCode(201)
                .body("body",containsString(Settings.commentReply))
                .body("user_id", equalTo(37))
                .body("source", equalTo("BACKEND"))
                .body("source_id", equalTo(id))
        .extract().path("id");
        System.out.println(commentId);
    }

    @Test(priority = 8, description = "删除评论")
    public void deleteReply()
    {
        RestAssured.given()
                .header("Authorization",Settings.testBackendAuth)
                .header("Accept","application/json")
                .contentType("application/json")
                .delete("/replies/" + commentId)
                .then()
                .statusCode(200);
    }
}