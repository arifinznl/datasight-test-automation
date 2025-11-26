package web.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import web.datasight.DatasightPostPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PostSteps {

    DatasightPostPage postPage = new DatasightPostPage();
    String savedTitle;

    @And("User navigate to post management page")
    public void userNavigateToPostManagementPage() {
        postPage.navigateToPostManagement();
    }

    @When("User input title {string}")
    public void userInputTitle(String title) {
        savedTitle = title;
        postPage.inputPostTitle(title);
    }

    @And("User input Title \\(English) {string}")
    public void userInputTitleEnglish(String englishTitle) {
        postPage.inputEnglishTitle(englishTitle);
    }

    @And("User input Slug {string}")
    public void userInputSlug(String slug) {
        postPage.inputSlug(slug);
    }

    @When("User click Add New Post Button")
    public void userClickAddNewPostButton() {
        postPage.clickAddNewPost();
    }

    @Then("Post should be created successfully")
    public void postShouldBeCreatedSuccessfully() {
        assertTrue("Post not found after creation!", postPage.isPostCreated(savedTitle));
    }

    @Given("User is already logged in and on the Posts List page")
    public void userIsAlreadyLoggedInAndOnThePostsListPage() {
        assertTrue(postPage.isOnPostListPage());
    }

    @When("User delete post with title {string}")
    public void userDeletePostWithTitle(String title) {
        postPage.deletePost(title);
    }

    @Then("Post {string} should no longer appear in the list")
    public void postShouldNoLongerAppearInTheList(String title) {
        assertFalse(postPage.isPostVisible(title));
    }
}
