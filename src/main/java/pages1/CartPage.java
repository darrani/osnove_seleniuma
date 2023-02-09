package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
//    Kreirati CartPage
//hvata delete dugme za red po indeksu
//input za kupon
//dugme apply coupon
//update cart dugme
//hvata sve redove tabele

    public List<WebElement>getTableRows(){
        return driver.findElements(By.className("cart_item"));
    }
    public List<WebElement> waitForNumberOfRowsToBe(int expectedNumOfRows){
        return wait.until(ExpectedConditions.numberOfElementsToBe(By.className("cart_item"), expectedNumOfRows));
    }
    public WebElement getRemoveItemButtonByRows(int row){
        return driver.findElement(By.xpath("//tbody/tr[contains(@class, 'cart_item')]["+row+"]/td/a"));
    }
}
