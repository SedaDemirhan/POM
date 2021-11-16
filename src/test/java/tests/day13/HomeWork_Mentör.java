package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Collections;
import java.util.List;

public class HomeWork_Mentör extends TestBase {
    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list

     */

    @Test

    public void clickAllElements() throws InterruptedException {
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        driver.findElement(By.linkText("Phones & PDAs")).click();

        List<WebElement>brandNameList=driver.findElements(By.tagName("h4"));

        for (WebElement w:brandNameList) {
            System.out.println("phone names : "+w.getText());

        }
        List<WebElement> AddToCart = driver.findElements(By.xpath("//span[text()='Add to Cart']"));
        for (WebElement w : AddToCart) {
            w.click();

        }
        Thread.sleep(2000);
        driver.findElement(By.id("cart-total")).click();

        List<WebElement>sepet=driver.findElements(By.xpath("//td[@class='text-left']"));
        for (WebElement w:sepet) {
            System.out.println("sepet ürünleri :"+ w.getText());

        }

        for (int i = 0; i <brandNameList.size() ; i++) {

            if (!brandNameList.get(i).equals(sepet.get(i))){

            }
         System.out.println("Ürün listesi ve sepet eşit değil");
    }}

}
