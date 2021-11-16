package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcorthotelPage;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeTest {

        //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
        //3 Farkli test Methodunda 3 senaryoyu test et
        // - yanlisSifre
        // - yanlisKulllanici
        // - yanlisSifreKullanici
        //test data yanlis username: manager1 , yanlis password : manager1!
        //2) https://qa-environment.concorthotel.com/ adresine git
        //3) Login butonuna bas
       //4) Verilen senaryolar ile giris yapilamadigini test et


        @Test(priority = -3 ,groups="birinciGrup")
     public void yanlısŞifre(){
            Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
            QAConcortPage qaConcortPage=new QAConcortPage();
            qaConcortPage.loginTusu.click();
            qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHQValidUsername"));
            qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQInvalidPassword"));
            qaConcortPage.loginButonu.click();
            Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());
        }
        @Test(dependsOnMethods = "yanlısŞifre",groups="birinciGrup")
    public void yanlışKullanıcı(){
            QAConcortPage qaConcortPage=new QAConcortPage();
            qaConcortPage.userNameKutusu.clear();
            qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHQInvalidUsername"));
            qaConcortPage.passwordKutusu.clear();
            qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQValidPassword"));
            qaConcortPage.loginButonu.click();
            Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());

        }
        @Test(dependsOnMethods = "yanlısŞifre")
    public void yanlisSifreKullanici(){
            QAConcortPage qaConcortPage=new QAConcortPage();
            qaConcortPage.userNameKutusu.clear();
            qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHQInvalidUsername"));
            qaConcortPage.passwordKutusu.clear();
            qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQInvalidPassword"));
            qaConcortPage.loginButonu.click();
            Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());

            Driver.closeDriver();

        }

    }

