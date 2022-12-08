package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;


/**
 * Раздел «Конструктор»
 */
public class ConstructorTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void openPage() {
        this.mainPage = open(getBaseUrl(), MainPage.class);
    }

    @Test
    @DisplayName("Переход к разделу Булки после клика на Булки, предварительно клик на Другую вкладку")
    @Description("Клик на вкладке Булки, проверка Заголовок видим = прокрутка успешна")
    public void clickOnBunTest() {

        mainPage.clickFillersButton();
        mainPage.clickBunButton();

        Assert.assertTrue("Вкладка не открылась", mainPage.getBunHeader());
    }

    @Test
    @DisplayName("Переход к разделу Соусы после клика на Соусы")
    @Description("Клик на вкладке Соусы, проверка Заголовок видим = прокрутка успешна")
    public void clickOnSauceTest() {

        mainPage.clickSauceButton();

        Assert.assertTrue("Вкладка не открылась", mainPage.getSauceHeader());

    }


    @Test
    @DisplayName("Переход к разделу Начинки после клика на Начинки")
    @Description("Клик на вкладке Начинки, проверка Заголовок видим = прокрутка успешна")
    public void clickOnFillersTest() {

        mainPage.clickFillersButton();

        Assert.assertTrue("Вкладка не открылась", mainPage.getFillersHeader());


    }
}
