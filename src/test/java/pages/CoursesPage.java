package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CoursesPage {
    public WebDriver driver;

    public CoursesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="user[first_name]")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement signUpbutton;

    @FindBy(id = "user[email]")
    public WebElement validateEmail;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//p[@class='message-text']")
    public WebElement sıgnedInSuccessfully;

    @FindBy(xpath ="/html/body/header/div/div/section[1]/ul/li")
    public WebElement dropDownButton;

    @FindBy(partialLinkText = "Sign Out")
    public WebElement signOutButton;
}
