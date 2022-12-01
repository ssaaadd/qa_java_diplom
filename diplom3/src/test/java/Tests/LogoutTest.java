package Tests;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.MainPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Выход из аккаунта
 */
public class LogoutTest extends BaseTest {


    private MainPage mainPage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    /**
     * выполняем логин
     */
    @Before
    public void logInSetUp() {
        LoginPage loginPage = open(getLoginUrl(), LoginPage.class);
        loginPage.login(LOGIN_MAIN,
                PASSWORD_MAIN);
        this.dashboardPage = loginPage.dashboardButtonClick();
    }


    /**
     * выход по кнопке «Выйти» в личном кабинете
     */
    @Test
    public void logOutButtonInDashboardTest() {
        LoginPage loginPage = dashboardPage.logOut();

        assertThat("Выход не выполнен", loginPage.getLoginHeader(),
                containsString("Вход"));
    }


}