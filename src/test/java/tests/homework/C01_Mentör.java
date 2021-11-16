package tests.homework;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CoursesPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

public class C01_Mentör {
@Test
    public void test(){

         /*  Open "https://courses.ultimateqa.com/users/sign_up"*/
        Driver.getDriver().get(ConfigReader.getProperty("coursesUrl"));
        CoursesPage coursesPage=new CoursesPage();

        /* create random and valid first name, last name, email and password, store for later validating*/
        /*  fill in account submission form with data above*/
          Actions actions=new Actions(Driver.getDriver());
          actions.sendKeys(coursesPage.firstNameBox, ConfigReader.getProperty("coursesFirstName")).
            sendKeys(Keys.TAB).
            sendKeys(ConfigReader.getProperty("coursesLastName")).
            sendKeys(Keys.TAB).
            sendKeys(ConfigReader.getProperty("coursesEmail")).
            sendKeys(Keys.TAB).
            sendKeys(ConfigReader.getProperty("coursesPassword")).
           //Click on checkbox with id="user[terms]" to agree with terms and conditions
           //click on "Sign up" button
            sendKeys(Keys.TAB).
            sendKeys(Keys.SPACE).perform();

            coursesPage.signUpbutton.click();
}
        @Test
        public void test2() throws InterruptedException {

        //go to https://courses.ultimateqa.com/account*/
        Driver.getDriver().get(ConfigReader.getProperty("coursesAccount"));
        CoursesPage coursesPage=new CoursesPage();

        //validate that first name, last name and email you provided earlier is correct
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(coursesPage.validateEmail, ConfigReader.getProperty("coursesEmail")).
                    sendKeys(Keys.TAB).
                    sendKeys(ConfigReader.getProperty("coursesPassword")).perform();
        coursesPage.signInButton.click();
            Assert.assertTrue(coursesPage.sıgnedInSuccessfully.isDisplayed());

         /* Part 2 (Optional)
         *  sign out of the website*/
            Thread.sleep(5000);
           Select select=new Select(coursesPage.dropDownButton);
           select.selectByVisibleText("Sign Out");



         /*  go to "https://courses.ultimateqa.com/users/sign_in"
         *  fill in sign in form with your stored email and password
         *  click on "Sign in" button
         *  validate that message "Signed in successfully." is displayed
         *
         * NOTE:Captcha on this website is un-avoidable,
         * so you will have to solve it by hand to allow script to continue
         **/

}}
