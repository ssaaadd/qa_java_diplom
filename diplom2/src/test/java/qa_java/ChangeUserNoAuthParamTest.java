package qa_java;

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
public class ChangeUserNoAuthParamTest extends BaseTest {


    public static final String YOU_SHOULD_BE_AUTHORISED = "You should be authorised";
    private final User user;
    private UserClient userClient;


    public ChangeUserNoAuthParamTest(User user, String message, int statusCode) {
        this.user = user;
        this.message = message;
        this.statusCode = statusCode;
    }

    // test data
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {UserGenerator.getDefaultEmailChange(), YOU_SHOULD_BE_AUTHORISED, SC_UNAUTHORIZED},
                {UserGenerator.getDefaultNameChange(), YOU_SHOULD_BE_AUTHORISED, SC_UNAUTHORIZED},
                {UserGenerator.getDefaultPasswordChange(), YOU_SHOULD_BE_AUTHORISED, SC_UNAUTHORIZED},
        };
    }

    @Before
    public void setUp() {
        userClient = new UserClient();
    }

    @Test
    public void changeUser_NoAuth_NotBeChanged() {

        ValidatableResponse responseCreate = userClient.changeUser(user);
        responseCreate.log().all();

        actualMessage = messageExtract(responseCreate);
        statusCodeActual = getStatusCodeActual(responseCreate);

        Assert.assertEquals("Запрещено изменение Пользователя без авторизации", message, actualMessage);
        Assert.assertEquals("Статус код не тот", statusCode, statusCodeActual);
    }
}