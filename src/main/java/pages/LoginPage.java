package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public LoginPage openMercauxHomePage() {
        open("http://dev.mercaux.com");
        return this;
    }

    public void loginBy(String user, String password) {
        $(By.name("mxEmail")).val(user);
        $(By.name("password")).val(password);
        $(By.cssSelector("button")).click();
    }
}
