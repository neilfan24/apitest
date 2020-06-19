package com.tuhu.demo;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

public class DelVote
{
    @BeforeClass
    public void setUp()
    {
        RestAssured.baseURI = "http://hushuo-api.tuhu.cn/api";
    }

    @Test
    public void topicDetailDelVote()
    {
        given().param("votable_id","12780655").
                param("vote_type","topic").
                header("Authorization","Bearer 9d63fdf6b4934f45b0fea967d9cc766c")
                .when()
                .delete("/votes/1")
                .then().assertThat().statusCode(200);
    }
}
