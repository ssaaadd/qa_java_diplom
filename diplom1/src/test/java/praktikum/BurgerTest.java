package praktikum;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient sauce;


    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.addIngredient(cheese);
        burger.addIngredient(sauce);


        Mockito.when(bun.getPrice()).thenReturn(150.0F);
        Mockito.when(cheese.getPrice()).thenReturn(200.0F);
        Mockito.when(sauce.getPrice()).thenReturn(300.0F);


        Mockito.when(bun.getName()).thenReturn("булка");
        Mockito.when(cheese.getName()).thenReturn("сыр");
        Mockito.when(sauce.getName()).thenReturn("соус");


        Mockito.when(cheese.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(sauce.getType()).thenReturn(IngredientType.FILLING);

    }

    @After
    public void tearDown() {
        burger.bun = null;
        burger.ingredients.clear();
    }

    @Test
    public void setBunsNotNull() {
        burger.setBuns(bun);
        Assert.assertNotNull("Булка не добавилась", burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(sauce);
        Assert.assertEquals("Ингредиент не добавился", 3, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        Assert.assertEquals("Ингредиент не удалился", 1, burger.ingredients.size());
        Assert.assertFalse("Ингредиент [0] все еще в списке", burger.ingredients.contains(cheese));
    }

    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингредиент не переместился",
                1, burger.ingredients.indexOf(cheese));
    }

    @Test
    public void getPriceTest() {
        float ingredientsSum = bun.getPrice() * 2 + cheese.getPrice() + sauce.getPrice();
        burger.setBuns(bun);
        Assert.assertEquals("Цена неверная", ingredientsSum, burger.getPrice(), 0.1);
    }

    @Test
    public void getReceiptTest() {
        String expectedReceipt = "(==== булка ====)\r\n" +
                "= filling сыр =\r\n" +
                "= filling соус =\r\n" +
                "(==== булка ====)\r\n" +
                "\r\n" +
                "Price: 800,000000\r\n";

        burger.setBuns(bun);
        Assert.assertEquals("Рецепт не верный", expectedReceipt, burger.getReceipt());
    }
}