package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        //4.Zadatak
        //Napisati program koji ucitava stranicu https://geodata.solutions/
        //Bira Country, State i City po vasoj zelji
        //Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
        //I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
        //Izabrerit Country, State i City tako da imate podatke da selektujete!

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://geodata.solutions/");

        Select country = new Select(driver.findElement(By.id("countryId")));
        Thread.sleep(1000);
        country.selectByValue("Serbia");
        Thread.sleep(1000);

        Select state = new Select(driver.findElement(By.id("stateId")));
        Thread.sleep(1000);
        state.selectByValue("Central Serbia");
        Thread.sleep(1000);

        Select city = new Select(driver.findElement(By.id("cityId")));
        Thread.sleep(1000);
        city.selectByValue("Nis");
        Thread.sleep(1000);



        Thread.sleep(5000);

        driver.quit();
    }
}
