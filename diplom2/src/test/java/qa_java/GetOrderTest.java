package qa_java;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import qa_java.client.Client;
import qa_java.client.OrderClient;
import qa_java.client.UserClient;
import qa_java.generators.UserGenerator;
import qa_java.model.User;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

public class GetOrderTest extends BaseTest {


    private OrderClient orderClient;
    private UserClient userClient;
    private User userDefault;
    private String accessToken;


    private Object message;


    @Before
    @Step("Создаем шаблоны пользователей")
    public void setUp() {
        orderClient = new OrderClient();
        userClient = new UserClient();
        userDefault = UserGenerator.getDefault();
    }

    @After
    @Step("Удаление пользователя")
    public void cleanUp() {
        accessToken = Client.getAccessToken();
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Получение списка заказов С авторизацией")
    @Description("Проверка orders после авторизации")
    public void getOrderList_Auth_Ok() {
        ValidatableResponse responseCreate = orderClient.getOrderListAuth();
        responseCreate.log().all();
        message = responseCreate.extract().path("orders");
        statusCodeActual = getStatusCodeActual(responseCreate);

        Assert.assertNotNull("Список заказов пуст", message);
        Assert.assertEquals("Статус код не тот", SC_OK, statusCodeActual);

    }

    @Test
    @DisplayName("Получение списка заказов БЕЗ авторизации")
    @Description("Проверка orders без авторизации")
    public void getOrderList_NoAuth_Forbidden() {
        ValidatableResponse responseCreate = orderClient.getOrderList();
        responseCreate.log().all();
        message = responseCreate.extract().path("message");
        statusCodeActual = getStatusCodeActual(responseCreate);
        String actualMessage = "You should be authorised";

        Assert.assertEquals("Список заказов не должен быть доступен",
                actualMessage, message);
        Assert.assertEquals("Статус код не тот", SC_UNAUTHORIZED, statusCodeActual);

    }


}
