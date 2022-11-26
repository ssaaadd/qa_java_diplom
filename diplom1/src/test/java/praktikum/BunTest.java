package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {

    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("name", 100);
    }


    @Test
    public void getPriceTest() {
        Assert.assertEquals("Цена не верная", 100, bun.getPrice(), 0.1);

    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Название не верное", "name", bun.getName());

    }


}