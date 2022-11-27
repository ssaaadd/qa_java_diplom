package qa_java;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import qa_java.client.OrderClient;
import qa_java.generators.OrderGenerator;
import qa_java.model.Order;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;

@RunWith(Parameterized.class)
public class OrderParamTest extends BaseTest {

    private final Order order;
    private OrderClient orderClient;


    public OrderParamTest(Order order, String message, int statusCode) {
        this.order = order;
        this.message = message;
        this.statusCode = statusCode;
    }

    // test data
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {OrderGenerator.getNonValidIdIngredient(), "One or more ids provided are incorrect", SC_BAD_REQUEST},
                {OrderGenerator.getNullIngredient(), "Ingredient ids must be provided", SC_BAD_REQUEST},
        };
    }

    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }


    @Test
    public void createOrderTest() {
        ValidatableResponse responseCreate = orderClient.createOrder(order);
        responseCreate.log().all();

        actualMessage = messageExtract(responseCreate);
        statusCodeActual = getStatusCodeActual(responseCreate);

        Assert.assertEquals("Сообщение не верное", message, actualMessage);
        Assert.assertEquals("Статус код неверный", statusCode, statusCodeActual);

    }


}
