package Tests;

import Pages.MainPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class RegisterTest extends BaseTest {


    @Test
    public void registrationNonValidPassword() {
        MainPage mainPagePage = open(getRegistrationUrl(), MainPage.class);

        mainPagePage.register("name", "login090909090909@ya.ru",
                "12345");
        assertThat("Регистрация не успешна", mainPagePage.getWrongPasswordTest(),
                containsString("Некорректный пароль"));

    }

    @Test
    public void registrationSuccessful() {
        MainPage mainPagePage = open(getRegistrationUrl(), MainPage.class);

        mainPagePage.register("name", "login090909090909@ya.ru",
                "password");
        assertThat("Регистрация должна быть успешна", mainPagePage.getLoginInHeader(),
                containsString("Вход"));

    }


}