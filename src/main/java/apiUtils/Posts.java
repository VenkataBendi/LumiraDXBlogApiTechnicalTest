package apiUtils;

import io.restassured.response.Response;

public class Posts extends Base {

    public static Response getListOfPosts(int pageNumber, int perPage, boolean pageBool) {
        switch (perPage) {
            case 2:
            case 10:
            case 20:
            case 30:
            case 40:
            case 50:
                params.put("page", pageNumber);
                params.put("bool", pageBool);
                params.put("per_page", perPage);
                response = request
                        .params(params)
                        .when()
                        .get("/blog/posts/")
                        .then()
                        .extract().response();
                break;
            default:
                System.out.println("Invalid perPage provided, please provide" +
                        " either 2 or 10 or 20 or 30 or 40 pr 50");
        }
        return response;
    }

    public static Response getListOfPosts(int pageNumber, boolean pageBool) {
        params.put("page", pageNumber);
        params.put("bool", pageBool);
        return response = request
                .params(params)
                .when()
                .get("/blog/posts/")
                .then()
                .extract().response();
    }

    public static Response getListOfPosts() {
        return response = request
                .when()
                .get("/blog/posts/")
                .then()
                .extract().response();
    }

    public static Response getListOfPostsForYear(int year, int pageNumber, int perPage) {
        params.put("page", pageNumber);
        params.put("per_page", perPage);

        return response = request
                .params(params)
                .when()
                .get("/blog/posts/archive/" + year + "/")
                .then()
                .extract().response();
    }

    public static Response getListOfPostsForYear(int year) {
        return response = request
                .params(params)
                .when()
                .get("/blog/posts/archive/" + year + "/")
                .then()
                .extract().response();
    }

    public static Response getListOfPostsForMonthAndYear(int month, int year, int pageNumber, int perPage) {
        params.put("page", pageNumber);
        params.put("per_page", perPage);

        return response = request
                .params(params)
                .when()
                .get("/blog/posts/archive/" + year + "/" + month + "/")
                .then()
                .extract().response();
    }

    public static Response getListOfPostsForMonthAndYear(int month, int year) {
        return response = request
                .params(params)
                .when()
                .get("/blog/posts/archive/" + year + "/" + month + "/")
                .then()
                .extract().response();
    }

    public static Response getListOfPostsForMonthYearAndDate(int date, int month, int year, int pageNumber, int perPage) {
        params.put("page", pageNumber);
        params.put("per_page", perPage);

        return response = request
                .params(params)
                .when()
                .get("/blog/posts/archive/" + year + "/" + month + "/" + date + "/")
                .then()
                .extract().response();
    }

    public static Response getListOfPostsForMonthYearAndDate(int date, int month, int year) {
        return response = request
                .params(params)
                .when()
                .get("/blog/posts/archive/" + year + "/" + month + "/" + date + "/")
                .then()
                .extract().response();
    }

    public static Response createsNewPost(String body, String title, int categoryId) {
        jsonBody.put("body", body);
        jsonBody.put("title", title);
        jsonBody.put("category_id", categoryId);

        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .post("/blog/posts/")
                .then()
                .extract().response();
    }

    public static Response createsNewPostWithOutBody(String title, int categoryId) {
        jsonBody.put("title", title);
        jsonBody.put("category_id", categoryId);

        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .post("/blog/posts/")
                .then()
                .extract().response();
    }

    public static Response createsNewPostWithOutTitle(String body, int categoryId) {
        jsonBody.put("body", body);
        jsonBody.put("category_id", categoryId);

        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .post("/blog/posts/")
                .then()
                .extract().response();
    }

    public static Response createsNewPostWithOutCategoryId(String body, String title) {
        jsonBody.put("body", body);
        jsonBody.put("title", title);

        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .post("/blog/posts/")
                .then()
                .extract().response();
    }

    public static Response deletePost(int postID) {
        return response = request.when()
                .delete("/blog/posts/" + postID)
                .then()
                .extract().response();
    }

    public static Response getPostForPostId(int postID) {
        return response = request
                .when()
                .get("/blog/posts/" + postID)
                .then()
                .extract().response();
    }

    public static Response updatePostForPostId(int postId, String body, int categoryId, String title) {
        jsonBody.put("body", body);
        jsonBody.put("title", title);
        jsonBody.put("category_id", categoryId);

        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .put("/blog/posts/" + postId)
                .then()
                .extract().response();
    }

    public static Response updatePostForPostIdWithOutCategoryId(int postId, String body, String title) {
        jsonBody.put("body", body);
        jsonBody.put("title", title);

        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .put("/blog/posts/" + postId)
                .then()
                .extract().response();
    }

    public static Response updatePostForPostIdWithOutTitle(int postId, String body, int categoryId) {
        jsonBody.put("body", body);
        jsonBody.put("category_id", categoryId);

        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .put("/blog/posts/" + postId)
                .then()
                .extract().response();
    }

    public static Response updatePostForPostIdWithOutBody(int postId, int categoryId, String title) {
        jsonBody.put("title", title);
        jsonBody.put("category_id", categoryId);

        return response = request
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                .put("/blog/posts/" + postId)
                .then()
                .extract().response();
    }


}
