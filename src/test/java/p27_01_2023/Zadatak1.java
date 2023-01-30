package p27_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        //1.Zadatak
        //Ucitati stranicu https://demoqa.com/modal-dialogs
        //Kliknuti na dugme Large modal
        //Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.id("showLargeModal")).click();

        List<WebElement>divs = driver.findElements(By.id("example-modal-sizes-title-lg"));
        if(divs.size()>0){
            System.out.println("postoji");
        }else{
            System.out.println("Ne postoji");
        }

//        if(new Helper().elementExist(driver,By.id("example-modal-sizes-title-lg"))){
//            System.out.println("Postoji");
//        }else{
//            System.out.println("Ne postoji");
//        }
        Thread.sleep(5000);

        driver.quit();
    }
}
