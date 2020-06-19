package com.tuhu.demo;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddVote
{
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = Settings.prodURL;
        given()
                .param("votable_id","12780655")
                .param("vote_type","topic")
                .header("Authorization",Settings.prodAuth)
                .when()
                .delete("/votes/1");
    }

    @Test
    public void topicDetailAddVote()
    {
        given()
                .param("votable_id","12780655")
                .param("vote_type","topic")
                .header("Authorization", Settings.prodAuth)
                .when()
                .post("/votes")
                .then().statusCode(201).and().body("user_id",equalTo(Settings.prodUserid));
    }
}
