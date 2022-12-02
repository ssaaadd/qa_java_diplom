package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class DashboardPage {

    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Вход']/parent::*")
    private SelenideElement dashboardHeader;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Выход']/parent::*")
    private SelenideElement logoutButton;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Конструктор']/parent::*")
    private SelenideElement constructorButton;
    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'AppHeader_header__logo')]")
    private SelenideElement headerLogo;

    public String getUser() {
        return dashboardHeader.getText();
    }

    //метод клика по кнопке Конструктор
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }

    public MainPage clickHeaderLogo() {
        headerLogo.click();
        return page(MainPage.class);
    }

    public void logOutButtonClick() {
        logoutButton.click();
    }

    public LoginPage logOut() {
        logOutButtonClick();
        return page(LoginPage.class);
    }


}
