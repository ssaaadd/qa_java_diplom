package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Заполнение поля ввода email")
    public void setRegEmail(String username) {
        emailRegField.setValue(username);
    }

    @Step("Заполнение поля ввода email RegistrationPage")
    public void setEmail(String username) {
        emailField.setValue(username);
    }

    @Step("Заполнение поля ввода name")
    public void setName(String name) {
        emailField.setValue(name);
    }

    @Step("Заполнение поля ввода password")
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    @Step("Клик по кнопке авторизации")
    public void clickSignInButton() {
        signInButton.click();
    }

    @Step("Вытаскиваем Текст ошибки")
    public String getWrongPasswordMessage() {
        return wrongPasswordError.getText();
    }

    @Step("Вытаскиваем кнопку Вход")
    public String getLoginInHeader() {
        return loginInHeader.getText();
    }


    @Step("Клик по ссылке авторизации")
    public LoginPage clickSignInRegPage() {
        signInRegisterPage.click();
        return page(LoginPage.class);
    }

    @Step("Регистрация")
    public void register(String name, String email, String password) {
        setName(name);
        setRegEmail(email);
        setPassword(password);
        clickSignInButton();
    }

}
