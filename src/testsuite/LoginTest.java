package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void teardown() {
        closeBrowser();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //finding sing in button element
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        //finding wecome message element
        String result = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        //expected message
        String expectedMessage = "Welcome Back!";
        // //validate actual and expected message
        Assert.assertEquals("Welcome Message", result, expectedMessage);

    }

    @Test
    public void verifyTheErrorMessage() {
        //finding sing in link element
        clickOnElement(By.linkText("Sign In"));
        //finding username element
        sendTextToElement(By.name("user[email]"), "123456@gmail.com");
        //finding password
        sendTextToElement(By.id("user[password]"), "abcdefg");
        //finding login button element
        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        //finding actualmessage element
        String actualResult = getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        //expected message
        String expectedMessage = "Invalid email or password.";
        //validate actual and expected message
        Assert.assertEquals("Unable to log in", actualResult, expectedMessage);
    }
}

