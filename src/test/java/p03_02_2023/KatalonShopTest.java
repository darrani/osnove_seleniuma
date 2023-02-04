package p03_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonShopTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://cms.demo.katalon.com";

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
        driver.get("https://cms.demo.katalon.com");
    }

//    Koraci:
//Ucitati stranicu /product/flying-ninja/
//Unesite kolicinu 3
//Klik na Add to cart dugme
//Verifikovati da poruka sadrzi tekst “Flying Ninja”.
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
    @Test(priority = 10)
    @Description("Adding product with quantity to the cart")

    public void addingProductWithQuantityToTheCart() throws InterruptedException {
        driver.get(baseUrl + "/product/flying-ninja/");

        driver.findElement(By.xpath("//*[@class='quantity]/input")).clear();
        driver.findElement(By.xpath("//*[@class='quantity]/input")).sendKeys("3");
        driver.findElement(By.name("add-to-cart")).click();

        WebElement message = driver.findElement(By.className("woocommerce-message"));

        Assert.assertTrue(message.getText().contains("Flying Ninja"), "Message does not contain right message.");
        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li/a")).click();

        driver.findElement(By.className("woocommerce-message")).findElement(By.tagName("a")).click();



        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+ "//cart", "Url is not right");

        int cartElements = driver.findElements(By.xpath("//*[@='entry-content']/div/form")).size();
        Assert.assertEquals(cartElements, 1, "There are no products in the cart");

    }

//    Test #2:  Removing product from cart
//	Prioritet = 20
//	Koraci:
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//Klik na remove dugme iz prvog reda
//Verifikovati da je broj proizvoda u korpi jedako 0


    @Test (priority = 20)
    @Description ("Removing product from cart")

    public void removingProductFromCart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class=' nav-menu']/li/a")).click();
//Verifikovati da u url-u stoji /cart ruta
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+ "/cart/", "Url is not right");

        int cartElements = driver.findElements(By.xpath("//[@class='entry-content']/div/form")).size();
        Assert.assertEquals(cartElements,1, "There are no products in the cart");

        driver.findElement(By.xpath("//*[@class='product-remove']/a")).click();
        Thread.sleep(3000);

        cartElements = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
        Assert.assertEquals(cartElements, 0, "There are no products in the cart");

    }
//    Test #3:  Verify error is displayed when username is missing
//	Prioritet = 30
//	Koraci:
//Kliknite na my account link
//Klik na login dugme
//Verifikovati da je prikazana poruka Error: Username is required.
    @Test (priority = 30)
    @Description("Verify error is displayed when username is missing")
    public void verifyErrorIsDisplayedWhenUsernameIsMissing(){
        driver.findElement(By.xpath("//*[@id='primary-menu']//li[3]/a")).click();
        driver.findElement(By.name("login")).click();
        String errorMessage = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();

        Assert.assertEquals(errorMessage, "Error:  Username is required.", "Error message is wrong");
    }
//    Test #4:  Verify error is displayed when password is missing
//	Prioritet = 40
//	Koraci:
//Kliknite na my account link
//Unesite username customer
//Klik na login dugme
//Verifikovati da je prikazana poruka ERROR: The password field is empty.
//

    @Test (priority = 40)
    @Description ("Verify error is displayed when password is missing")
        public void  verifyErrorIsDisplayedWhenPasswordIsMissing(){
        driver.findElement(By.xpath("//*[@id='primary-menu']//li[3]/a")).click();

        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.name("login")).click();
        String errorMessage = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();
        Assert.assertEquals(errorMessage, "ERROR: The password field is empty.", "Password field must be filled");

    }


    //Test #5:  Verify error is displayed when password is wrong
//	Prioritet = 50
//	Koraci:
//Kliknite na my account link
//Unesite username customer
//Unesite nevalidan pass invalidpassword
//Klik na login dugme
//Verifikovati da je prikazana poruka ERROR: The password you entered for the username customer is incorrect. Lost your password?
    @Test (priority = 50)
    @Description ("Verify error is displayed when password is wrong")
    public void  verifyErrorIsDisplayedWhenPasswordIsWrong(){
        driver.findElement(By.xpath("//*[@id='primary-menu']//li[3]/a")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
        driver.findElement(By.name("login")).click();
        String errorMessage = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();
        Assert.assertEquals(errorMessage, "The password you entered for the username customer is incorrect. Lost your password?", "Error message is wrong");
    }

//Test #6:  Verify error is displayed when user does not exist
//	Prioritet = 60
//	Koraci:
//Kliknite na my account link
//Unesite username invaliduser
//Unesite nevalidan pass (ex: pass1234)
//Klik na login dugme
//Verifikovati da je prikazana poruka ERROR: Invalid username. Lost your password?
@Test (priority = 60)
@Description ("Verify error is displayed when user does not exist")
public void  verifyErrorIsDisplayedWhenUserDoesNotExist(){
    driver.findElement(By.xpath("//*[@id='primary-menu']//li[3]/a")).click();
    driver.findElement(By.id("username")).sendKeys("invaliduser");
    driver.findElement(By.id("password")).sendKeys("pass12234");
    driver.findElement(By.name("login")).click();
    String errorMessage = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();
    Assert.assertEquals(errorMessage, "Invalid username. Lost your password?", "Error message is wrong");

}
//Test #7:  Verify successful login
//	Prioritet = 70
//	Koraci:
//Kliknite na my account link
//Unesite username customer
//Unesite validan pass crz7mrb.KNG3yxv1fbn
//Klik na login dugme
//Verifikovati na stranici pise Hello Katalon Parlitul_Changed
//	Dopunite pageve za sve sto je potrebno za ove testove, ako je potrebno kreirajte i nove pageve

    @Test (priority = 70)
    @Description ("Verify successful login")
    public void  verifySuccessfulLogin(){
        driver.findElement(By.xpath("//*[@id='primary-menu']//li[3]/a")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.name("login")).click();

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[contains(@class, 'MyAccount-content')]/p[1]"))
                , "Hello Katalon Parlitul_Changed"));
    }

    @AfterMethod

    public void after(){
        System.out.println("After method");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}


