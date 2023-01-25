package p24_01_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodUSelenium {

            public static void main(String[] args) throws InterruptedException {



                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

                WebDriver driver = new ChromeDriver();

                driver.manage().window().maximize();

                driver.get("https://cms.demo.katalon.com/");
                driver.get("https://google.com/");
                driver.navigate().to ("https://youtube.com/");

                driver.navigate().back();
                driver.navigate().forward();

                Thread.sleep(1000);

                driver.quit();

            }


}
