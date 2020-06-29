package steps;

import apiUtils.Base;
import apiUtils.Posts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import restUtils.RestUtil;

public class createNewPost extends Base {
    int size;

    @Given("I have the number of posts present")
    public void getNumberOfPosts() {
        response = Posts.getListOfPosts();
        size = RestUtil.getJsonResponseAsInteger("total");
    }

    @When("I set the POST service endpoint for adding new blog post for {int}, with {string} and {string}")
    public void addNewPostForCategoryId(int categoryId, String body, String title) {
        response = Posts.createsNewPost(body, title, categoryId);
    }

    @And("check the get list of posts number of posts is incremented by one")
    public void checkPostsListSizeAfterAddingNewPost() {
        response = Posts.getListOfPosts();
        Assert.assertEquals((size + 1), RestUtil.getJsonResponseAsInteger("total"));
    }

    @And("check get list of posts response to match categoryID to {int}, body to {string},title to {string} of the last post")
    public void checkNewPostBodyAndTitle(int categoryId, String body, String title) {

        //int totalPages = Integer.parseInt(RestUtil.getJsonResponseAsString("pages"));
        response = Posts.getListOfPosts(1, 50, true);
        int listSize = RestUtil.getJsonResponseListSize("items");
        int actualCategoryId = RestUtil.getJsonResponseAsInteger("items[" + (listSize - 1) + "].category_id");
        String actualBody = RestUtil.getJsonResponseAsString("items[" + (listSize - 1) + "].body");
        String actualTitle = RestUtil.getJsonResponseAsString("items[" + (listSize - 1) + "].title");

        Assert.assertEquals(categoryId, actualCategoryId);
        Assert.assertEquals(body, actualBody);
        Assert.assertEquals(title, actualTitle);
    }

    @When("I set the POST service endpoint for adding new blog post for category_id {int},  and {string}")
    public void addBlogPostWithOutBody(int categoryID, String title) {
        response = Posts.createsNewPostWithOutBody(title, categoryID);
    }

    @When("I set the POST service endpoint for adding new blog post for category_id {int} and with {string}")
    public void addBlogPostWithOutTitle(int categoryId, String body) {
        response = Posts.createsNewPostWithOutTitle(body, categoryId);
    }

    @When("I set the POST service endpoint for adding new blog post with {string} and {string}")
    public void addBlogPostWithOutCategoryId(String body, String title) {
        response = Posts.createsNewPostWithOutCategoryId(body, title);
    }
}
