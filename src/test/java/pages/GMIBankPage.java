package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class GMIBankPage {

    public GMIBankPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-user fa-w-14 ']")
    public WebElement ilkGirişButonu;

    @FindBy(xpath ="//span[text()='Sign in']" )
    public WebElement signInButonu;

    public void GMIBankLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("GMIBankUrl"));
        GMIBankPage gmiBankPage=new GMIBankPage();
        gmiBankPage.ilkGirişButonu.click();
        gmiBankPage.signInButonu.click();
    }

}
