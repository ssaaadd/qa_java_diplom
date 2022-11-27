package qa_java;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import qa_java.client.Client;
import qa_java.client.OrderClient;
import qa_java.client.UserClient;
import qa_java.generators.OrderGenerator;
import qa_java.model.Order;
import qa_java.model.User;

import static org.apache.http.HttpStatus.SC_OK;


public class OrderTest extends BaseTest {
    private OrderClient orderClient;
    private Order order;
    private UserClient userClient;
    private User userDefault;
    private String accessToken;


    @Before
    public void setUp() {
        //        Создаем шаблоны заказов
        orderClient = new OrderClient();
        order = OrderGenerator.getDefault();
        //        Для создания/удаления пользователя
        userClient = new UserClient();
    }

    @After
    public void cleanUp() {
//        Удаляем созданного пользователя
        accessToken = Client.getAccessToken();
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }


    @Test
    public void createOrder_NoAuth_Ok() {
        ValidatableResponse responseCreate = orderClient.createOrder(order);
        responseCreate.log().all();

        trackNumber = trackExtract(responseCreate);
        statusCodeActual = getStatusCodeActual(responseCreate);

        Assert.assertTrue("Список заказов пуст", trackNumber > 0);
        Assert.assertEquals("Статус код неверный", SC_OK, statusCodeActual);

    }

    @Test
    public void createOrder_Auth_Ok() {
        ValidatableResponse responseCreate = orderClient.createOrderAuth(order);
        responseCreate.log().all();

        trackNumber = trackExtract(responseCreate);
        statusCodeActual = getStatusCodeActual(responseCreate);
        Assert.assertTrue("Список заказов пуст", trackNumber > 0);
        Assert.assertEquals("Статус код неверный", SC_OK, statusCodeActual);

    }
}
