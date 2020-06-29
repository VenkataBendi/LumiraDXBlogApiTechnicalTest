package steps;

import apiUtils.Base;
import apiUtils.Categories;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import restUtils.RestUtil;

public class blogCategories extends Base {
    int size;

    @Given("I set the GET service endpoint for list of blog categories and receive response")
    public void getListOfCategories() {
        response = Categories.getCategoriesList();
    }

    @Given("I have the number of categories present")
    public void getCountOfCategories() {
        response = Categories.getCategoriesList();
        size = RestUtil.getJsonResponseListSize("id");
    }

    @When("I set the POST service endpoint for adding new blog category with id {int} and name {string}")
    public void addCategoryWithIdAndName(int id, String categoryName) {
        response = Categories.addNewBlogCategory(id, categoryName);
    }

    @And("check the get list of categories response if number of categories is incremented by one")
    public void checkCategoryListSizeAfterAddingNewCategory() {
        response = Categories.getCategoriesList();
        Assert.assertEquals((size + 1), RestUtil.getJsonResponseListSize("id"));
    }

    @And("check get list of categories response for the name of the last item to be {string}")
    public void checkIfAddedNameIsCorrect(String categoryName) {
        int listSize = RestUtil.getJsonResponseListSize("id");
        Assert.assertEquals(categoryName,
                (RestUtil.getJsonResponseAsString("[" + (listSize - 1) + "].name")));
    }

    @When("I set the POST service endpoint for adding new blog category with name {string}")
    public void addCategoryWithId(String categoryName) {
        response = Categories.addNewBlogCategory(categoryName);
    }

    @Given("I set the DELETE service endpoint a categories with id {int} and receive response")
    public void deleteCategoryWithId(int id) {
        response = Categories.deleteBlogCategory(id);
    }

    @And("check for id {int} is deleted in the list of categories response")
    public void checkForIdInTheResponse(int id) {
        response = Categories.getCategoriesList();
        String msg = null;
        int listSize = RestUtil.getJsonResponseListSize("id");
        for (int i = 0; i <= listSize - 1; ) {
            int j = RestUtil.getJsonResponseAsInteger("[" + i + "].id");
            if (j == id) {
                msg = "id exists";
                break;
            } else {
                i++;
            }
            msg = "id doesn't exist";
        }
        Assert.assertEquals("id doesn't exist", msg);
    }

    @Then("check title in response contains {string}")
    public void checkTitleInResponseContains(String message) {
        Assert.assertTrue(RestUtil.getHtmlResponseAsString("html.head.title").contains(message));
    }

    @Given("I set the GET service endpoint for list of posts for category id {int} and receive response")
    public void getListOfPostsForCategoryId(int id) {
        response = Categories.getListOfPostsForCategory(id);
    }

    @Then("check categoryId in list of posts response is {int}")
    public void checkCategoryIdInResponseIs(int id) {
        Assert.assertEquals(id,
                RestUtil.getJsonResponseAsInteger("id"));
    }

    @Given("I set the PUT service endpoint for updating a blog category with id {int} and pass the updated category name {string}")
    public void updateBlogCategoryName(int id, String newCategoryName) {
        response = Categories.updateBlogCategoryName(id, newCategoryName);
    }

    @Then("check get list of categories response for the name of the item with id {int} to be {string}")
    public void checkGetResponseForTheNameOfhIdToBe(int id, String expectedCategoryName) {
        response = Categories.getCategoriesList();
        String actualName = null;
        int listSize = RestUtil.getJsonResponseListSize("id");
        for (int i = 0; i <= listSize - 1; ) {
            int j = RestUtil.getJsonResponseAsInteger("[" + i + "].id");
            if (j == id) {
                actualName = RestUtil.getJsonResponseAsString("[" + i + "].name");
                break;
            } else i++;
        }
        Assert.assertEquals(expectedCategoryName, actualName);
    }

    @Then("check response contains {string} {string}")
    public void checkResponseMessage(String node, String expectedMessage) {
        Assert.assertEquals(expectedMessage, response.getBody().jsonPath().get(node).toString());
    }

    @And("check get response for the name of the item with id <id> to be <expectedCategoryName>")
    public void checkForTheNameOfIdToBeExpectedCategoryName(int id, String expectedCategoryName) {
        response = Categories.getCategoriesList();
        String actualName = null;
        int listSize = RestUtil.getJsonResponseListSize("id");
        for (int i = 0; i <= listSize - 1; ) {
            int j = RestUtil.getJsonResponseAsInteger("[" + i + "].id");
            if (j == id) {
                actualName = RestUtil.getJsonResponseAsString("[" + i + "].name");
                break;
            } else i++;
        }
        Assert.assertEquals(expectedCategoryName, actualName);
    }

    @Given("I set the POST service endpoint for adding new blog category with categoryName as {int}")
    public void addNewBlogCategoryWithCategoryNameAsInt(int categoryName) {
        response = Categories.addNewBlogCategory(categoryName);
    }

    @When("I set the POST service endpoint for adding new blog category with id {int}")
    public void addNewBlogCategoryWithId(int id) {
        response = Categories.addNewBlogCategoryWithId(id);
    }
}