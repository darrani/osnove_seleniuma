package p06_02_2023tests;

import com.sun.org.glassfish.gmbal.Description;

import helper.Helper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class KatalonShopTest  extends BaseTest{
//    Kreirati KatalonShopTests klasu:
//	baseUrl:
//	Test #1:  Adding product with quantity to the cart
//	Prioritet = 10
//	Koraci:
//Ucitati stranicu /product/flying-ninja/
//Unesite kolicinu 3
//Klik na Add to cart dugme
//Verifikovati da poruka sadrzi tekst “Flying Ninja”.
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//

    @Test
    public void verifyNavLinks() throws IOException {
        String cartLink = navPage.getCartLink().getAttribute("href");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(new Helper().getHTTPResponseStatusCode(cartLink),
                200, "Cart link invalid status code");

        String checkoutLink = navPage.getCheckoutLink().getAttribute("href");
        softAssert.assertEquals(new Helper().getHTTPResponseStatusCode(checkoutLink),
                200, "Checkout ;ink invalid status code.");

        softAssert.assertAll();
    }

       @Test (priority = 10)
        @Description("Test #1:Adding product with quantity to the cart")
        public void addingProductWithQuantityToTheCart(){
            driver.get(baseUrl + "/product/flying-ninja/");
            productPage.getQuantutyInput().clear();
            productPage.getQuantutyInput().sendKeys("3");
            productPage.getAddToCartButton().click();
            Assert.assertTrue(productPage.getMassageBox().getText().contains("Flying Ninja"), "Wrong message");
            navPage.getCartLink().click();
//          Assert.assertEquals(driver.getCurrentUrl(), baseUrl +"/cart", "Not on cart page.");
            cartPage.waitForNumberOfRowsToBe(1);

                    
        }
    //	Test #2:  Removing product from cart
//	Prioritet = 20
//	Koraci:
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//Klik na remove dugme iz prvog reda
//Verifikovati da je broj proizvoda u korpi jedako 0
    @Test (priority = 20)
    @Description("Test #2: Removing product from cart")
    public void removingProductFromCart(){
        navPage.getCartLink().click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/cart/", "Not on cart page.");
        cartPage.waitForNumberOfRowsToBe(1);
        cartPage.getRemoveItemButtonByRows(1).click();
        cartPage.waitForNumberOfRowsToBe(0);

    }

}
