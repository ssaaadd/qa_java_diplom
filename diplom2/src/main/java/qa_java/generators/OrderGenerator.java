package qa_java.generators;

import qa_java.model.Order;

public class OrderGenerator {


    public static Order getDefault() {
        return new Order(new String[]{"61c0c5a71d1f82001bdaaa6d", "61c0c5a71d1f82001bdaaa6f"});
    }

    public static Object getNonValidIdIngredient() {
        return new Order(new String[]{"51c0c5a71d1f82001bdaaa6d"});
    }

    public static Order getNullIngredient() {
        return new Order(new String[]{});
    }
}
