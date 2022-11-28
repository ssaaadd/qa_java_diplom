package Tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    protected static WebDriver driver;

    private final String baseUrl = "https://stellarburgers.nomoreparties.site";
    private final String registrationUrl = baseUrl + "/register";
    private final String forgotPasswordUrl = baseUrl + "/forgot-password";


    @Before
    public void startUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = baseUrl;

    }

    @After
    public void tearDown() {
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }


    public String getBaseUrl() {
        return baseUrl;
    }


    public String getRegistrationUrl() {
        return registrationUrl;
    }

    public String getForgotPasswordUrl() {
        return forgotPasswordUrl;
    }
}
