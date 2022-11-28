package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends Main {
    //локатор поля ввода email
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement emailField;
    //локатор поля ввода пароля
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;
    //локатор кнопки входа в приложение
    @FindBy(how = How.XPATH, using = "//div[@id='root']/div/main/div/form/button")
    private SelenideElement signInButton;
    //локатор Орормить заказ
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Оформить заказ']/parent::*")
    private SelenideElement makeOrderButton;
    // Локатор Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Войти в аккаунт']/parent::*")
    private SelenideElement signInBody;
    // Локатор Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Личный Кабинет']/parent::*")
    private SelenideElement signInHeader;
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement signInRegisterPage;
    // Локатор Булки
    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Булки'])/parent::*")
    private SelenideElement bunButton;
    // Локатор Соусы
    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Булки'])[1]/following::div[1]")
    private SelenideElement sauceButton;
    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Булки'])[1]/following::div[2]")
    private SelenideElement fillersButton;

    @FindBy(how = How.XPATH, using = "(.//h2[normalize-space(text()) and normalize-space(.)='Начинки'])[1]")
    private SelenideElement fillersHeader;

    @FindBy(how = How.XPATH, using = "(.//h2[normalize-space(text()) and normalize-space(.)='Булки'])[1]")
    private SelenideElement bunHeader;

    @FindBy(how = How.XPATH, using = "(.//h2[normalize-space(text()) and normalize-space(.)='Соусы'])[1]")
    private SelenideElement sauceHeader;

    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Профиль']/parent::*")
    private SelenideElement userHeader;




    //метод клика по ссылке авторизации
    public void clickSignInBody() {
        signInBody.click();
    }

    //метод клика по ссылке авторизации
    public void clickSignInHeader() {
        signInHeader.click();
    }


    //метод клика по ссылке авторизации
    public void clickSignInRegPage() {
        signInRegisterPage.click();
    }

    //метод заполнения поля ввода email
    public void setUsername(String username) {
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
    public String getElementText() {
        return makeOrderButton.getText();
    }


    public void clickBunButton() {
        bunButton.click();

    }

    public void clickSauceButton() {
        sauceButton.click();

    }

    public void clickFillersButton() {
        fillersButton.click();
    }

    public void scrollToElement() {
        fillersHeader.scrollTo();
    }

    //метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }

    public String getBunHeader() {
        return bunHeader.getText();
    }

    public String getFillersHeader() {
        return fillersHeader.getText();
    }

    public String getSauceHeader() {
        return sauceHeader.getText();
    }

    public String getUser() {
        return userHeader.getText();
    }


}
