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

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;

@RunWith(Parameterized.class)
public class UserParamTest extends BaseTest {


    private final User user;
    private UserClient userClient;


    public UserParamTest(User user, String message, int statusCode) {
        this.user = user;
        this.message = message;
        this.statusCode = statusCode;
    }

    // test data
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {UserGenerator.getWithoutLoginField(), "Email, password and name are required fields", SC_BAD_REQUEST},
                {UserGenerator.getWithoutPassField(), "Email, password and name are required fields", SC_BAD_REQUEST},
                {UserGenerator.getWithoutNameField(), "Email, password and name are required fields", SC_BAD_REQUEST},
        };
    }

    @Before
    public void setUp() {
        userClient = new UserClient();
    }

    @Test
    public void createUser_WithoutCred_NotBeCreated() {

        ValidatableResponse responseCreate = userClient.createUser(user);
        responseCreate.log().all();

        actualMessage = messageExtract(responseCreate);
        statusCodeActual = getStatusCodeActual(responseCreate);

        Assert.assertEquals("Запрещено Создание Пользователя без обязательных полей", message, actualMessage);
        Assert.assertEquals("Статус код не тот", statusCode, statusCodeActual);
    }
}