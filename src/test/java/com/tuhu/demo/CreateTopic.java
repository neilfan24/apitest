package com.tuhu.demo;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import static org.hamcrest.Matchers.*;


public class CreateTopic
{
    //取帖子的id，删除帖子时需要用
    private int id;

    @BeforeClass
    public void setUp()
    {
        RestAssured.baseURI = Settings.testURL;
    }

    //根据创建帖子的id做删除操作
    @AfterClass
    public void tearDown()
    {
        RestAssured.given()
                .header("Authorization", Settings.testAuth)
                .delete("/topics/" + id)
                .then()
                .statusCode(200);
    }

    @Test
    public void createTopic()
    {
        //post请求访问mobile/topic发帖接口，并验证response中body和title是否与发帖时一致
        id = RestAssured
                .given().contentType("application/json")
                .header("Authorization", Settings.testAuth)
                .header("Accept","application/json")
                .body(Settings.topicBodyStr)
                .post("/mobile/topic")
                //.prettyPrint();
                .then()
                .assertThat().body("body",containsString(Settings.body))
                .assertThat().body("title",equalTo(Settings.title))
                //取出response中的帖子id，赋值给变量id，用于删除帖子
                .extract().path("id");
        System.out.println(id);
    }
}

