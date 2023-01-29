package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        //Zadatak
        //Niz todo-a (niz stringova) koje treba da uneti. Niz je:
        //Visit Paris
        //Visit Prague
        //Visit London
        //Visit New York
        //Visit Belgrade
        //Maksimizirati prozor
        //Ucitati stranicu https://example.cypress.io/todo
        //Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
        //Nakon svakog unosa todo-a, unosi se enter
        //Validira da li je novi todo dodat na stranici
        //Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
        //Validirati da je na kraju programa broj todo-a na stranici 0.
        //Cekanje od 5s
        //Zatvorite pretrazivac

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);



//Maksimizirati prozor
        driver.manage().window().maximize();
        //Ucitati stranicu https://example.cypress.io/todo
        driver.get("https://example.cypress.io/todo");



        List<String> todos = new ArrayList<>();
        todos.add("Visit Paris");
        todos.add("Visit Prague");
        todos.add("Visit London");
        todos.add("Visit New York");
        todos.add("Visit Belgrade");


        for (int i = 0; i < todos.size(); i++) {

            driver.findElement(By.className("new-todo")).sendKeys(todos .get(i));
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            if (todos.get(i).equals(driver.findElement
                    (By.xpath("//li[last()]//div[@class='viev']/label")).getText())){
                System.out.println("Unet je novo todos: ");
            }
        }


    List<WebElement> elementsList = driver.findElements(By.xpath("//li//div[@class='view']"));
        for (int i = 0; i < elementsList.size(); i++) {
            WebElement liLink = driver.findElement(By.xpath("//li[last()]//div[]@class='view'"));

            actions.moveToElement(liLink);
            actions.perform();
            driver.findElement(By.xpath("//[last()]//button[contains@class,'destroy']")).click();
            Thread.sleep(1000);
        }



        Thread.sleep(5000);

       driver.quit();
    }
}
