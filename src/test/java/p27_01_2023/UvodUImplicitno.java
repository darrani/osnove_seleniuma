package p27_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodUImplicitno {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///D:/Downloads/Zadatak4%20(1).html");
        driver.findElement(By.id("showBtn"));


//        boolean elementExist= true;
//        try{
//            System.out.println("Posle trazenje");
//            WebElement div = driver.findElement(By.id("id-0"));
//            System.out.println("Posle trazenja");
//        }catch (NoSuchElementException error){
//            elementExist = false;
//        }
//
//        if (elementExist){
//            System.out.println("Element postoji");
//        }else{
//            System.out.println("Element ne postoji");
//        }

        //importujemo ovaj objekat Helper koji je napravljen u java folderu
//        Helper helper = new Helper();
//       if(helper.elementExist(driver, By.id("id-0"))){
//           System.out.println("Postoji");
//       }else{
//           System.out.println("Ne postoji");
//       }

      //  II nacin uz pomoc liste





        Thread.sleep(5000);
        driver.quit();
    }
}
