package testsuite;
/**2. Create the package ‘testsuite’ and create the
 following class inside the ‘testsuite’ package.

 1. LoginTest

 3. Write down the following test into ‘LoginTest’ class

 1. userShouldNavigateToLoginPageSuccessfully

 * click on the ‘Sign In’ link
 * Verify the text ‘Welcome Back!’

 2. verifyTheErrorMessage

 * click on the ‘Sign In’ link
 * Enter invalid username
 * Enter invalid password
 * Click on Login button
 * Verify the error message ‘Invalid email or password
 *
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Click on Sign In link
        WebElement SignInButton = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        SignInButton.click();
        //Verify Welcome Back
        String expectedMessage = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheErrorMessage() {
        //Click on Sign In link
        WebElement SignInButton = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        SignInButton.click();
        // find the email in email field element
        WebElement emailField = driver.findElement(By.id("user[email]"));
        // Type the UserName in username field element
        emailField.sendKeys("Mick123@gmail.com");
        //Find the Password Field Element and send password on password field
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("mick123");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        loginbutton.click();
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
