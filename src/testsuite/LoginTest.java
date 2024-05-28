package testsuite;

import browserfactory.BaseTest;
import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
       // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement((By.id("password"))).sendKeys("SuperSecretPassword!");
        //* Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //* Verify the text “Secure Area”
       String actualText = driver.findElement(By.xpath("//h2[normalize-space()='Secure Area']")).getText();
        Assert.assertEquals("Secure Area",actualText);

    }
    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //* Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //* Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //* Verify the error message “Your username is invalid!”
        String expectedResult = "Your username is invalid!";
               String actualResult = driver.findElement(By.xpath("//div[@id='flash']")).getText().substring(0,25);
        Assert.assertEquals(expectedResult,actualResult);
    }
        @Test
        public void verifyThePasswordErrorMessage(){
            //* Enter “tomsmith” username
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            //* Enter “SuperSecretPassword” password
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
            //* Click on ‘LOGIN’ button
            driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();


            //* Verify the error message “Your password is invalid!”
            String expectedResult = "Your password is invalid!";
            String actualResult= driver.findElement(By.xpath("//div[@id='flash']")).getText().substring(0,25);
            Assert.assertEquals("User cannot login with invaild password",expectedResult,actualResult);

        }
    //    @After
//    public void tearDown() {
//        closeBrowser();
//    }

    }



