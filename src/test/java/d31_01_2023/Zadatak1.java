package d31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Zadatak1 {
        public static void main(String[] args) throws InterruptedException {

//1.1.Zadatak
//Napisati program koji:
//Podesava:
//implicitno cekanje za trazenje elemenata od 10s
//implicitno cekanje za ucitavanje stranice od 10s
//eksplicitno cekanje podeseno na 10s
//Podaci:
//Potrebno je u projektu ukljuciti 4 slike:
//front.jpg
//left.jpg
//right.jpg
//back.jpg
//Koraci:
//Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//Maksimizuje prozor
//Klik na edit ikonicu
//Klik na delete iz iskacuceg dijaloga
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte front.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 1.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte right.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 2.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte back.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 3.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte back.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 3.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Sacekajte da Next dugme bude klikljivo
//Klik na Next dugme
//Unesite tekst
//Klik na Next
//Klik na Preview
//Klik na Add to cart
//Sacekajte 5s
//Quit
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.manage().window().maximize();
            driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");





                driver.findElement(By.xpath("//*[contains(@class, 'edit')]")).click();

                    driver.findElement(By.xpath("//*[contains(@class, 'remove')]")).click();
                    driver.findElement(By.xpath("//*[contains(@class, 'edit')]")).click();






            Thread.sleep(1000);

            driver.quit();
        }
    }
