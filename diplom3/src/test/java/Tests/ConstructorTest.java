package Tests;

import Pages.MainPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class ConstructorTest extends BaseTest {

    @Test
    public void clickOnBun() {
        MainPage mainPage = open(getBaseUrl(), MainPage.class);


        mainPage.clickFillersButton();
        mainPage.clickBunButton();


        assertThat("Вкладка не открылась", mainPage.getBunHeader(),
                containsString("Булки"));

    }


    @Test
    public void clickOnSauce() {
        MainPage mainPage = open(getBaseUrl(), MainPage.class);


        mainPage.clickSauceButton();


        assertThat("Вкладка не открылась", mainPage.getSauceHeader(),
                containsString("Соусы"));

    }


    @Test
    public void clickOnFillers() {
        MainPage mainPage = open(getBaseUrl(), MainPage.class);


        mainPage.clickFillersButton();


        assertThat("Вкладка не открылась", mainPage.getFillersHeader(),
                containsString("Начинки"));

    }
}
