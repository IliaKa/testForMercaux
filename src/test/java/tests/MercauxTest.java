package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CreationUserPage;
import pages.LoginPage;
import pages.MainPage;

public class MercauxTest extends AbstractBrowserTest {

    @Test
    public void testCreatingUser() {
        SoftAssert soft = new SoftAssert();
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        CreationUserPage creationUserPage = new CreationUserPage();

        loginPage.openMercauxHomePage()
                .loginBy("automation@tester.com", "111");

        mainPage.goToAdministrationPage()
                .initUserCreation();

        creationUserPage.fillContactInfoForm("Automation20", "Testing", "automation20@merc-testing.com", "111")
                .selectCountryMexico()
                .selectRoleAutomationTesting()
                .selectStoreClusterMexico()
                .selectStoreAngelopolis();

        String getUsersNameBeforeCreation = creationUserPage.getUsersName();
        String getUsersEmailBeforeCreation = creationUserPage.getUsersEmail();
        String getUsersCountryBeforeCreation = creationUserPage.getUsersCountry();
        String getUsersStoreClusterBeforeCreation = creationUserPage.getUsersStoreCluster();
        String getUsersStoresBeforeCreation = creationUserPage.getUsersStores();

        creationUserPage.confirmCreationUser();
        mainPage.openAutomationTestingUsersList();

        soft.assertEquals(getUsersNameBeforeCreation, mainPage.getUsersNameAfterCreation());
        soft.assertEquals(getUsersEmailBeforeCreation, mainPage.getUsersEmailAfterCreation());
        soft.assertEquals(getUsersStoresBeforeCreation, mainPage.getUsersStoresAfterCreation());
        soft.assertEquals(getUsersStoreClusterBeforeCreation, mainPage.getUsersStoreClusterAfterCreation());
        soft.assertEquals(getUsersCountryBeforeCreation, mainPage.getUsersCountryAfterCreation());


        mainPage.deleteUserAfterCreation()
                .openAutomationTestingUsersList()
                .checkUserIsNotDisplayed();

        soft.assertAll();
    }
}
