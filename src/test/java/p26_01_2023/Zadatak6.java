package p26_01_2023;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {

//      6. Zadatak
//Ucitati stranicu https://cms.demo.katalon.com/
//Maksimizovati prozor
//Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
//Prostavite duzinu prozora na 700px i visinu na 700px
//Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://cms.demo.katalon.com/");
        driver.manage().window().maximize();

        //Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)


        driver.findElement(By.className("menu-toggle"));

        if(driver.findElement(By.className("menu-toggle")).isDisplayed()){
            System.out.println("Vidljivo je");
        }else{
            System.out.println("Nije vidljivo");
        }

//    Prostavite duzinu prozora na 700px i visinu na 700px

        driver.manage().window().setSize(new Dimension(700,700));

//Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
        if(driver.findElement(By.className("menu-toggle")).isDisplayed()){
            System.out.println("Vidljivo je");
        }else{
            System.out.println("Nije vidljivo");
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
