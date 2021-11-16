package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_WindowHandleRaporu extends TestBaseRapor {

    @Test
    public void test(){
        extentTest=extentReports.createTest("window handle test","yeni sayfada new window yazısını test eder");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("istenen adrese gidildi");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("linke tıklandı");
        ReusableMethods.switchToWindow("New Window");
        extentTest.info("yeni sayfaya geçildi");
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        extentTest.info("test edeceğimiz yazı locate edildi");
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        extentTest.info("yazının görünür olduğu test edildi");

        //info yerine pass yazarsak raporda tik işareti olur
    }
}
