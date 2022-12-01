//package Tests;
//
//import Pages.MainPage;
//import Pages.RegistrationPage;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import static com.codeborne.selenide.Selenide.open;
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//@RunWith(Parameterized.class)
//public class RegisterParamTest extends BaseTest {
//
//
//    private final String name;
//    private final String email;
//    private final String password;
//    private final String result;
//    private final String errorMessage;
//
//    public RegisterParamTest(String name, String email, String password, String result, String errorMessage) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.result = result;
//        this.errorMessage = errorMessage;
//    }
//
//    @Parameterized.Parameters
//    public static Object[][] getData() {
//        return new Object[][]{
//                //Успешную регистрацию.
//                {"name", "login090909090909@ya.ru", "123456", "Вход", "Регистрация должна быть успешна"},
//                // Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
//                {"name", "login0909090909099@ya.ru", "12345", "Некорректный пароль", "Регистрация не должна быть успешна"}
//        };
//    }
//
//
//    @Test
//    public void registrationNonValidPassword() {
//        RegistrationPage regPage = open(getRegistrationUrl(), RegistrationPage.class);
//
//        regPage.register(name, email,
//                password);
//        assertThat(errorMessage, regPage.getWrongPasswordMessage(),
//                containsString(result));
//
//    }
//
//
//}