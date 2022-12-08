package qa_java;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
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

    @Parameterized.Parameters(name = "Заказ {0} Код {2}")
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
    @DisplayName("Создание заказа")
    @Description("Создаем заказы с неверным id ингредиента, с пустым id")
    public void createOrderTest() {
        ValidatableResponse responseCreate = orderClient.createOrder(order);
        responseCreate.log().all();

        actualMessage = messageExtract(responseCreate);
        statusCodeActual = getStatusCodeActual(responseCreate);

        Assert.assertEquals("Сообщение не верное", message, actualMessage);
        Assert.assertEquals("Статус код неверный", statusCode, statusCodeActual);

    }


}
