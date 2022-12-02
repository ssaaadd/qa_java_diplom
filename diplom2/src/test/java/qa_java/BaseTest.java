package qa_java;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class BaseTest {
    public int statusCodeActual;
    public String actualMessage;
    public String message;
    public int statusCode;
    public int trackNumber;

    @Step("Вытаскиваем статус код")
    public int getStatusCodeActual(ValidatableResponse responseLogin) {
        return responseLogin.extract().statusCode();
    }

    @Step("Вытаскиваем токен")
    public String accessTokenExtract(ValidatableResponse responseLogin) {
        return responseLogin.extract().path("accessToken");
    }

    @Step("Вытаскиваем номер заказа")
    public int trackExtract(ValidatableResponse responseCreate) {
        return responseCreate.extract().path("order.number");
    }

    @Step("Вытаскиваем сообщение")
    public String messageExtract(ValidatableResponse responseCreate) {
        return responseCreate.extract().path("message");
    }
}
