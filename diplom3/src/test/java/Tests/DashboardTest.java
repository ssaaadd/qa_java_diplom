package Tests;

import Pages.DashboardPage;
import Pages.MainPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class DashboardTest extends BaseTest {

    private MainPage mainPage;


    @Before
    public void pageSetUp() {
        this.mainPage = open(getBaseUrl(), MainPage.class);
    }


    /**
     * переход в Личный кабинет
     * по клику на «Личный кабинет»
     */
    @Test
    public void dashboardClickTest() {

        DashboardPage dashboardPage = mainPage.clickSignInHeader();
        dashboardPage.getUser();

        assertThat("Переход не выполнен", dashboardPage.getUser(),
                containsString("Вход"));

    }

    /**
     * Переход из личного кабинета в конструктор
     * по клику на «Конструктор»
     */
    @Test
    public void constructorClickTest() {
        DashboardPage dashboardPage = mainPage.clickSignInHeader();

        MainPage mainPage = dashboardPage.clickConstructorButton();

        assertThat("Переход не выполнен", mainPage.getConstructYourBurgerHeader(),
                containsString("Соберите бургер"));

    }

    /**
     * Переход из личного кабинета в конструктор
     * по клику на логотип Stellar Burgers
     */
    @Test
    public void logoClickTest() {
        DashboardPage dashboardPage = mainPage.clickSignInHeader();
        MainPage mainPage = dashboardPage.clickHeaderLogo();


        assertThat("Переход не выполнен", mainPage.getConstructYourBurgerHeader(),
                containsString("Соберите бургер"));

    }
}
