package qa_java;

import io.restassured.response.ValidatableResponse;

public class BaseTest {
    public int statusCodeActual;
    public String actualMessage;
    public String message;
    public int statusCode;
    public int trackNumber;



    public int getStatusCodeActual(ValidatableResponse responseLogin) {
        return responseLogin.extract().statusCode();
    }

    public String accessTokenExtract(ValidatableResponse responseLogin) {
        return responseLogin.extract().path("accessToken");
    }

    public int trackExtract(ValidatableResponse responseCreate) {
        return responseCreate.extract().path("order.number");
    }

    public String messageExtract(ValidatableResponse responseCreate) {
        return responseCreate.extract().path("message");
    }
}
