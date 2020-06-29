package steps;

import apiUtils.Base;
import apiUtils.Posts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import restUtils.RestUtil;

public class updatePosts extends Base {

    @Given("I set the PUT service endpoint for updating a blog post with postId {int} with categoryId {int} and pass updated body {string} and updated title {string}")
    public void updatePostForId(int postID, int categoryId, String body, String title) {
        response = Posts.updatePostForPostId(postID, body, categoryId, title);
    }

    @And("check get post for postID {int} response to match categoryID to {int}, body to {string},title to {string}")
    public void checkPostForPostIDResponseToMatchCategoryIdBodyTitleT(int postID, int categoryId, String body, String title) {
        response = Posts.getPostForPostId(postID);
        Assert.assertEquals(body, RestUtil.getJsonResponseAsString("body"));
        Assert.assertEquals(categoryId, RestUtil.getJsonResponseAsInteger("category_id"));
        Assert.assertEquals(postID, RestUtil.getJsonResponseAsInteger("id"));
        Assert.assertEquals(title, RestUtil.getJsonResponseAsString("title"));

    }

    @Given("I set the PUT service endpoint for updating a blog post with postId {int} and pass updated body {string} and updated title {string}")
    public void updatePostForIdWithNoCategoryId(int postId, String body, String title) {
        response = Posts.updatePostForPostIdWithOutCategoryId(postId, body, title);
    }

    @Given("I set the PUT service endpoint for updating a blog post with postId {int} with categoryId {int} and pass updated body {string}")
    public void updatePostForIdWithNoTitle(int postId, int categoryId, String body) {
        response = Posts.updatePostForPostIdWithOutTitle(postId, body, categoryId);
    }

    @Given("I set the PUT service endpoint for updating a blog post with postId {int} with categoryId {int} and pass updated title {string}")
    public void updatePostForIdWithNoBody(int postId, int categoryId, String title) {
        response = Posts.updatePostForPostIdWithOutBody(postId, categoryId, title);
    }
}

