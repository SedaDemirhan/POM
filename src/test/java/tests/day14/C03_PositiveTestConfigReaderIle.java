package tests.day14;

import org.testng.annotations.Test;
import pages.ConcorthotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReaderIle extends TestBase {

    @Test
    public void positiveTestConfig(){

        // https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));

        ConcorthotelPage concortHotelPage=new ConcorthotelPage(driver);
        // login butonuna bas
        concortHotelPage.loginTusu.click();
        // test data username: manager ,
        concortHotelPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        // test data password : Manager1!
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        concortHotelPage.loginButonu.click();


    }

}
