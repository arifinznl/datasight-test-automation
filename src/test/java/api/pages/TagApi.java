package api.pages;

import core.BaseApi;
import io.restassured.response.Response;

public class TagApi extends BaseApi {
    public Response getTags() {
        return baseRequest()
                .get("/tag")
                .then().log().all()
                .extract().response();
    }
}
