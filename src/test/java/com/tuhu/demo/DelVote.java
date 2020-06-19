package com.tuhu.demo;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

public class DelVote
{
    @BeforeClass
    public void setUp()
    {
        RestAssured.baseURI = Settings.prodURL;
    }

    @Test
    public void topicDetailDelVote()
    {
        given()
                .param("votable_id","12780655")
                .param("vote_type","topic")
                .header("Authorization",Settings.prodAuth)
                .when()
                .delete("/votes/1")
                .then().assertThat().statusCode(200);
    }
}
