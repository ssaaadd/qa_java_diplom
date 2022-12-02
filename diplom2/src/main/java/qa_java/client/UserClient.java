package qa_java.client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import qa_java.model.User;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {

    public static final String CREATE_PATH = "/api/auth/register";
    public static final String LOGIN_PATH = "/api/auth/login";
    public static final String USER_PATH = "/api/auth/user";

    @Step("Создаем пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(CREATE_PATH)
                .then();

    }

    @Step("Изменяем поля пользователя БЕЗ авторизации")
    public ValidatableResponse changeUser(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .patch(USER_PATH)
                .then();

    }

    @Step("Изменяем поля пользователя ПОСЛЕ авторизации")
    public ValidatableResponse changeUserAuth(User user, String accessToken) {
        return given()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .body(user)
                .when()
                .patch(USER_PATH)
                .then();

    }

    @Step("Авторизации пользователя")
    public ValidatableResponse loginUser(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(LOGIN_PATH)
                .then();
    }

    @Step("Удаление пользователя ПОСЛЕ создания user.getDefault()")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .spec(getSpecAuth())
                .when()
                .delete(USER_PATH)
                .then();
    }

    @Step("Удаление пользователя ПОСЛЕ авторизации")
    public ValidatableResponse deleteAuthUser(String accessToken) {
        return given()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(USER_PATH)
                .then();
    }

}
