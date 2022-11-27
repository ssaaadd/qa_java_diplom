package qa_java.client;

import io.restassured.response.ValidatableResponse;
import qa_java.model.User;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {

    public static final String CREATE_PATH = "/api/auth/register";
    public static final String LOGIN_PATH = "/api/auth/login";
    public static final String LOGOUT_PATH = "/api/auth/logout";
    public static final String USER_PATH = "/api/auth/user";



    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(CREATE_PATH)
                .then();

    }

    public ValidatableResponse loginUser(User user){
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(LOGIN_PATH)
                .then();
    }

    public ValidatableResponse logoutUser(User user){
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(LOGOUT_PATH)
                .then();
    }

    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .spec(getSpec())
                .when()
                .delete(USER_PATH)
                .then();
    }
}
