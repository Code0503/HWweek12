package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import units.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    public void selectMyAccountOptions(String option) {
        /*This method should click on the options whatever name is passed as parameter.
(Hint: Handle List of Element and Select options)*/

        List<WebElement> listOfNames = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"));
        try {
            for (WebElement element : listOfNames) {
                if (element.getText().equalsIgnoreCase(option)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {//div[@id='account-register']//form/child::*
            listOfNames = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"));
        }
    }
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions("Register");
        verifyText("Verify Text", "Register Account", By.xpath("//div[@id='content']/h1"));
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Click on My Account Link. //call login using "select myMethodOption // verify the text
        clickOnElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
        selectMyAccountOptions("Login");
        verifyText("verify Text","Returning Customer",By.xpath("//div[@id='content']/div/div[2]//h2"));
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        clickOnElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")); //3.1 Clickr on My Account Link.
        selectMyAccountOptions("Register"); //“selectMyAccountOptions” method and pass the parameter 'Register'
      WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
      firstname.sendKeys("Java");
      WebElement lastName = driver.findElement(By.name("lastname"));
      lastName.sendKeys("Buster");
      WebElement email = driver.findElement(By.name("email"));
      email.sendKeys("java@DusBus.com");
      WebElement telephoneNo= driver.findElement(By.name("telephone"));
      telephoneNo.sendKeys("07454814115");
      WebElement password = driver.findElement(By.name("password"));
      password.sendKeys("J123456");
      WebElement confirmPass = driver.findElement(By.name("confirm"));
      confirmPass.sendKeys("J123456");
      clickOnElement(By.xpath("//div[@class='form-group']/div/label/input")); //3.9 Select Subscribe Yes radio button
      clickOnElement(By.xpath("//div[@class='pull-right']/input")); //3.10 Click on Privacy Policy check box
      clickOnElement(By.xpath("//div[@class='pull-right']/input[2]")); //3.11 Click on Continue button
      verifyText("verify message","Your Account Has Been Created!",By.xpath("//div[@id='content']/h1"));
        clickOnElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")); //3.14 Clickr on My Account Link.
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions("Logout");
        verifyText("verify Text","Account Logout",By.xpath("//div[@id='content']/h1")); //Verify the text “Account Logout”
        clickOnElement(By.xpath("//div[@class='pull-right']")); //3.17 Click on Continue button
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        clickOnElement(By.xpath("//div[@id=\"top-links\"]/ul/li[2]/a/span[1]")); //4.1 Clickr on My Account Link.
        //“selectMyAccountOptions” method and pass the parameter "login"
        selectMyAccountOptions("Login");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("java@DusBus.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("J123456");
        clickOnElement(By.xpath("//input[@value='Login']")); //4.6 Click on Login button
        verifyText("verify Text","My Account",By.xpath("//div[@id='account-account']/div/div/h2"));
        clickOnElement(By.xpath("//div[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
        selectMyAccountOptions("Logout");
        verifyText("verify Text","Account Logout",By.xpath("//div[@id='content']/h1"));
        clickOnElement(By.xpath("//div[@class='pull-right']")); //4.11 Click on Continue button


    }
  @After
 public void tearDown(){closeBrowser();}
}
