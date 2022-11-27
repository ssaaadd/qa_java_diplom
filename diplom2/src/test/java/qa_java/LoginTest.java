package qa_java;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import qa_java.client.Client;
import qa_java.client.UserClient;
import qa_java.generators.UserGenerator;
import qa_java.model.User;

import static org.apache.http.HttpStatus.SC_OK;

public class LoginTest extends BaseTest {


    private UserClient userClient;
    private User userDefault;
    private String accessToken;


    @Before
    public void setUp() {
//        Создаем шаблоны пользователей
        userClient = new UserClient();
        userDefault = UserGenerator.getDefault();
    }

    @After
    public void cleanUp() {
//        Удаляем созданного пользователя
        //accessToken = Client.getAccessToken();
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }

    @Test
    public void loginUser_Default_Logged() {
        ValidatableResponse responseCreate = userClient.createUser(userDefault);
        ValidatableResponse responseLogin = userClient.loginUser(userDefault);

        accessToken = accessTokenExtract(responseLogin);
        statusCodeActual = getStatusCodeActual(responseLogin);

        Assert.assertNotNull("Токен не получен", accessToken);
        Assert.assertEquals("Статус код не тот", SC_OK, statusCodeActual);
    }


}
