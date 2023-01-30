package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

      //Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.ebay.com/");

        WebElement selectElement = driver.findElement(By.id("gh-cat"));

        //selectElement hvatamo tako stopravimo objekat Select

        Select select = new Select(selectElement);
        select.selectByValue("14339");


        Thread.sleep(5000);
        driver.quit();
    }
}
