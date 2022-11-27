package qa_java;

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

    // test data
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {UserGenerator.getDefaultEmailChange(), SC_OK},
                {UserGenerator.getDefaultNameChange(), SC_OK},
                {UserGenerator.getDefaultPasswordChange(), SC_OK},
        };
    }

    @Before
    public void setUp() {
        //        Создаем шаблоны пользователей
        userClient = new UserClient();
        userDefault = UserGenerator.getDefault();
//         Достаем токен
        ValidatableResponse responseCreate = userClient.createUser(userDefault);
        accessToken = accessTokenExtract(responseCreate);
    }

    @After
    public void cleanUp() {
//        Удаляем созданного пользователя
        if (accessToken != null) {
            userClient.deleteAuthUser(accessToken);
        }
    }


    @Test
    public void changeUser_NoAuth_NotBeChanged() {

        ValidatableResponse responseCreate = userClient.changeUserAuth(user, accessToken);
        responseCreate.log().all();


        statusCodeActual = getStatusCodeActual(responseCreate);
        Boolean actualMessage = responseCreate.extract().path("success");

        Assert.assertEquals("Изменение Пользователя должны работать", true, actualMessage);
        Assert.assertEquals("Статус код не тот", statusCode, statusCodeActual);
    }
}