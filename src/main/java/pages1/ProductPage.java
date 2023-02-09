package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
//    Kreirati ProductPage koja ima:
//quantity
//add to cart button
//poruka o dodavanju proizvoda u korpu

    public WebElement getQuantutyInput(){
        return driver.findElement(By.name("quantity"));
    }
    public WebElement getAddToCartButton(){
        return driver.findElement(By.name("add-to-cart"));
    }
    public WebElement getMassageBox(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("woocommerce-message")));
    }
    public WebElement getViewCartButton(){
        return driver.findElement(By.name("wc-forward"));
    }
}
