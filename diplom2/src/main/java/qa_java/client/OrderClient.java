package qa_java.client;

import io.restassured.response.ValidatableResponse;
import qa_java.model.Order;

import static io.restassured.RestAssured.given;

public class OrderClient extends Client {

    public static final String ORDERS_PATH = "/api/orders";

    public ValidatableResponse getOrderList() {
        return given()
                .spec(getSpec())
                .log().all()
                .when()
                .get(ORDERS_PATH)
                .then();
    }

    public ValidatableResponse getOrderListAuth() {
        return given()
                .spec(getSpecAuth())
                .log().all()
                .when()
                .get(ORDERS_PATH)
                .then();
    }


    public ValidatableResponse createOrder(Order order) {
        return given()
                .spec(getSpec())
                .log().all()
                .body(order)
                .when()
                .post(ORDERS_PATH)
                .then();

    }
    public ValidatableResponse createOrderAuth(Order order) {
        return given()
                .spec(getSpecAuth())
                .log().all()
                .body(order)
                .when()
                .post(ORDERS_PATH)
                .then();

    }
}
