package p24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");


        WebDriver driver = new ChromeDriver();

       ArrayList<String> niz = new ArrayList<String>();

       niz.add("https://google.com/");
        niz.add("https://youtube.com/");
        niz.add("https://www.ebay.com/");
        niz.add("https://www.kupujemprodajem.com/");

        for (int i = 0; i < niz.size(); i++) {
            driver.get(niz.get(i));

            System.out.println(driver.getTitle());

        }

        driver.quit();
    }
}
