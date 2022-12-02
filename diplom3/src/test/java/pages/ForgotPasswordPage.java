package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement signInRegisterPage;


    //метод клика по ссылке авторизации
    public LoginPage clickSignInForgotPasswordPage() {
        signInRegisterPage.click();
        return page(LoginPage.class);
    }


}
