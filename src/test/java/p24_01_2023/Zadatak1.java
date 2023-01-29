package p24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/ ");

        //  Xpath za trazenje ovog elementa treba da bude preko name atributa
        driver.findElement(By.name("s")).sendKeys("Flying Ninja");

        //        Klikce na dugme za pretragu. button
        //        Xpath za trazenje ovog elementa treba da bude preko class atributa.
        driver.findElement(By.xpath("//button[@class='search-submit']")).click();



        Thread.sleep(5000);

        driver.quit();
    }
}
