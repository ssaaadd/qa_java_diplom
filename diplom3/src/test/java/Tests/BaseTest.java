package Tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

import java.sql.Timestamp;

public class BaseTest {


    protected static final String LOGIN_MAIN = "login090909090909@ya.ru";
    protected static final String PASSWORD_MAIN = "password";
    protected static final String NAME_MAIN = "name";


    private final String baseUrl = "https://stellarburgers.nomoreparties.site";
    private final String registrationUrl = baseUrl + "/register";
    private final String forgotPasswordUrl = baseUrl + "/forgot-password";
    private final String loginUrl = baseUrl + "/login";

    @Before
    public void startUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = baseUrl;
        Configuration.headless = true;
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

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getRegistrationUrl() {
        return registrationUrl;
    }

    public String getForgotPasswordUrl() {
        return forgotPasswordUrl;
    }


    public long getRandomEmailNumber() {
        return new Timestamp(System.currentTimeMillis()).getTime();
    }


}
