package com.tuhu.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class NaviMenu
{
    private String name;
    private int id;
    @BeforeClass
    public void setUp()
    {
        baseURI = Settings.testURL;
    }

    @Test(priority = 1)
    public void addNviMenu()
    {
        name = given()
                .header("Accept","application/json")
                .header("Authorization", Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "    \"allow_jump_home\": 0,\n" +
                        "    \"feed_id\": 74,\n" +
                        "    \"name\": \""+ Settings.naviMenuName +"\",\n" +
                        "    \"pool\": 1,\n" +
                        "    \"sort\": 1\n" +
                        "}")
                .post("/navigation-menus")
                .then()
                .body("name",equalTo(Settings.naviMenuName))
                .extract().path("name");
        System.out.println(name);
                //.prettyPrint();
    }

    @Test(priority = 2)
    public void naviMenuList()
    {
        id = given()
                .param("need_attach",1)
                .param("state",1)
                .get("/navigation-menus")
                .then()
                .body("data.name[1]",equalTo(name))
                .extract().path("data.id[1]");
                //.prettyPrint();
    }

    @Test(priority = 3)
    public void disableNaviMenu()
    {
        given()
                .header("Accept","application/json")
                .header("Authorization", Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "    \"state\": 2\n" +
                        "}")
                .patch("/navigation-menus/" + id)
                .then()
                .body("state",equalTo(2));
    }

    @Test(priority = 4)
    public void enableNaviMenu()
    {
        given()
                .header("Accept","application/json")
                .header("Authorization", Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "    \"state\": 1\n" +
                        "}")
                .patch("/navigation-menus/" + id)
                .then()
                .body("state",equalTo(1));
    }
}
