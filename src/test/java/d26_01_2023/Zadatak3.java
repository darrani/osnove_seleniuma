package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        //3.Zad
        //Napisati program koji:
        //Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
        //Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika
        // element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
        //POMOC: Brisite elemente odozdo.
        //(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");


      List<WebElement> buttons = (List<WebElement>) driver.findElement(By.className("close"));
//        driver.findElement(By.className("close")).click();
        for (int i = 0; i < buttons.size(); i++) {
           String item = buttons.get(i).getAttribute("class");
           buttons.get(i).findElement(By.tagName("button")).click();
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
