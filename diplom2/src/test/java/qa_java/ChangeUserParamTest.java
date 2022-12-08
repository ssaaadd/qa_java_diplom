package qa_java;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import qa_java.client.UserClient;
import qa_java.generators.UserGenerator;
import qa_java.model.User;

import static org.apache.http.HttpStatus.SC_OK;

@RunWith(Parameterized.class)
public class ChangeUserParamTest extends BaseTest {


    private final User user;
    private UserClient userClient;
    private String accessToken;
    private User userDefault;


    public ChangeUserParamTest(User user, int statusCode) {
        this.user = user;
        this.statusCode = statusCode;
    }

    @Parameterized.Parameters(name = "Пользователь {0} Статус {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {UserGenerator.getDefaultEmailChange(), SC_OK},
                {UserGenerator.getDefaultNameChange(), SC_OK},
                {UserGenerator.getDefaultPasswordChange(), SC_OK},
        };
    }

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
    @DisplayName("Изменение полей пользователя ПОСЛЕ авторизацией")
    @Description("Изменяем email, name, password после авторизации")
    public void changeUser_Auth_toBeChanged() {

        ValidatableResponse responseCreate = userClient.changeUserAuth(user, accessToken);
        responseCreate.log().all();


        statusCodeActual = getStatusCodeActual(responseCreate);
        Boolean actualMessage = responseCreate.extract().path("success");

        Assert.assertEquals("Изменение Пользователя должны работать", true, actualMessage);
        Assert.assertEquals("Статус код не тот", statusCode, statusCodeActual);
    }
}