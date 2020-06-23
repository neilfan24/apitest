package com.tuhu.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class HotSearch
{
    private String name;
    private int id;

    @BeforeClass
    public void setUp()
    {
        baseURI = Settings.testURL;
        name = given()
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "    \"name\": \""+ Settings.hotsearch_name +"\",\n" +
                        "    \"sort\": 1,\n" +
                        "    \"type\": 1\n" +
                        "}")
                .post("/hot-searches")
                //.prettyPrint();
                .then()
                .assertThat().body("name", equalTo(Settings.hotsearch_name))
                .extract().path("name");
        System.out.println(name);
    }

    @Test (priority = 1)
    public void hotSearch() {
        id = given()
                .header("Accept", "application/json")
                .param("state", 1)
                .get("/hot-searches")
                //.prettyPrint();
                .then()
                .assertThat().body("data.name[0]", equalTo(name))
                .assertThat().body("data.type[0]", equalTo(1))
                .extract().path("data.id[0]");
        System.out.println(id);
    }

    @Test (priority = 2)
    public void hotSearchState()
    {
        given()
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "\"state\": 2\n" +
                        "}")
                .patch("hot-searches/" + id)
                .then()
                .assertThat().body("id",equalTo(id))
                .assertThat().body("state",equalTo(2));
    }
}
