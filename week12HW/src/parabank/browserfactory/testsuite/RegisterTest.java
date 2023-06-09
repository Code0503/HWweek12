package parabank.browserfactory.testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import units.Utility;

public class RegisterTest extends Utility { //1.verifyThatSigningUpPageDisplay
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){openBrowser(baseUrl);}  //calling url into browser inherited from baseTest
    @Test
    public void signingUp(){  //click on register link
       clickOnElement(By.xpath("//div[@id='loginPanel']/p[2]/a")); //click on Register link
        //getting text for signup page visible
      String actualText= getTextFromElement(By.xpath("//h1[@class='title']"));
        String expectedText ="Signing up is easy!";
        Assert.assertEquals("verifying text",expectedText,actualText);
    }
    @Test
    public void verifyUserShouldRegisterAccountSuccessfully(){
        clickOnElement(By.xpath("//div[@id='loginPanel']/p[2]/a")); //click on Register link
        sendTextToElment(By.xpath("//input[@name='customer.firstName']"),"Code");//entering first name
        sendTextToElment(By.xpath("//input[@name='customer.lastName']"),"Buster");//entering lastname
        sendTextToElment(By.id("customer.address.street"),"Irthlinborough");// Passing address
        sendTextToElment(By.id("customer.address.city"),"London");// passing city name
        sendTextToElment(By.id("customer.address.state"),"UK");//state or country
        sendTextToElment(By.id("customer.address.zipCode"),"NN10 4PW");// entering postcode
        sendTextToElment(By.id("customer.phoneNumber"),"07454848484");// entering Phone
        sendTextToElment(By.id("customer.ssn"),"BX450 0245 025 B");// entering NI
        sendTextToElment(By.id("customer.username"),"CBuster");//entering username
        sendTextToElment(By.id("customer.password"),"CBuster2023"); //entering password
        sendTextToElment(By.id("repeatedPassword"),"CBuster2023");//confirm password
        clickOnElement(By.xpath("//input[@value='Register']"));// click on register button
    }
    @After
    public void teardown(){closeBrowser();}
}
