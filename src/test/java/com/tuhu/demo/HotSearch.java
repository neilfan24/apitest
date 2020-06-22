package com.tuhu.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class HotSearch
{
    private String name;
    @BeforeClass
    public void setUp()
    {
        baseURI = Settings.testURL;
        name = given()
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "    \"name\": \"apitest3\",\n" +
                        "    \"sort\": 1,\n" +
                        "    \"type\": 1\n" +
                        "}")
                .post("/hot-searches")
                .then()
                .assertThat().body("name", equalTo("apitest3"))
                .extract().path("name");
        System.out.println(name);
    }

    @Test
    public void hotSearch()
    {
        given()
                .header("Accept","application/json")
                .param("state",1)
                .get("/hot-searches")
                .then()
                .assertThat().body("data.name[0]",equalTo(name))
                .assertThat().body("data.type[0]",equalTo(1));
    }
}
