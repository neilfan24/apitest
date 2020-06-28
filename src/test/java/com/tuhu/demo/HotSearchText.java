package com.tuhu.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class HotSearchText
{
    private String name;
    private int id;

    @BeforeClass
    public void setUp()
    {
        baseURI = Settings.testURL;
    }

    //测试从后台创建文本类型的热搜词接口
    @Test (priority = 1)
    public void createTextHotSearch()
    {
        name = given()
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "    \"name\": \""+ Settings.hotsearchname_text +"\",\n" +
                        "    \"sort\": 1,\n" +
                        "    \"type\": 1\n" +
                        "}")
                .post("/hot-searches")
                //.prettyPrint();
                .then()
                .assertThat().body("name", equalTo(Settings.hotsearchname_text))
                .extract().path("name");
        System.out.println(name);
    }

    //验证热搜词name是否不可重名
    @Test(priority = 2)
    public void sameNameVaildation()
    {
        given()
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "    \"name\": \""+ Settings.hotsearchname_text +"\",\n" +
                        "    \"sort\": 1,\n" +
                        "    \"type\": 1\n" +
                        "}")
                .post("/hot-searches")
                //.prettyPrint();
                .then()
                .body("errors.name",hasItem("热搜词名称已被占用"));
                //.assertThat().body("message",equalTo("The given data was invalid."));
    }

    //验证C端热搜词接口返回数据正确性
    @Test (priority = 3)
    public void hotSearch()
    {
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

    //测试禁用热搜词
    @Test (priority = 4)
    public void hotSearchDisable()
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

    //测试启用热搜词
    @Test (priority = 5)
    public void hotSearchEnable()
    {
        given()
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .contentType("application/json")
                .body("{\n" +
                        "\"state\": 1\n" +
                        "}")
                .patch("hot-searches/" + id)
                .then()
                .assertThat().body("id",equalTo(id))
                .assertThat().body("state",equalTo(1));
    }
}
