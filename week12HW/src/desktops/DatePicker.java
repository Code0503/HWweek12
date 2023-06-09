package desktops;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import units.Utility;

public class DatePicker extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php?route=product/product&path=20&product_id=47";
    @Before
    public void setUp(){openBrowser(baseUrl);}
    @Test
    public void selectDate() {
        String year = "2023";
        String month = "June";
        String date = "21";

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
//        List<WebElement> litOfDates = driver.findElements(By.xpath("//div[@class='datepicker']/div/table/tbody"));
////        for (WebElement dt : litOfDates){
////            if (dt.getText().equalsIgnoreCase(date)){
////                dt.click();
////                break;
////            }
////        }
    }

}
