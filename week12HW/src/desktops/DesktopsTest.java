package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import units.Utility;

public class DesktopsTest extends Utility {
    String baseUrl ="https://tutorialsninja.com/demo/index.php";
//    public void selectMenu(By by,String menu){
//        WebElement element = driver.findElement(by);
//        element.click();
//    }
    @Before
    public void setUp(){ openBrowser(baseUrl);}

    @Test
    public void name (){//verify Product Arrange In Alphabatical Order
mouseHover(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li"));
//selectMenu(By.xpath("//ul[@class='nav navbar-nav']/li/div/a"),"Show AllDesktops");
        selectMenu("Show AllDesktops");
       selectDropDown(By.id("input-sort"),"Name (Z - A)");
       String actualText = getTextFromElement(By.xpath("//select[@id='input-sort']/option[3]"));
       String expectedText = "Name (Z - A)";
        Assert.assertEquals("verifying order",expectedText,actualText);
    }
    @Test
    public void  verifyProductAddedToShoppingCartSuccessFully(){
        //select currency
        clickOnElement(By.xpath("//*[@id=\"form-currency\"]/div/button/span"));
       clickOnElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button"));


        mouseHover(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li"));
        selectMenu("Show AllDesktops");
        selectDropDown(By.id("input-sort"),"Name (A - Z)");
        clickOnElement(By.xpath("//div[@id='content']/div[4]/div[3]/div/div[2]/div/h4/a"));
        String actualText = getTextFromElement(By.xpath("//div[@id='content']/div/div[2]/h1"));
        String expectedText = "HP LP3065";
        Assert.assertEquals("verifying Text",expectedText,actualText);
        //date picker
        String year = "2023";
        String month = "June";

        driver.findElement(By.xpath("//div[@class='input-group date']/span/button")).click();

        while (true) {
            String monthyear = driver.findElement(By.xpath("//div[3]/div/div[1]/table/thead/tr[1]/th[2]")).getText();
            String arr[] = monthyear.split(" ");
            String mon = arr[0];
            String year1 = arr[1];

            if (mon.equalsIgnoreCase(month) && year1.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[3]/div/div[1]/table/thead/tr[1]/th[3]"));
            }
        }
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/table/tbody/tr[4]/td[3]")).click();
        //add qty 1
        WebElement qty = driver.findElement(By.xpath("//div[@id='product']/div[2]/input"));
        qty.clear();
        qty.sendKeys("1");
        //click on add to cart button
        clickOnElement(By.id("button-cart"));
        String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        Assert.assertEquals("verifying message",expectedText1,actualText1);
        //Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("Shopping Cart"));
        //Verify the text "Shopping Cart"
        String actualText2 = getTextFromElement(By.linkText("Shopping Cart"));
        String expectedText2= "Shopping Cart";
        Assert.assertEquals("verifing Text",expectedText2,actualText2);

        //Verify the Product name "HP LP3065"
        String actualTextHP = getTextFromElement(By.xpath("//div[@id='checkout-cart']/div//form//td[2]/a"));
        String expectedTextHP= "HP LP3065";
        Assert.assertEquals("verifying text",expectedTextHP,actualTextHP);
        //Verify the Delivery date
        String actualDeleivery = getTextFromElement(By.xpath("//div[@id='checkout-cart']/div//form//td[2]/small"));
        String expectedDelivery = "Delivery Date:2023-06-21";
        Assert.assertEquals("verfying date",expectedDelivery,actualDeleivery);
        //Verify the Model
        String actualModel = getTextFromElement(By.xpath("//div[@id='checkout-cart']/div//form//tbody//td[3]"));
        String expectedModel = "Product 21";
        Assert.assertEquals("verifying model",expectedModel,actualModel);
        //Verify price
        String actualPrice = getTextFromElement(By.xpath("//div[@id='checkout-cart']/div//form//tbody//td[5]"));
        String expectedPrice = "£74.73";
        Assert.assertEquals("Verifying price",expectedPrice,actualPrice);

    }
    @After
    public void teardown(){closeBrowser();}
}
