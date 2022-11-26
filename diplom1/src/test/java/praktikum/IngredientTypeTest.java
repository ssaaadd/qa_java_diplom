package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String ingredientTypeValue;

    public IngredientTypeTest(String ingredientTypeValue) {
        this.ingredientTypeValue = ingredientTypeValue;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void valueOfNotNullTest() {
        Assert.assertNotNull("Элемент не задан", IngredientType.valueOf(ingredientTypeValue));
    }

}