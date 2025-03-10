package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KpiPage {
    protected  WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//span[contains(text(),'Quản lý KPI')]")
     WebElement quanLyKPIButton;

    @FindBy(xpath = "//span[normalize-space()='KPI cá nhân']")
     WebElement kpiCaNhanButton;

    @FindBy(xpath = "//span[contains(text(),'Tiến độ thực hiện KPI cá nhân')]")
     WebElement tienDoKPIButton;

    @FindBy(xpath = "//span[normalize-space()='KPI cá nhân theo Month']")
     WebElement kpiCaNhanTheoThangButton;

    @FindBy(xpath = "//div[contains(text(),'Tiến độ thực hiện KPI cá nhân')]")
     WebElement tienDoKPITitle;

    @FindBy(xpath = "//div[contains(text(),'KPI cá nhân theo Month')]")
     WebElement kpiCaNhanTheoThangTitle;

    public KpiPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToTienDoKPI() {
        wait.until(ExpectedConditions.elementToBeClickable(quanLyKPIButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(kpiCaNhanButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tienDoKPIButton)).click();
    }

    public boolean isTienDoKPIDisplayed() {

        return wait.until(ExpectedConditions.elementToBeClickable(tienDoKPITitle)).isDisplayed();
    }

    public void navigateToKPICaNhanTheoThang() {
        wait.until(ExpectedConditions.elementToBeClickable(quanLyKPIButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(kpiCaNhanButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(kpiCaNhanTheoThangButton)).click();
    }


    public boolean isKPICaNhanTheoThangDisplayed() {

        return wait.until(ExpectedConditions.visibilityOf(kpiCaNhanTheoThangTitle)).isDisplayed();
    }
}
