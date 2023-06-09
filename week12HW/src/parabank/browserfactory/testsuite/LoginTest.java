package parabank.browserfactory.testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import units.Utility;

public class LoginTest extends Utility {
String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
@Before
    public void setUp(){openBrowser(baseUrl);} //opening url
    @Test
    public void verifyLoginWithValidCredentials(){
    sendTextToElment(By.xpath("//input[@name='username']"),"Buster");//entering username
        sendTextToElment(By.xpath("//input[@name='password']"),"Buster123");//entering password
        clickOnElement(By.xpath("//input[@value='Log In']"));//click on login button
       String actualText = getTextFromElement(By.xpath("//h1[@class='title']")); //verifying login text
       String expectedText = "Accounts Overview";
        Assert.assertEquals("verifying Text",expectedText,actualText);
        //logout
        clickOnElement(By.xpath("//div[@id='leftPanel']/ul/li[8]"));
    }
    @Test
    public void verifyTheErrorMessage(){
    sendTextToElment(By.xpath("//input[@name='username']"),"CBuster");//passing invalid username
        sendTextToElment(By.xpath("//input[@name='password']"),"CBuster2023");// invalid password
        clickOnElement(By.xpath("//input[@value='Log In']"));// login button
        //verifying error message
        String actualText = getTextFromElement(By.xpath("//div[@id='rightPanel']/p"));
        String expectedText = "The username and password could not be verified.";
        Assert.assertEquals("verifying message",expectedText,actualText);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
    sendTextToElment(By.xpath("//input[@name='username']"),"Buster");//entering valid username
        sendTextToElment(By.xpath("//input[@name='password']"),"Buster123");//entering valid password
        clickOnElement(By.xpath("//input[@value='Log In']"));//clicking on login button
        clickOnElement(By.xpath("//div[@id='leftPanel']/ul/li[8]"));//clicking on logout button
        //verifying message
        String actualText = getTextFromElement(By.xpath("//div[@id='leftPanel']/h2"));
        String expectedText = "Customer Login";
        Assert.assertEquals("verifyin message",actualText,expectedText);
    }
    @After
    public void teardown(){closeBrowser();}
}
