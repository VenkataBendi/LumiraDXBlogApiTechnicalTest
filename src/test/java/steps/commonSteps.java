package steps;

import apiUtils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import restUtils.RestUtil;

public class commonSteps extends Base {

    @And("validate response json schema with {string}")
    public void validateResponseJsonSchema(String expectedSchema) {
        RestUtil.validateSchema(expectedSchema);
    }

    @And("check response content type is {string}")
    public void responseContentTypeIs(String contentType) {
        Assert.assertEquals(contentType, response.getContentType());
    }

    @Then("check statusCode is {int}")
    public void checkStatusCodeIs(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("check response for message {string}")
    public void checkResponseForMessage(String message) {
        Assert.assertEquals(message, RestUtil.getJsonResponseAsString("message"));
    }
}
