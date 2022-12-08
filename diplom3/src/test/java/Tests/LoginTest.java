package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Вход
 */
public class LoginTest extends BaseTest {


    @Test
    @DisplayName("Вход через кнопку на Главной")
    @Description("Переход на Главную страницу, клик по кнопке Войти")
    public void loginInBodyTest() {
        MainPage mainPage = open(getBaseUrl(), MainPage.class);

        // переход по ссылке
        LoginPage loginPage = mainPage.clickSignInBody();
        //вход в приложение
        loginPage.login(LOGIN_MAIN,
                PASSWORD_MAIN);
        assertThat("Вход не выполнен", loginPage.getMakeOrderText(),
                containsString("Оформить заказ"));

    }


    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Переход на страницу Личный кабинет, клик по кнопке Войти")
    public void loginInHeaderTest() {
        MainPage mainPage = open(getBaseUrl(), MainPage.class);

        // переход по ссылке
        LoginPage loginPage = mainPage.clickSignInHeaderLogin();
        //вход в приложение
        loginPage.login(LOGIN_MAIN,
                PASSWORD_MAIN);
        assertThat("Вход не выполнен", loginPage.getMakeOrderText(),
                containsString("Оформить заказ"));

    }


    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Переход на страницу Регистрации, клик по кнопке Войти")
    public void loginInRegisterPageTest() {
        RegistrationPage registrationPage = open(getRegistrationUrl(),
                RegistrationPage.class);

        LoginPage loginPage = registrationPage.clickSignInRegPage();

        loginPage.login(LOGIN_MAIN,
                PASSWORD_MAIN);
        assertThat("Вход не выполнен", loginPage.getMakeOrderText(),
                containsString("Оформить заказ"));

    }


    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Переход на страницу Забыл пароль, клик по кнопке Войти")
    public void loginInForgotPasswordPageTest() {
        ForgotPasswordPage forgotPasswordPage = open(getForgotPasswordUrl(),
                ForgotPasswordPage.class);

        // переход по ссылке
        LoginPage loginPage = forgotPasswordPage.clickSignInForgotPasswordPage();
        //вход в приложение
        loginPage.login(LOGIN_MAIN,
                PASSWORD_MAIN);
        assertThat("Вход не выполнен", loginPage.getMakeOrderText(),
                containsString("Оформить заказ"));

    }
}