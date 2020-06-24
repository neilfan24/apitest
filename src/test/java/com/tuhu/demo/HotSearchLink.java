package com.tuhu.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class HotSearchLink
{
    private String name;

    @BeforeClass
    public void setUp()
    {
        baseURI = Settings.testURL;
    }

    @Test (priority = 1)
    public void createHotSearchAppRoute() throws InterruptedException
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
                .assertThat().body("jump_url",containsString("/bbs/tab/recommend"))
                .assertThat().body("jump_url_type",equalTo(1));
    }

    @Test (priority = 2)
    public void createHotSearchH5() throws InterruptedException
    {
        Thread.sleep(1000);
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
                .prettyPrint();
    }

    @Test (priority = 3)
    public void createHotSearchXCX() throws InterruptedException
    {
        Thread.sleep(1000);
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
                .prettyPrint();
    }
}
