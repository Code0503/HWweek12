package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import units.Utility;

public class TopMenuTest  extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";


    public void selectMenu(By by,String menu){
        WebElement element = driver.findElement(by);
        element.click();
    }
        @Before
        public void setUp() {
            openBrowser(baseUrl);
        }

       @Test

        public void verifyUserShouldNavigateToDesktopsPageSuccessfully () {
            mouseHover(By.xpath("//ul[@class='nav navbar-nav']/li"));//Mouse hover
           //called select Menu method
            selectMenu(By.xpath("//ul[@class='nav navbar-nav']/li/div/a"),"Show All Desktops");
            //verify Text
            String actualText = getTextFromElement(By.xpath("//div[@id='content']/h2"));
            String expectedText = "Desktops";
            Assert.assertEquals("verifying Text", expectedText, actualText);
        }
        @Test
        public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully () { //Mouse hover
            mouseHover(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[2]"));
           //called select Menu method
           selectMenu(By.xpath("//ul[@class='nav navbar-nav']/li[2]/div/a"), "Show AllLaptops & Notebooks");
            //verify text
            String actualText = getTextFromElement(By.xpath("//div[@id='content']/h2"));
            String expectedText = "Laptops & Notebooks";
            Assert.assertEquals("verifying Text", expectedText, actualText);
        }
        @Test
        public void verifyUserShouldNavigateToComponentsPageSuccessfully () {

            mouseHover(By.xpath("//ul[@class='nav navbar-nav']/li[3]"));// Mouse Hovering method
            selectMenu(By.xpath("//ul[@class='nav navbar-nav']/li[3]/div/a"),"Show AllComponents");
            String actualText = getTextFromElement(By.xpath("//div[@id='content']/h2"));
            String expectedText = "Components";
            Assert.assertEquals("verifying Text", expectedText, actualText);
        }
        @After
        public void teardown () {closeBrowser();}
    }

