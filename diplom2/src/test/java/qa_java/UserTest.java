package qa_java;

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
    public void setUp() {
//        Создаем шаблоны Пользователей
        userClient = new UserClient();
        userDefault = UserGenerator.getDefault();
    }

    @After
    public void cleanUp() {
//        Удаляем созданного Пользователя
        userClient.deleteUser();
    }

    /**
     * Тесты создания Пользователя
     */

    @Test
    public void createUser_Default_CanBeCreated() {

        ValidatableResponse responseCreate = userClient.createUser(userDefault);
        ValidatableResponse responseLogin = userClient.loginUser(userDefault);
        responseCreate.log().all();


        accessToken = accessTokenExtract(responseLogin);
        statusCodeActual = getStatusCodeActual(responseCreate);

        boolean isUserCreatedActual = responseCreate.extract().path("success");

        Assert.assertTrue("Пользователь не создан", isUserCreatedActual);
        Assert.assertEquals("Статус код не тот", SC_OK, statusCodeActual);
    }


    @Test
    public void createUser_DoubleUser_NotBeCreated() {

        ValidatableResponse responseCreate = userClient.createUser(userDefault);
        responseCreate.log().all();

        ValidatableResponse responseDoubleCreate = userClient.createUser(userDefault);

        statusCodeActual = getStatusCodeActual(responseDoubleCreate);
        message = responseDoubleCreate.extract().path("message");
        String actualMessage = "User already exists";

        Assert.assertEquals("Запрещено Создание одинаковых Пользователей",
                actualMessage, message);
        Assert.assertEquals("Статус код не тот", SC_FORBIDDEN, statusCodeActual);


    }


}
