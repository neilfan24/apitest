package com.tuhu.demo;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class ReplyList
{
    //private String test;
    @BeforeClass
    public void setUP(){
        //指定 URL
        RestAssured.baseURI = Settings.prodURL;
        //test = Settings.uniqueValue(Settings.topicBody);
    }

    @Test
    public void replyList()
    {
        RestAssured.given()
                .header("Accept","application/json")
                .param("topic_id","12775058").param("is_blocked","no").get("/replies")
                .prettyPrint();
                //.then().body("data.id[0]", equalTo(4368989));
    }

}