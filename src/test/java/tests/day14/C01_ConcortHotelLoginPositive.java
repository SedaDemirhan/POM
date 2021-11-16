package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcorthotelPage;
import utilities.TestBase;

import java.sql.Driver;

public class C01_ConcortHotelLoginPositive extends TestBase {

    //1 ) Bir Class olustur : PositiveTest
    //2) Bir test method olustur positiveLoginTest()
    @Test
    public void positiveLoginTest(){

        // https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com/");
        ConcorthotelPage concorthotelPage=new ConcorthotelPage(driver);

        // login butonuna bas
        concorthotelPage.loginTusu.click();

        // test data username: manager ,
        concorthotelPage.userNameKutusu.sendKeys("manager");

        // test data password : Manager1!
        concorthotelPage.passwordKutusu.sendKeys("Manager1!");

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        concorthotelPage.loginButonu.click();
        Assert.assertTrue(concorthotelPage.basarılıGirisYazıElementi.isDisplayed());
    }
}
