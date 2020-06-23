package com.tuhu.demo;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;

public class ReplyList
{
    @BeforeClass
    public void setUP(){
        //指定 URL
        RestAssured.baseURI = Settings.prodURL;
    }

    @Test
    public void testGET()
    {
        RestAssured.given()
                .header("Accept","application/json")
                .param("topic_id","12775058").param("is_blocked","no").get("/replies")
                //.then().extract().path("current_page");
                //.prettyPrint();
                .then().body("data.id[0]", equalTo(4368989));
    }

}