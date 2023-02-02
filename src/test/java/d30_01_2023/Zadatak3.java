package d30_01_2023;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
        public static void main(String[] args) throws InterruptedException {

//Zadatak
//Napisati program koji:
//Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//Implicitno cekanje za trazenje elemenata je maksimalno 10s
//Implicitno cekanje za ucitavanje stranice je 5s
//Ucitava stranicu https://docs.katalon.com/
//Maksimizuje prozor
//Od html elementa cita data-theme atribut.
//Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//Klikce na dugme za zamenu tema
//Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
//Ceka da se dijalog za pretragu pojavi
//Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//Zatvara pretrazivac
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            driver.get("https://docs.katalon.com/");
            driver.manage().window().maximize();

            //Od html elementa cita data-theme atribut.
            //Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke(IF PROVERA)

            if(driver.findElement(By.tagName("html")).getAttribute("data-theme").equals("light")){
                System.out.println("Tema je ligth");
            }

//            Klikce na dugme za zamenu tema
            driver.findElement(By.className("clean-btn toggleButton_rCf9")).click();


//Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark

            if(driver.findElement(By.tagName("html")).getAttribute("data-theme").equals("dark")){
                System.out.println("Tema je dark");
            }


//          //Izvrsava kombinaciju tastera CTRL + K.
//          Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta

            new Actions(driver).keyDown(Keys.CONTROL)
                            .sendKeys("k")
                            .perform();

//          //Ceka da se dijalog za pretragu pojavi

            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Doc-Search-input")));

////Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search

            if (driver.findElement(By.className("Doc-Search-input"))
                    .getAttribute("type").equals("search")){
                System.out.println("Vrednost atributa je search");
            }

            Thread.sleep(1000);

            driver.quit();
        }
    }

