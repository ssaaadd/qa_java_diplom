package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    //локатор поля ввода email
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "(//*//input[@name='name'])[2]")
    private SelenideElement emailRegField;

    //локатор поля ввода пароля
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;
    //локатор кнопки входа в приложение
    @FindBy(how = How.XPATH, using = "//div[@id='root']/div/main/div/form/button")
    private SelenideElement signInButton;
    // Локатор Вход после регистрации
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Вход']/parent::*")
    private SelenideElement loginInHeader;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Некорректный пароль']/parent::*")
    private SelenideElement wrongPasswordError;
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement signInRegisterPage;

    public void setRegEmail(String username) {
        emailRegField.setValue(username);
    }

    //метод заполнения поля ввода email
    public void setEmail(String username) {
        emailField.setValue(username);
    }

    public void setName(String name) {
        emailField.setValue(name);
    }

    //метод заполнения поля ввода пароля
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    //метод клика по кнопке авторизации
    public void clickSignInButton() {
        signInButton.click();
    }

    public String getWrongPasswordMessage() {
        return wrongPasswordError.getText();
    }

    public String getLoginInHeader() {
        return loginInHeader.getText();
    }


    //метод клика по ссылке авторизации
    public LoginPage clickSignInRegPage() {
        signInRegisterPage.click();
        return page(LoginPage.class);
    }

    public void register(String name, String email, String password) {
        setName(name);
        setRegEmail(email);
        setPassword(password);
        clickSignInButton();
    }

}
