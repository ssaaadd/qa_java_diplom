package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {


    // Локатор Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Войти в аккаунт']/parent::*")
    private SelenideElement signInBody;
    // Локатор Личный кабинет
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Личный Кабинет']/parent::*")
    private SelenideElement signInHeader;


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
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Личный Кабинет']/parent::*")
    private SelenideElement dashboardButton;





    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Соберите бургер']/parent::*")
    private SelenideElement constructYourBurgerHeader;

    public String getConstructYourBurgerHeader() {
        return constructYourBurgerHeader.getText();
    }



    //метод клика по ссылке авторизации
    public LoginPage clickSignInBody() {
        signInBody.click();
        return page(LoginPage.class);
    }

    //метод клика по кнопке Личный кабинет
    public DashboardPage clickSignInHeader() {
        signInHeader.click();
        return page(DashboardPage.class);
    }

    public LoginPage clickSignInHeaderLogin() {
        signInHeader.click();
        return page(LoginPage.class);
    }




    public DashboardPage dashboardButtonClick() {
        dashboardButton.click();
        return page(DashboardPage.class);
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


    public String getBunHeader() {
        return bunHeader.getText();
    }

    public String getFillersHeader() {
        return fillersHeader.getText();
    }

    public String getSauceHeader() {
        return sauceHeader.getText();
    }


}
