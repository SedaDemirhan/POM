package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReasubleMethodsKullanımı {

    @Test
    public void test(){


    // https://the-internet.herokuapp.com/windows adrese gidelim
    //  click here yazisina basalim
    //  yeni sayfada New Window yazisinin gorundugunu test edelim

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandleDegeri=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

       Set<String> windowHandleKümesi= Driver.getDriver().getWindowHandles();

       String ikinciSayfaHandleDeğeri=" ";
        for (String each:windowHandleKümesi
             ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
            ikinciSayfaHandleDeğeri=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDeğeri);
        System.out.println(Driver.getDriver().getTitle());

        //  yeni sayfada New Window yazisinin gorundugunu test edelim
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(newWindowYaziElementi.isDisplayed());

        Driver.closeDriver();

      }
      @Test
    public void testReasubleIle(){
          Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
          Driver.getDriver().findElement(By.linkText("Click Here")).click();
          ReusableMethods.switchToWindow("New Window");
          WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
          Assert.assertTrue(newWindowYaziElementi.isDisplayed());

          ReusableMethods.waitFor(5);
          Driver.closeDriver();
      }

 }