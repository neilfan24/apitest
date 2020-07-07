package com.tuhu.demo;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import static org.hamcrest.Matchers.*;

public class ReplyList
{
    //private String test;
    private int id;
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
                        "\t\"body\":\""+ Settings.replyBody +"\",\n" +
                        "\t\"image_urls\":[\"https://img3.tuhu.org/Comment/FgWGMxIaxgfYp838EckBy_epq018_w1240_h1654.jpg\"],\n" +
                        "\t\"topic_id\": 3213477\n" +
                        "}")
                .post("/replies")
                .then()
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
                .body("data.body_original.content[0]",hasItem("这是一条评论啊"));
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
                .when()
                .delete("/votes/1")
                .then().assertThat().statusCode(200);
    }

}