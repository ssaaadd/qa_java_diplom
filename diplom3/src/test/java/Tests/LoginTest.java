package Tests;

import Pages.MainPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class LoginTest extends BaseTest {


    @Test
    public void loginInBody() {
        MainPage mainPagePage = open(getBaseUrl(), MainPage.class);
        // переход по ссылке
        mainPagePage.clickSignInBody();
        //вход в приложение
        mainPagePage.login("login090909090909@ya.ru",
                "password");
        assertThat("Вход не выполнен", mainPagePage.getElementText(),
                containsString("Оформить заказ"));

    }

    @Test
    public void loginInHeader() {
        MainPage mainPagePage = open(getBaseUrl(), MainPage.class);
        // переход по ссылке
        mainPagePage.clickSignInHeader();
        //вход в приложение
        mainPagePage.login("login090909090909@ya.ru",
                "password");
        assertThat("Вход не выполнен", mainPagePage.getElementText(),
                containsString("Оформить заказ"));

    }

    @Test
    public void loginInRegisterPage() {
        MainPage mainPagePage = open(getRegistrationUrl(), MainPage.class);
        // переход по ссылке
        mainPagePage.clickSignInRegPage();
        //вход в приложение
        mainPagePage.login("login090909090909@ya.ru",
                "password");
        assertThat("Вход не выполнен", mainPagePage.getElementText(),
                containsString("Оформить заказ"));

    }

    @Test
    public void loginInForgotPasswordPage() {
        MainPage mainPagePage = open(getForgotPasswordUrl(), MainPage.class);
        // переход по ссылке
        mainPagePage.clickSignInRegPage();
        //вход в приложение
        mainPagePage.login("login090909090909@ya.ru",
                "password");
        assertThat("Вход не выполнен", mainPagePage.getElementText(),
                containsString("Оформить заказ"));

    }
}