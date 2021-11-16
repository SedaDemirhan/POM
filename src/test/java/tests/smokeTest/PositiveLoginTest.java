package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {

    @Test
    public void positiveLoginTest(){
        //Bir test method olustur positiveLoginTest()
        // https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        // login butonuna bas
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.loginTusu.click();

        //test data username: manager ,
        qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHQValidUsername"));

        //test data password : Manager1!
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQValidPassword"));
        qaConcortPage.loginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(qaConcortPage.basarılıGirisYazıElementi.isDisplayed());

        Driver.closeDriver();


    }
}
