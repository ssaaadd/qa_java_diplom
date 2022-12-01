package Tests;

import Pages.MainPage;
import Pages.RegistrationPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Регистрация
 */
public class RegisterTest extends BaseTest {


    private RegistrationPage regPage;

    /**
     * переход на страницу регистрации
     */
    @Before
    public void registrationPageOpen() {
        this.regPage = open(getRegistrationUrl(), RegistrationPage.class);
    }

    /**
     * Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
     */
    @Test
    public void registrationNonValidPasswordTest() {

        regPage.register(NAME_MAIN, LOGIN_MAIN.substring(1),
                PASSWORD_MAIN.substring(4));
        assertThat("Регистрация не возможна", regPage.getWrongPasswordMessage(),
                containsString("Некорректный пароль"));

    }


    /**
     * Успешную регистрацию.
     */
    @Test
    public void registrationSuccessfulTest() {

        regPage.register(NAME_MAIN, getRandomEmailNumber() + LOGIN_MAIN,
                PASSWORD_MAIN);
        assertThat("Регистрация должна быть успешна", regPage.getLoginInHeader(),
                containsString("Вход"));

    }


}