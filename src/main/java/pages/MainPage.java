package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public MainPage goToAdministrationPage() {
        $(By.xpath(".//*[@class='navigation-label first-capital'][contains(text(), 'Administration')]")).click();
        return this;
    }

    public void initUserCreation() {
        $(By.xpath("//*[contains(text(),'Add')]")).click();
    }


    public MainPage openAutomationTestingUsersList() {
        $(By.xpath(".//*[@class='expander']//*[contains(text(),'Automation testing')]")).click();
        return this;
    }

    public MainPage deleteUserAfterCreation() {
        $(By.xpath(".//*[contains(text(),'" + getUsersNameAfterCreation() + "')]")).click();
        $(By.xpath(".//*[contains(text(),'Success')]")).waitUntil(Condition.disappear, 10000);
        $(By.xpath(".//*[contains(text(),'Delete')]")).click();
        $(By.xpath(".//*[contains(text(),'OK')]")).click();
        $(By.xpath(".//*[contains(text(),'Success')]")).waitUntil(Condition.visible, 10000);
        return this;
    }

    public void checkUserIsNotDisplayed() {
        $(By.xpath(s + "//td[2]//span")).shouldNotBe(Condition.visible);
    }

    private String s = ".//*[contains(text(),'Automation40 Testing')]//..//..//..//..";

    public String getUsersNameAfterCreation() {
        return $(By.xpath(s + "//td[1]//a//span")).getText();
    }

    public String getUsersEmailAfterCreation() {
        return $(By.xpath(s + "//td[2]//span")).getText();
    }

    public String getUsersStoresAfterCreation() {
        return $(By.xpath(s + "//td[3]//span")).getText();
    }

    public String getUsersStoreClusterAfterCreation() {
        return $(By.xpath(s + "//td[4]//span")).getText();
    }

    public String getUsersCountryAfterCreation() {
        return $(By.xpath(s + "//td[5]//span")).getText();
    }

}

