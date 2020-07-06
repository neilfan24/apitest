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

    @Test(priority = 1, description = "新建推荐导航")
    public void createNviMenu()
    {
        name = given()
                .header("Accept","application/json")
                .header("Authorization", Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "\"allowJumpHome\": 1,\n" +
                        "\"feedId\": 50,\n" +
                        "\"name\": \""+ Settings.naviMenuName +"\",\n" +
                        "\"pool\": 1,\n" +
                        "\"sort\": 1\n" +
                        "}")
                .post("/navigation-menus")
                /*.then()
                .body("data.name",equalTo(Settings.naviMenuName))
                .extract().path("data.name");
        System.out.println(name);*/
                .prettyPrint();
    }

    //@Test(priority = 2, description = "C端推荐导航接口校验新建的导航信息是否正确")
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

    //@Test(priority = 3, description = "后台禁用新建的导航")
    public void disableNaviMenu()
    {
        given()
                .header("Accept","application/json")
                .header("Authorization", Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "\"state\": 2\n" +
                        "}")
                .patch("/navigation-menus/" + id)
                .then()
                .body("data.state",equalTo(2));
    }

    //@Test(priority = 4, description = "后台启用新建的导航")
    public void enableNaviMenu()
    {
        given()
                .header("Accept","application/json")
                .header("Authorization", Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "\"state\": 1\n" +
                        "}")
                .patch("/navigation-menus/" + id)
                .then()
                .body("state",equalTo(1));
    }

    //@Test(priority = 5, description = "后台编辑导航信息，是否支持养车头条跳转")
    public void editNaviMenu()
    {
        given()
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "\"allow_jump_home\": 1\n" +
                        "}")
                .patch("navigation-menus/" + id)
                //.prettyPrint();
                .then()
                .body("allow_jump_home",equalTo(1));
    }

    //@Test(priority = 6, description = "后台编辑导航对应的feed配置，修改feed里的筛选条件")
    public void editNaviFeed()
    {
        given()
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "\"board_ids\": [\"4151/3\"],\n" +
                        "\"pool\": 3,\n" +
                        "\"tag_ids\": [15],\n" +
                        "\"topic_types\": [1],\n" +
                        "\"user_ids\": [37],\n" +
                        "\"vehicle_line_ids\": [\"3433/3605\"]\n" +
                        "}")
                .patch("/feeds/73")
                .then()
                .body("vehicle_line_ids",hasItem("3433/3605"))
                .body("board_ids",hasItem("4151/3"))
                .body("pool",equalTo(3))
                .body("tag_ids",hasItem(15))
                .body("user_ids",hasItem(37))
                .body("topic_types",hasItem(1));
                //.prettyPrint();
    }
}
