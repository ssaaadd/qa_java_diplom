package qa_java.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qa_java.generators.UserGenerator;

import static io.restassured.RestAssured.given;

public class Client {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String LOGIN_PATH = "/api/auth/login";


    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

    protected RequestSpecification getSpecAuth() {
//        Авторизуемся и получаем токен
        Response res = getToken();
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .addHeader("refresh_token", res.path("refreshToken"))
                .addHeader("Authorization", res.path("accessToken"))
                .build();
    }


    protected Response getToken() {
        return given()
                .contentType(ContentType.JSON)
                .body(UserGenerator.getDefault())
                .when()
                .post(BASE_URL + LOGIN_PATH)
                .then().extract().response();
    }

}
