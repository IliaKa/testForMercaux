package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractBrowserTest {


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverRunner.setWebDriver(new ChromeDriver());
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}