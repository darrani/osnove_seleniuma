package d02_02_2023;


import com.sun.org.glassfish.gmbal.Description;
import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class BootstrapTableTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://s.bootsnipp.com";

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @BeforeMethod
    public void before(){
        driver.get(baseUrl);
    }


//    Test #1: Edit Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Edit dugme prvog reda
//Sacekati da dijalog za Editovanje bude vidljiv
//Popuniti formu podacima.
//Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//Klik na Update dugme
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
    @Test (priority = 1)



//
//
//    @Test(priority = 3)
//    @Description("TC3 - Verify the page title and take a screenshot")
//    public void pageTitleAndScreenshot() throws InterruptedException, IOException {
//        driver.get(baseURL + "/iframe/K5yrx");
//        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
//                "Page title is not the same.");
//        //        https://www.browserstack.com/guide/take-screenshots-in-selenium
//        new Helper().takeScreenshot(driver, "screenshots/slika.png");
//    }
    @Description("Edit Row")
    public void editRow() throws InterruptedException {
        driver.get(baseUrl + "/iframe/K5yrx");
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Not on my account page." );

      driver.findElement(By.xpath("//button[contains(@class, 'update')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));


        //Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link

        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("fn")).sendKeys("Dragana");
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("ln")).sendKeys("Nikolic");
        driver.findElement(By.id("mn")).clear();
        driver.findElement(By.id("mn")).sendKeys("Radomir");

        //Klik na Update dugme
        driver.findElement(By.id("up")).click();
//        //Sacekati da dijalog za Editovanje postane nevidljiv
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[@class='modal-body']")));



//        Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime

        Assert.assertEquals(driver.findElement(By.id("f1")).getText(), "Dragana", "Entered name is not correct.");

 //       Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
        Assert.assertEquals(driver.findElement(By.id("l1")).getText(), "Nikolic", "Entered name is not correct.");
//        Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
        Assert.assertEquals(driver.findElement(By.id("m1")).getText(), "Radomir", "Entered name is not correct.");
    }

//Test #2: Delete Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:x
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Delete dugme prvog reda
//Sacekati da dijalog za brisanje bude vidljiv
//Klik na Delete dugme iz dijaloga
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da je broj redova u tabeli za jedan manji
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
    @Test (priority = 2)
    @Description(" Delete  Row")
    public void deleteRow() throws InterruptedException {
        driver.get(baseUrl + "/iframe/K5yrx");

//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Not on my account page.");

        driver.findElement(By.xpath("//button[contains(@class, 'delete')]")).click();

        //Sacekati da dijalog za Editovanje postane nevidljiv
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));


        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        int count = 0;
        for (WebElement row : rows) {
            if (row.isDisplayed()) {
                count++;
                Assert.assertNotSame(count, count - 1, "The number of rows has not decreased by 1");
            }
        }
    }
//Test #3: Take a Screenshot
//Koraci:
//Ucitati stranu  /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Kreirati screenshot stranice.
//Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg.
// Na putanji: screenshots/slike.png
//

                @Test(priority = 3)
                @Description("Take a Screenshot")

                public void takeAScreenshot () {
                    driver.get(baseUrl + "/iframe/K5yrx");
                    Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                            "Not on my account page.");
                    new Helper().takeScreenshot(driver, "screenshots/slika.png");
                }

                @AfterMethod

                public void after () {
                    System.out.println("After method");
                }

                @AfterClass
                public void afterClass () throws InterruptedException {
                    Thread.sleep(5000);
                    driver.quit();
                }


    }

