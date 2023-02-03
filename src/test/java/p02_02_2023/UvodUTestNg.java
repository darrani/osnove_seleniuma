package p02_02_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class UvodUTestNg {

        private WebDriver driver;
        private WebDriverWait wait;

    @BeforeClass
        public void beforeClass() {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            this.driver = new ChromeDriver();
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }
     @BeforeMethod
        public void before(){
        driver.get("");
    }


    @Test
    public void googleTitle(){
        System.out.println("Google title test");
    }
    @Test
    public void googleUrl(){
        System.out.println("Google  url test");
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
