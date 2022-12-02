package qa_java;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import qa_java.client.UserClient;
import qa_java.generators.UserGenerator;
import qa_java.model.User;

import static org.apache.http.HttpStatus.SC_OK;

public class LoginTest extends BaseTest {


    private UserClient userClient;
    private User userDefault;
    private String accessToken;


    @Before
    @Step("Создаем шаблоны пользователей")
    public void setUp() {
        userClient = new UserClient();
        userDefault = UserGenerator.getDefault();
        ValidatableResponse responseCreate = userClient.createUser(userDefault);
        accessToken = accessTokenExtract(responseCreate);
    }

    @After
    @Step("Удаление пользователя")
    public void cleanUp() {
        if (accessToken != null) {
            userClient.deleteAuthUser(accessToken);
        }
    }

    @Test
    @DisplayName("Успешный логин пользователя")
    @Description("Проверка авторизации зарегестрированного пользователя")
    public void loginUser_Default_Logged() {
        ValidatableResponse responseLogin = userClient.loginUser(userDefault);

        accessToken = accessTokenExtract(responseLogin);
        statusCodeActual = getStatusCodeActual(responseLogin);

        Assert.assertNotNull("Токен не получен", accessToken);
        Assert.assertEquals("Статус код не тот", SC_OK, statusCodeActual);
    }


}
