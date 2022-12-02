package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Регистрация
 */
public class RegisterTest extends BaseTest {


    private RegistrationPage regPage;


    @Before
    @Step("Переход на страницу Регистрации")
    public void registrationPageOpen() {
        this.regPage = open(getRegistrationUrl(), RegistrationPage.class);
    }


    @Test
    @DisplayName("Вход с паролем менее 6 символов")
    @Description("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    public void registrationNonValidPasswordTest() {

        regPage.register(NAME_MAIN, LOGIN_MAIN.substring(1),
                PASSWORD_MAIN.substring(4));
        assertThat("Регистрация не возможна", regPage.getWrongPasswordMessage(),
                containsString("Некорректный пароль"));

    }


    @Test
    @DisplayName("Успешная регистрация")
    @Description("Переход на страницу Регистрации, запленение полей, регистрация")
    public void registrationSuccessfulTest() {

        regPage.register(NAME_MAIN, getRandomEmailNumber() + LOGIN_MAIN,
                PASSWORD_MAIN);
        assertThat("Регистрация должна быть успешна", regPage.getLoginInHeader(),
                containsString("Вход"));

    }


}