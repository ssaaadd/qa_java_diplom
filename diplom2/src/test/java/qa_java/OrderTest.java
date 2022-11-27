package qa_java;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import qa_java.client.OrderClient;
import qa_java.generators.OrderGenerator;
import qa_java.model.Order;

import static org.apache.http.HttpStatus.SC_OK;


public class OrderTest extends BaseTest {
    private OrderClient orderClient;
    private Order order;


    @Before
    public void setUp() {
        orderClient = new OrderClient();
        order = OrderGenerator.getDefault();
    }


    @Test
    public void createOrder_NoAuth_Ok_Test() {
        ValidatableResponse responseCreate = orderClient.createOrder(order);
        responseCreate.log().all();

        trackNumber = trackExtract(responseCreate);
        statusCodeActual = getStatusCodeActual(responseCreate);

        Assert.assertNotNull("Список заказов пуст", trackNumber);
        Assert.assertEquals("Статус код неверный", SC_OK, statusCodeActual);

    }

    @Test
    public void createOrder_Auth_Ok_Test() {
        ValidatableResponse responseCreate = orderClient.createOrderAuth(order);
        responseCreate.log().all();

        trackNumber = trackExtract(responseCreate);
        statusCodeActual = getStatusCodeActual(responseCreate);

        Assert.assertNotNull("Список заказов пуст", trackNumber);
        Assert.assertEquals("Статус код неверный", SC_OK, statusCodeActual);

    }
}
