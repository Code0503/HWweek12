package units;

import browserfectory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {  //This method created for click on element
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public String getTextFromElement(By by) { //This method created for get text from Elements
        return driver.findElement(by).getText();
    }

    public void sendTextToElment(By by, String text) {// This method will send text to elements
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement element1 = driver.findElement(by);
        actions.moveToElement(element1).click().build().perform();
    }

    public void selectDropDown(By by, String Text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
select.selectByVisibleText(Text);


    }
public void verifyText( String verifyText,String expectedText,By by){
        String actualText = getTextFromElement(by);
    Assert.assertEquals(verifyText,expectedText,actualText);

}

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }

    }





}



