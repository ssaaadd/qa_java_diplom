package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    //локатор поля ввода email
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement emailField;


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
    //локатор Орормить заказ
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Оформить заказ']/parent::*")
    private SelenideElement makeOrderButton;

    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Личный Кабинет']/parent::*")
    private SelenideElement dashboardButton;
    @FindBy(how = How.XPATH, using = "(.//h2[normalize-space(text()) and normalize-space(.)='Вход'])[1]")
    private SelenideElement loginHeader;

    //метод заполнения поля ввода email
    public void setEmail(String username) {
        emailField.setValue(username);
    }

    //метод заполнения поля ввода пароля
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    //метод клика по кнопке авторизации
    public void clickSignInButton() {
        signInButton.click();
    }

    //метод получить текст
    public String getMakeOrderText() {
        return makeOrderButton.getText();
    }

    //метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void login(String username, String password) {
        setEmail(username);
        setPassword(password);
        clickSignInButton();
    }

    public DashboardPage dashboardButtonClick() {
        dashboardButton.click();
        return page(DashboardPage.class);
    }

    public String getLoginHeader() {
        return loginHeader.getText();
    }
}
