package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static  WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver();
    }

    @AfterClass
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
