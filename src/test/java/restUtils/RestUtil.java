package restUtils;

import apiUtils.Base;
import io.restassured.response.ValidatableResponse;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestUtil extends Base {

    public static String getJsonResponseAsString(String jsonPath) {
        return response.getBody().jsonPath().get(jsonPath).toString();
    }

    public static int getJsonResponseListSize(String jsonPath) {
        return response.getBody().jsonPath().getList(jsonPath).size();
    }

    public static String getHtmlResponseAsString(String htmlPath) {
        return response.getBody().htmlPath().get(htmlPath).toString();
    }

    public static ValidatableResponse validateSchema(String expectedSchema) {
        return response.then().body(matchesJsonSchemaInClasspath(expectedSchema));
    }

    public static int getJsonResponseAsInteger(String jsonPath) {
        return Integer.parseInt(response.getBody().jsonPath().get(jsonPath).toString());
    }


}
