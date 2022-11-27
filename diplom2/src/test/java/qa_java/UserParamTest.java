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

import static org.apache.http.HttpStatus.SC_FORBIDDEN;

@RunWith(Parameterized.class)
public class UserParamTest extends BaseTest {


    public static final String EMAIL_PASSWORD_AND_NAME_ARE_REQUIRED_FIELDS = "Email, password and name are required fields";
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
                {UserGenerator.getWithoutLoginField(), EMAIL_PASSWORD_AND_NAME_ARE_REQUIRED_FIELDS, SC_FORBIDDEN},
                {UserGenerator.getWithoutPassField(), EMAIL_PASSWORD_AND_NAME_ARE_REQUIRED_FIELDS, SC_FORBIDDEN},
                {UserGenerator.getWithoutNameField(), EMAIL_PASSWORD_AND_NAME_ARE_REQUIRED_FIELDS, SC_FORBIDDEN},
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