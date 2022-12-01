package Tests;

import Pages.MainPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Раздел «Конструктор»
 */
public class ConstructorTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void openPage() {
        this.mainPage = open(getBaseUrl(), MainPage.class);
    }

    /**
     * работают переходы к разделам: «Булки»
     */
    @Test
    public void clickOnBunTest() {

        mainPage.clickFillersButton();
        mainPage.clickBunButton();

        assertThat("Вкладка не открылась", mainPage.getBunHeader(),
                containsString("Булки"));

    }

    /**
     * работают переходы к разделам: «Соусы»
     */
    @Test
    public void clickOnSauceTest() {

        mainPage.clickSauceButton();

        assertThat("Вкладка не открылась", mainPage.getSauceHeader(),
                containsString("Соусы"));

    }


    /**
     * работают переходы к разделам: «Начинки»
     */
    @Test
    public void clickOnFillersTest() {

        mainPage.clickFillersButton();

        assertThat("Вкладка не открылась", mainPage.getFillersHeader(),
                containsString("Начинки"));

    }
}
