package Tests;

import Pages.MainPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class LogoutTest extends BaseTest {


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
    public void logOutButtonInDashboard() {


        mainPage.logOut();


        assertThat("Выход не выполнен", mainPage.getLoginHeader(),
                containsString("Вход"));

    }


}