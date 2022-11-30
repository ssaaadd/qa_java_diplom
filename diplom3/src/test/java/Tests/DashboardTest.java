package Tests;

import Pages.MainPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class DashboardTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void logInSetUp() {
        MainPage mainPage = open(getBaseUrl(), MainPage.class);
        mainPage.clickSignInBody();
        mainPage.login("login090909090909@ya.ru",
                "password");
        this.mainPage = mainPage;
    }


    @Test
    public void dashboardClick() {
        // переход в Личный кабинет после логина
        mainPage.clickSignInHeader();

        assertThat("Вход не выполнен", mainPage.getUser(),
                containsString("Профиль"));

    }


    @Test
    public void constructorClick() {
        // переход в Личный кабинет после логина
        mainPage.clickSignInHeader();
        // переход в Конструктор

        mainPage.clickConstructorButton();


        assertThat("Переход не выполнен", mainPage.getConstructYourBurgerHeader(),
                containsString("Соберите бургер"));

    }


    @Test
    public void logoClick() {
        // переход в Личный кабинет после логина
        mainPage.clickSignInHeader();
        // переход в Конструктор

        mainPage.clickHeaderLogo();


        assertThat("Переход не выполнен", mainPage.getConstructYourBurgerHeader(),
                containsString("Соберите бургер"));

    }
}
