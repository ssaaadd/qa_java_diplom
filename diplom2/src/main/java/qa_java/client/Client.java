package qa_java.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import qa_java.generators.UserGenerator;

import static io.restassured.RestAssured.given;

public class Client {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static String refreshToken;

    public static String getRefreshToken() {
        return refreshToken;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    private static String accessToken;


    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

    protected RequestSpecification getSpecAuth() {
//        Авторизуемся и получаем токены
        if (accessToken == null) {
            ValidatableResponse res = getToken();
            refreshToken = res.extract().path("refreshToken");
            accessToken = res.extract().path("accessToken");
        }

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .addHeader("refresh_token", refreshToken)
                .addHeader("Authorization", accessToken)
                .build();
    }


    protected ValidatableResponse getToken() {
        return given()
                .contentType(ContentType.JSON)
                .body(UserGenerator.getDefault())
                .log().all()
                .when()
                .post(BASE_URL + UserClient.CREATE_PATH)
                .then();
    }



}
