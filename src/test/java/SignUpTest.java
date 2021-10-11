import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    @Test
    public void TestRegistration() {

        driver.get("https://www.doordash.com/");

        WebElement signUn = driver.findElement(By.xpath("//*[@id='__next']/div[2]/div[1]/div/div[1]/div[5]/div/button[2]"));
        signUn.click();

        WebElement firstName = driver.findElement(By.xpath("//*[@id='FieldWrapper-6']"));
        firstName.sendKeys("Michael");

        WebElement lastName = driver.findElement(By.xpath("//*[@id='FieldWrapper-7']"));
        lastName.sendKeys("Jackson");

        WebElement email = driver.findElement(By.xpath("//*[@id='FieldWrapper-8']"));
        email.sendKeys("abc@gmail.com");

        WebElement mobileNumber = driver.findElement(By.xpath("//*[@id='FieldWrapper-10']"));
        mobileNumber.sendKeys("1234567898");

        WebElement password = driver.findElement(By.xpath("//*[@id='FieldWrapper-11']"));
        password.sendKeys("qaz456");

        WebElement signUpButton = driver.findElement(By.xpath("//*[@id='sign-up-submit-button']"));
        signUpButton.click();

        WebElement error = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[6]/div/div/div/span"));
        Assert.assertEquals(error.getText(), "The email address you entered is already associated with an account. Sign in to your account or enter a different email to create a new account.");
    }
}
