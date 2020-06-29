package steps;

import apiUtils.Base;
import apiUtils.Posts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import restUtils.RestUtil;

public class deletePost extends Base {

    @When("I set the DELETE service endpoint for deleting a blog post with postID {int}")
    public void deletePostForPostId(int postID) {
        response = Posts.deletePost(postID);
    }

    @And("check get list of posts response for postID {int}")
    public void checkGetListForPostId(int postID) {
        response = Posts.getListOfPosts(1, 50, true);
        String msg = null;
        int listSize = RestUtil.getJsonResponseListSize("items");
        for (int i = 0; i <= listSize - 1; ) {
            int j = RestUtil.getJsonResponseAsInteger("items[" + i + "].id");
            if (j == postID) {
                msg = "id exists";
                break;
            } else {
                i++;
            }
            msg = "id doesn't exist";
        }
        Assert.assertEquals("id doesn't exist", msg);
    }
}
