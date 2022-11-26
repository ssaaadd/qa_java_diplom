package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(SAUCE, "name", 100);
    }


    @Test
    public void getPriceTest() {
        Assert.assertEquals("Цена не верная", 100, ingredient.getPrice(), 0.1);

    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Название не верное", "name", ingredient.getName());

    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("Тип не верный", SAUCE, ingredient.getType());

    }


}