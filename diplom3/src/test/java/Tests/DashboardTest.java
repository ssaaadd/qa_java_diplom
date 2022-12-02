package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.DashboardPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class DashboardTest extends BaseTest {

    private MainPage mainPage;


    @Before
    public void pageSetUp() {
        this.mainPage = open(getBaseUrl(), MainPage.class);
    }


    @Test
    @DisplayName("Переход в Личный кабинет")
    @Description("По клику на «Личный кабинет»")
    public void dashboardClickTest() {

        DashboardPage dashboardPage = mainPage.clickSignInHeader();
        dashboardPage.getUser();

        assertThat("Переход не выполнен", dashboardPage.getUser(),
                containsString("Вход"));

    }

    @Test
    @DisplayName("Переход в Конструктор")
    @Description("По клику на «Конструктор»")
    public void constructorClickTest() {
        DashboardPage dashboardPage = mainPage.clickSignInHeader();

        MainPage mainPage = dashboardPage.clickConstructorButton();

        assertThat("Переход не выполнен", mainPage.getConstructYourBurgerHeader(),
                containsString("Соберите бургер"));

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("По клику на логотип Stellar Burgers")
    public void logoClickTest() {
        DashboardPage dashboardPage = mainPage.clickSignInHeader();
        MainPage mainPage = dashboardPage.clickHeaderLogo();


        assertThat("Переход не выполнен", mainPage.getConstructYourBurgerHeader(),
                containsString("Соберите бургер"));

    }
}
