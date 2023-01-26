package d24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();


        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("Me");
        driver.findElement(By.className("oxd-main-menu-item")).click();


       Thread.sleep(1000);

        driver.findElement(By.xpath("oxd-userdropdown-name")).click();
        driver.findElement(By.className("oxd-userdropdown-link")).click();



        Thread.sleep(5000);


        driver.quit();
    }
}
