package qa_java;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import qa_java.client.OrderClient;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

public class GetOrderTest extends BaseTest {


    private OrderClient orderClient;
    private Object message;


    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }

    @Test
    public void getOrderList_Auth_Ok() {
        ValidatableResponse responseCreate = orderClient.getOrderListAuth();
        responseCreate.log().all();
        message = responseCreate.extract().path("orders");
        statusCodeActual = getStatusCodeActual(responseCreate);

        Assert.assertNotNull("Список заказов пуст", message);
        Assert.assertEquals("Статус код не тот", SC_OK, statusCodeActual);

    }

    @Test
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
