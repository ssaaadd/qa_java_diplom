package Tests;

import Pages.MainPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class DashboardTest extends BaseTest {



    @Test
    public void loginInBody() {
        MainPage mainPagePage = open(getBaseUrl(), MainPage.class);
        mainPagePage.clickSignInBody();
        //вход в приложение
        mainPagePage.login("login090909090909@ya.ru",
                "password");

        mainPagePage.clickSignInHeader();

        assertThat("Вход не выполнен", mainPagePage.getUser(),
                containsString("Профиль"));

    }
}
