package apiUtils;

import io.restassured.response.Response;

public class Categories extends Base {

    public static Response getCategoriesList() {
        return response = request.when()
                .get("/blog/categories/")
                .then()
                .extract().response();
    }

    public static Response addNewBlogCategory(int id, String categoryName) {
        jsonBody.put("id", id);
        jsonBody.put("name", categoryName);
        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .post("/blog/categories/")
                .then()
                .extract().response();
    }

    public static Response addNewBlogCategory(String categoryName) {
        jsonBody.put("name", categoryName);
        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .post("/blog/categories/")
                .then()
                .extract().response();
    }

    public static Response addNewBlogCategory(int categoryName) {
        jsonBody.put("name", categoryName);
        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .post("/blog/categories/")
                .then()
                .extract().response();
    }

    public static Response addNewBlogCategoryWithId(int id) {
        jsonBody.put("id", id);
        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .post("/blog/categories/")
                .then()
                .extract().response();
    }

    public static Response deleteBlogCategory(int id) {
        return response = request.when()
                .delete("/blog/categories/" + id)
                .then()
                .extract().response();
    }

    public static Response getListOfPostsForCategory(int id) {
        return response = request.when()
                .get("/blog/categories/" + id)
                .then()
                .extract().response();
    }

    public static Response updateBlogCategoryName(int id, String categoryName) {
        jsonBody.put("id", id);
        jsonBody.put("name", categoryName);
        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .put("/blog/categories/" + id)
                .then()
                .extract().response();
    }
}
