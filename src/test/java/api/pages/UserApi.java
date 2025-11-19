package api.pages;

import core.BaseApi;
import io.restassured.response.Response;
import org.json.JSONObject;

public class UserApi extends BaseApi {

    public Response createUser(String email, String first, String last) {
        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("firstName", first);
        body.put("lastName", last);

        return baseRequest()
                .body(body.toString())
                .post("/user/create")
                .then().log().all()
                .extract().response();
    }

    public Response getUser(String id) {
        return baseRequest()
                .get("/user/" + id)
                .then().log().all()
                .extract().response();
    }

    public Response updateUser(String id, String newFirstName) {
        JSONObject body = new JSONObject();
        body.put("firstName", newFirstName);

        return baseRequest()
                .body(body.toString())
                .put("/user/" + id)
                .then().log().all()
                .extract().response();
    }

    public Response deleteUser(String id) {
        return baseRequest()
                .delete("/user/" + id)
                .then().log().all()
                .extract().response();
    }
}
