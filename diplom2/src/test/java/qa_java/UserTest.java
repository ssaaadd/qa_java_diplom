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

import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.apache.http.HttpStatus.SC_OK;


public class UserTest extends BaseTest {


    private UserClient userClient;
    private User userDefault;
    private String accessToken;
    private String message;

    @Before
    @Step("Создаем шаблоны пользователей")
    public void setUp() {
        userClient = new UserClient();
        userDefault = UserGenerator.getDefault();
    }

    @After
    @Step("Удаление пользователя")
    public void cleanUp() {
        if (accessToken != null) {
            userClient.deleteAuthUser(accessToken);
        }
    }

    /**
     * Тесты создания Пользователя
     */

    @Test
    @DisplayName("Создание пользователя")
    @Description("Успешное создание пользователя, получение токена")
    public void createUser_Default_CanBeCreated() {

        ValidatableResponse responseCreate = userClient.createUser(userDefault);
        responseCreate.log().all();


        accessToken = accessTokenExtract(responseCreate);
        statusCodeActual = getStatusCodeActual(responseCreate);

        boolean isUserCreatedActual = responseCreate.extract().path("success");

        Assert.assertTrue("Пользователь не создан", isUserCreatedActual);
        Assert.assertEquals("Статус код не тот", SC_OK, statusCodeActual);
    }


    @Test
    @DisplayName("Создание двух одинаковых пользователей")
    @Description("Попытка создать двух одинаковых пользователей")
    public void createUser_DoubleUser_NotBeCreated() {

        ValidatableResponse responseCreate = userClient.createUser(userDefault);
        accessToken = accessTokenExtract(responseCreate);

        responseCreate.log().all();

        ValidatableResponse responseDoubleCreate = userClient.createUser(userDefault);

        statusCodeActual = getStatusCodeActual(responseDoubleCreate);
        message = messageExtract(responseDoubleCreate);

        String actualMessage = "User already exists";

        Assert.assertEquals("Запрещено Создание одинаковых Пользователей",
                actualMessage, message);
        Assert.assertEquals("Статус код не тот", SC_FORBIDDEN, statusCodeActual);


    }


}
