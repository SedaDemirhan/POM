package tests.day13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C03_Pages extends TestBase {

    @Test
    public void test(){
        //amazon sayfasına gidin
        driver.get("https://amazon.com");


        //dropdown menuden book kategorisini seçin
        AmazonPage amazonPage=new AmazonPage(driver);
        Select select=new Select(amazonPage.dropDown);
        select.selectByVisibleText("Books");

        //java için arama yapın
        amazonPage.aramaKutusu.sendKeys("java"+ Keys.ENTER);

        //bulunan sonuç sayısını yazin
        System.out.println(amazonPage.sonucYazısıElementi.getText());

        //ilk ürünün içinde java geçtiğini test edin
        Assert.assertTrue(amazonPage.ilkÜrünİsmi.getText().contains("Java"));

    }

}
