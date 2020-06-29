package steps;

import apiUtils.Base;
import apiUtils.Posts;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import restUtils.RestUtil;

public class getPost extends Base {

    @Given("I set the GET service endpoint for posts with {int} and receive response")
    public void getPostsWithPostID(int postID) {
        response = Posts.getPostForPostId(postID);
    }

    @Then("check response for postID {int}")
    public void checkResponseForPostID(int postID) {
        Assert.assertEquals(postID, RestUtil.getJsonResponseAsInteger("id"));
    }
}
