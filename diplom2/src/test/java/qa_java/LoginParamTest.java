package qa_java;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import qa_java.client.UserClient;
import qa_java.generators.UserGenerator;
import qa_java.model.User;

import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

@RunWith(Parameterized.class)
public class LoginParamTest extends BaseTest {


    private final User user;
    private UserClient userClient;


    public LoginParamTest(User user, String message, int statusCode) {
        this.user = user;
        this.message = message;
        this.statusCode = statusCode;
    }

    @Parameterized.Parameters(name = "Пользователь {0} Код {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {UserGenerator.getWrongLoginField(), "email or password are incorrect", SC_UNAUTHORIZED},
                {UserGenerator.getWrongPassField(), "email or password are incorrect", SC_UNAUTHORIZED},
        };
    }

    @Before
    public void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Неуспешная Авторизация")
    @Description("Нельзя войти с неверными email, password")
    public void loginUser_WrongCred_NotLogged() {

        ValidatableResponse responseCreate = userClient.loginUser(user);
        responseCreate.log().all();

        actualMessage = messageExtract(responseCreate);
        statusCodeActual = getStatusCodeActual(responseCreate);

        Assert.assertEquals("Запрещено входить с неверными полями", message, actualMessage);
        Assert.assertEquals("Статус код не тот", statusCode, statusCodeActual);
    }
}