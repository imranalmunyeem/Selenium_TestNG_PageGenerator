package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test (priority = 0)
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException {
        //*************PAGE METHODS WITH JAVA GENERICS********************
        //Open N11 HomePage
        //Initialize elements by using PageFactory
        page.GetInstance(HomePage.class).goToN11();

        //Chain of Invocation (Go to Login Page and then LoginToN11)
        page.GetInstance(HomePage.class).
                goToLoginPage().loginToN11("celtabroad.com", "12345678");

        //*************ASSERTIONS***********************
        Thread.sleep(500); //It is better to use explicit wait here.
        page.GetInstance(LoginPage.class).verifyLoginPassword(("abc123"));
    }

    @Test (priority = 1)
    public void invalidLoginTest_EmptyUserEmptyPassword () throws InterruptedException {
        //*************PAGE METHODS WITH JAVA GENERICS********************
        //Open N11 HomePage
        page.GetInstance(HomePage.class).goToN11();

        //Method Chaining (Go to Login Page and then LoginToN11)
        page.GetInstance(HomePage.class).goToLoginPage().loginToN11("","");

        //*************ASSERTIONS***********************
        Thread.sleep(500); //It is better to use explicit wait here.
        page.GetInstance(LoginPage.class).verifyLoginUserName("imranalmunyeem");
        page.GetInstance(LoginPage.class).verifyLoginPassword("12345678");
    }

}
