package api.stepdef;

import api.pages.TagApi;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class TagApiSteps {

    TagApi tagApi = new TagApi();
    Response response;

    @When("Get list of tags")
    public void getListOfTags() {
        response = tagApi.getTags();
    }

    @When("Get posts for tag {string}")
    public void getPostsForTag(String tag) {
        response = tagApi.getPostsByTag(tag);
    }

    @Then("Tags response status should be {int}")
    public void tagsResponseStatusShouldBe(int code) {
        assertEquals(code, response.statusCode());
    }
}
