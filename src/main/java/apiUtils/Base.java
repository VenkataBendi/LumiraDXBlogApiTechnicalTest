package apiUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class Base {

    public static final String BASE_URL = "http://localhost:8888/api";
    public static Response response = null;
    public static RequestSpecification request;
    public static JSONObject jsonBody = new JSONObject();
    public static HashMap<String, Object> params = new HashMap<>();

    public Base() {

        jsonBody.clear();
        params.clear();
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given();


    }


}
