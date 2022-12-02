package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MainPage;

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


    @Before
    @Step("Переход на страницу Логин и авторизация")
    public void logInSetUp() {
        LoginPage loginPage = open(getLoginUrl(), LoginPage.class);
        loginPage.login(LOGIN_MAIN,
                PASSWORD_MAIN);
        this.dashboardPage = loginPage.dashboardButtonClick();
    }


    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    @Description("Переход на страницу Личный кабинет, клик по кнопке Выйти")
    public void logOutButtonInDashboardTest() {
        LoginPage loginPage = dashboardPage.logOut();

        assertThat("Выход не выполнен", loginPage.getLoginHeader(),
                containsString("Вход"));
    }


}