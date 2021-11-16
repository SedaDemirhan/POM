package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcorthotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeTestConfigReader extends TestBase {

    @Test
    public void test(){
        //https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));
        // login butonuna bas
        ConcorthotelPage concorthotelPage=new ConcorthotelPage(driver);
        concorthotelPage.loginTusu.click();
        // test data username: manager1 ,
        concorthotelPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        // test data password : manager1!
        concorthotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        concorthotelPage.loginButonu.click();
        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concorthotelPage.isLoginFailed.isDisplayed());
    }
}
