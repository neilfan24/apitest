package com.tuhu.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.*;
import org.testng.annotations.*;


public class BoardList {
    @BeforeClass
    public void setUp()
    {
        baseURI = Settings.javatestURL;
    }

    @Step("获取全部板块列表，并验证板块id：2是否返回")
    @Test
    public void GetBoardList()
    {
        given()
                .header("auth-type","oauth")
                .header("Authorization",Settings.testAuth)
                .contentType("application/json")
                .get("/api/boards?is_tree=1&state=1")
                //.prettyPrint();
                .then()
                .body("data.children[3].id[0]",equalTo(2));

    }
}
