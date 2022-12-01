package Tests;

import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegistrationPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Вход
 */
public class LoginTest extends BaseTest {


    /**
     * вход по кнопке «Войти в аккаунт» на главной
     */
    @Test
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

    /**
     * вход через кнопку «Личный кабинет»
     */
    @Test
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


    /**
     * вход через кнопку в форме регистрации
     */
    @Test
    public void loginInRegisterPageTest() {
        RegistrationPage registrationPage = open(getRegistrationUrl(),
                RegistrationPage.class);

        // переход по ссылке
        LoginPage loginPage = registrationPage.clickSignInRegPage();
        //вход в приложение
        loginPage.login(LOGIN_MAIN,
                PASSWORD_MAIN);
        assertThat("Вход не выполнен", loginPage.getMakeOrderText(),
                containsString("Оформить заказ"));

    }

    /**
     * вход через кнопку в форме восстановления пароля
     */
    @Test
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