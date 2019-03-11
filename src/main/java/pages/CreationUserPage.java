package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreationUserPage {

    public CreationUserPage fillContactInfoForm(String firstName, String lastName, String email, String password){
        $(By.xpath(".//*[@data-filter-key = 'fNameText']//input")).val(firstName);
        $(By.xpath(".//*[@data-filter-key = 'lNameText']//input")).val(lastName);
        $(By.xpath(".//*[@data-filter-key = 'email']//input")).val(email);
        $(By.xpath(".//*[@data-filter-key = 'password']//input")).val(password);
        return this;
    }

    public CreationUserPage selectCountryMexico() {
        $(By.xpath(".//*[@data-filter-key ='countryId']//*[@placeholder='Nothing selected']")).click();
        $(By.xpath(".//*[@data-filter-key='countryId']//*[contains(text(),'Mexico')]")).click();
        return this;
    }

    public CreationUserPage selectRoleAutomationTesting() {
        $(By.xpath(".//*[@data-filter-key ='roleId']//*[@placeholder='Nothing selected']")).click();
        $(By.xpath(".//*[@data-filter-key='roleId']//*[contains(text(),'Automation testing')]")).click();
        return this;
    }

    public CreationUserPage selectStoreClusterMexico() {
        $(By.xpath(".//*[@data-filter-key ='storeClusterId']//*[@placeholder='Nothing selected']")).click();
        $(By.xpath(".//*[@data-filter-key='storeClusterId']//*[contains(text(),'Mexico')]")).click();
        return this;
    }

    public void selectStoreAngelopolis() {
        $(By.xpath(".//*[@data-filter-key ='storeId']//*[@placeholder='Nothing selected']")).click();
        $(By.xpath(".//*[@data-filter-key='storeId']//*[contains(text(),'Angelopolis')]")).click();
    }

    public void confirmCreationUser() {
        $(By.xpath(".//*[@mx-ui-save-button]")).click();
        $(By.xpath(".//*[contains(text(),'Success')]")).waitUntil(Condition.visible, 10000);
    }

    public String getUsersName() {
       String firstName =  $(By.xpath(".//*[@data-filter-key='fNameText']//input")).getValue();
       String lastName = $(By.xpath(".//*[@data-filter-key='lNameText']//input")).getValue();
       return firstName + " " + lastName;
    }

    public String getUsersEmail() {
        return $(By.xpath(".//*[@data-filter-key='email']//input")).getValue();
    }

    public String getUsersStores() {
        return $(By.xpath(".//*[@data-filter-key ='storeId']//*[@placeholder]")).getText();
    }

    public String getUsersStoreCluster() {
        return $(By.xpath(".//*[@data-filter-key ='storeClusterId']//*[@placeholder]")).getText();
    }

    public String getUsersCountry() {
        return $(By.xpath(".//*[@data-filter-key ='countryId']//*[@placeholder]")).getText();
    }
}
