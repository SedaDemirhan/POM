package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcorthotelPage;
import utilities.TestBase;

public class C02_ConcortHotelLoginNegative extends TestBase {


    @Test
    public void NegativeLoginTest(){

        //Bir test method olustur NegativeLoginTest()
        // https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com/");
        // login butonuna bas
        ConcorthotelPage concorthotelPage=new ConcorthotelPage(driver);
        concorthotelPage.loginTusu.click();

        // test data username: manager1 ,
        concorthotelPage.userNameKutusu.sendKeys("manager1");

        // test data password : manager1!
        concorthotelPage.passwordKutusu.sendKeys("manager1!");

        // Degerleri girildiginde sayfaya girilemedigini test et
        concorthotelPage.loginButonu.click();
        Assert.assertTrue(concorthotelPage.isLoginFailed.isDisplayed());


    }
}
