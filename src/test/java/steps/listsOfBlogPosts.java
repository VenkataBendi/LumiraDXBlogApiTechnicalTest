package steps;

import apiUtils.Base;
import apiUtils.Posts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import restUtils.RestUtil;

public class listsOfBlogPosts extends Base {
    @Given("I set the GET service endpoint for list of posts with parameters {int} , {int}, {string}")
    public void getListOfPosts(int pageNumber, int perPage, String pageNum) {
        boolean pageBool = Boolean.parseBoolean(pageNum);
        response = Posts.getListOfPosts(pageNumber, perPage, pageBool);
    }

    @And("check response for {int} , {int} and totalPages")
    public void checkResponseForTotalPostsTotalPages(int pageNumber, int perPage) {
        int displayedPgNum = RestUtil.getJsonResponseAsInteger("page");
        int displayedPerPage = RestUtil.getJsonResponseAsInteger("per_page");
        int disPlayedTotalPages = RestUtil.getJsonResponseAsInteger("pages");
        int displayedTotalPosts = RestUtil.getJsonResponseAsInteger("total");
        int totalPages = (int) Math.ceil((double) displayedTotalPosts / displayedPerPage);
        Assert.assertEquals(pageNumber, displayedPgNum);
        Assert.assertEquals(perPage, displayedPerPage);
        Assert.assertEquals(totalPages, disPlayedTotalPages);

    }

    @Given("I set the GET service endpoint for list of posts with parameters {int} , {int}, {int}")
    public void getListOfPostsForYear(int year, int pageNumber, int perPage) {
        response = Posts.getListOfPostsForYear(year, pageNumber, perPage);
    }

    @Given("I set the GET service endpoint for list of posts with parameters {int}")
    public void getListOfPostsForYear(int year) {
        response = Posts.getListOfPostsForYear(year);
    }

    @And("check response for year {int}")
    public void checkResponseForYear(int year) {
        Assert.assertTrue(RestUtil.getJsonResponseAsString("items[0].pub_date")
                .contains(Integer.toString(year)));
    }

    @Given("I set the GET service endpoint for list of posts with parameters {int} , {int} , {int}, {int}")
    public void getListOfPostsForYearMonth(int month, int year, int pageNumber, int perPage) {
        response = Posts.getListOfPostsForMonthAndYear(month, year, pageNumber, perPage);
    }

    @Given("I set the GET service endpoint for list of posts with parameters {int} , {int}")
    public void getListOfPostsForYearMonth(int month, int year) {
        response = Posts.getListOfPostsForMonthAndYear(month, year);
    }

    @And("check response for {int} and {int}")
    public void checkResponseForYearAndMonth(int month, int year) {
        Assert.assertTrue(RestUtil.getJsonResponseAsString("items[0].pub_date")
                .contains(Integer.toString(year)));
        Assert.assertTrue(RestUtil.getJsonResponseAsString("items[0].pub_date")
                .contains(Integer.toString(month)));
    }

    @Given("I set the GET service endpoint for list of posts with parameters {int} , {int} , {int}, {int}, {int}")
    public void getListOfPostsForYearMonthDate(int date, int month, int year,
                                               int pageNumber, int perPage) {
        response = Posts.getListOfPostsForMonthYearAndDate(date, month, year, pageNumber, perPage);
    }

    @Given("I set the GET service endpoint for list of posts with parameters {int} , {int} , {int}")
    public void iSetTheGETServiceEndpointForListOfPostsWithParameters(int date, int month, int year) {
        response = Posts.getListOfPostsForMonthYearAndDate(date, month, year);
    }

    @And("check response for {int}, {int}, {int}")
    public void checkResponseForYearMonthDate(int date, int month, int year) {
        Assert.assertTrue(RestUtil.getJsonResponseAsString("items[0].pub_date")
                .contains(Integer.toString(year)));
        Assert.assertTrue(RestUtil.getJsonResponseAsString("items[0].pub_date")
                .contains(Integer.toString(month)));
        Assert.assertTrue(RestUtil.getJsonResponseAsString("items[0].pub_date")
                .contains(Integer.toString(date)));

    }

    @Given("I set the GET service endpoint for list of posts without parameters")
    public void getListOfPostsWithoutQueryParams() {
        response = Posts.getListOfPosts();
    }

    @Given("I set the GET service endpoint for list of posts with parameters {int} , {string}")
    public void getListOfPosts(int pageNumber, String pageNum) {
        boolean pageBool = Boolean.parseBoolean(pageNum);
        response = Posts.getListOfPosts(pageNumber, pageBool);

    }
}
