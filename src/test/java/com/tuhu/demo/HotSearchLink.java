package com.tuhu.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class HotSearchLink
{
    @BeforeClass
    public void setUp()
    {
        baseURI = Settings.testURL;
    }

    @Test (priority = 1, description = "创建跳转到APP内部路径的热搜词")
    public void createHotSearchAppRoute()
    {
        given()
                .contentType("application/json")
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .body("{\n" +
                        "\"jump_url\": \"/bbs/tab/recommend\",\n" +
                        "\"jump_url_type\": 1,\n" +
                        "\"name\": \""+ Settings.hotsearchname_Route +"\",\n" +
                        "\"sort\": 1,\n" +
                        "\"type\": 2\n" +
                        "}")
                .post("/hot-searches")
                //.prettyPrint();
                .then()
                .assertThat().body("name",equalTo(Settings.hotsearchname_Route))
                .assertThat().body("jump_url",containsString("/bbs/tab/recommend"))
                .assertThat().body("jump_url_type",equalTo(1));
    }

    @Test (priority = 2, description = "创建跳转到H5的热搜词")
    public void createHotSearchH5()
    {
        given()
                .contentType("application/json")
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .body("{\n" +
                        "\"jump_url\": \"https://wx.tuhu.cn/vue/NaActivity/pages/home/index?id=5BC5FAD2&mkt=2020061108\",\n" +
                        "\"jump_url_type\": 2,\n" +
                        "\"name\": \""+ Settings.hotsearchname_H5 +"\",\n" +
                        "\"sort\": 1,\n" +
                        "\"type\": 2\n" +
                        "}")
                .post("/hot-searches")
                .then()
                .body("name",equalTo(Settings.hotsearchname_H5))
                .body("jump_url",containsString("https://wx.tuhu.cn/vue/NaActivity/pages/home/index?id=5BC5FAD2&mkt=2020061108"))
                .body("jump_url_type",equalTo(2));
                //.prettyPrint();
    }

    @Test (priority = 3, description = "创建跳转到小程序的热搜词")
    public void createHotSearchXCX()
    {
        given()
                .contentType("application/json")
                .header("Accept","application/json")
                .header("Authorization",Settings.testBackendAuth)
                .body("{\n" +
                        "\"jump_url\": \"plugin-private://wx2b03c6e691cd7370/pages/live-player-plugin?room_id=117\",\n" +
                        "\"jump_url_type\": 3,\n" +
                        "\"name\": \""+ Settings.hotsearchname_XCX +"\",\n" +
                        "\"resource_id\":1,\n" +
                        "\"sort\": 1,\n" +
                        "\"type\": 2\n" +
                        "}")
                .post("/hot-searches")
                .then()
                .body("name",equalTo(Settings.hotsearchname_XCX))
                .body("mini_program_app_id",equalTo("wx27d20205249c56a3"))
                .body("mini_program_raw_id",equalTo("gh_513038890d99"))
                .body("jump_url",containsString("plugin-private://wx2b03c6e691cd7370/pages/live-player-plugin?room_id=117"))
                .body("jump_url_type",equalTo(3));
                //.prettyPrint();
    }
}
