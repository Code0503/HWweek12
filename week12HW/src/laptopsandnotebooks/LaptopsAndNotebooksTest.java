package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import units.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";
    @Before
    public void setUp(){openBrowser(baseUrl);}
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //currency change into Pounds sterling
        clickOnElement(By.xpath("//div[@class='pull-left']/form//button"));
        clickOnElement(By.xpath("//div[@class='pull-left']//ul/li[2]"));
        //Mouse hover on Laptops & Notebooks Tab.and click
        mouseHover(By.xpath("//ul[@class='nav navbar-nav']/li[2]"));
        selectMenu("Show AllLaptops & Notebooks");
        selectDropDown(By.id("input-sort"),"Price (Low > High)");
        String actualText = getTextFromElement(By.xpath("//div[@class='form-group input-group input-group-sm']/select/option[4]"));
        String expectedText= "Price (Low > High)";
        Assert.assertEquals("verifying product price arrange as",actualText,expectedText);
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully(){
        //currency change into Pounds sterling
        clickOnElement(By.xpath("//div[@class='pull-left']/form//button"));
        clickOnElement(By.xpath("//div[@class='pull-left']//ul/li[2]"));
        //Mouse hover on Laptops & Notebooks Tab.and click 2.1, 2.2
        mouseHover(By.xpath("//ul[@class='nav navbar-nav']/li[2]"));
        selectMenu("Show AllLaptops & Notebooks");
        //Select Sort By "Price (High > Low)" 2.3
        selectDropDown(By.id("input-sort"),"Price (High > Low)");
        //Select Product “MacBook” 2.4, 2.5
        clickOnElement(By.xpath("//div[@id='content']/div[4]/div[4]//h4/a"));
     verifyText("Verifying Text","MacBook",By.xpath("//*[@id='content']/div/div[2]/h1"));
     //product add to cart  2.6
        clickOnElement(By.id("button-cart"));
        //verify message 2.7
        verifyText("verify proudct have added","Success: You have added MacBook to your shopping cart!\n" + "×",By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        //Click on link “shopping cart” display into success message 2.8, 2.9
        clickOnElement(By.xpath("//ul[@class='list-inline']/li[4]/a"));
        verifyText("verify text","Shopping Cart",By.xpath("//ul[@class='list-inline']/li[4]/a//span"));
        //2.10 Verify the Product name "MacBook"
       verifyText("verify product name in basket","MacBook",By.xpath("//div[@class='table-responsive']//tbody//td[2]/a"));
        //2.11, 2.12, 2.13 Change Quantity "2" and update tab and verify message cart modified
        WebElement updateQty = driver.findElement(By.xpath("//div[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input"));
        updateQty.clear();
        updateQty.sendKeys("2");
        clickOnElement(By.xpath("//div[@class='input-group btn-block']//button"));
        verifyText("verify cart have modified","Success: You have modified your shopping cart!\n" + "×",By.xpath("//div[@id='checkout-cart']/div"));
        //2.14 Verify the Total £737.45
        verifyText("veryify total price is updated","£737.45",By.xpath("//div[@id='content']//tbody/tr/td[6]"));
       // 2.15 Click on “Checkout” button, 2.16 Verify the text “Checkout”, 2.17 verify next customer word
        clickOnElement(By.xpath("//div[@id='content']/div[3]/div[2]"));
        verifyText("verify Text","Checkout",By.xpath("//div[@id='checkout-checkout']/div/div/h1"));
        verifyText("verify Text","New Customer",By.xpath("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/h2"));
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//div[@id='checkout-checkout']/div/div/div/div/div[2]/div/div/div/div[2]/label/input"));
        //2.24 Click on “Continue” button //2.25 Verify the message “Warning: Payment method required!”
        clickOnElement(By.id("button-account"));
    }
    @After
    public void tearDown(){closeBrowser();}
}
