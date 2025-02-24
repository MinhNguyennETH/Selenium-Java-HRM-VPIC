package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KpiPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[contains(text(),'Quản lý KPI')]")
    private WebElement quanLyKPIButton;

    @FindBy(xpath = "//span[normalize-space()='KPI cá nhân']")
    private WebElement kpiCaNhanButton;

    //-------------TIEN DO THUC HIEN KPI CA NHAN----------------------------------------------------------
    @FindBy(xpath = "//span[contains(text(),'Tiến độ thực hiện KPI cá nhân')]")
    private WebElement tienDoKPIButton;

    @FindBy(xpath = "//div[contains(text(),'Tiến độ thực hiện KPI cá nhân')]")
    private WebElement tienDoKPITitle;


    //----------------KPI CA NHAN THEO MONTH -------------------------------------------------------------
    @FindBy(xpath = "//span[normalize-space()='KPI cá nhân theo Month']")
    private WebElement kpiCaNhanTheoThangButton;

    @FindBy(xpath = "//div[contains(text(),'KPI cá nhân theo Month')]")
    private WebElement kpiCaNhanTheoThangTitle;

    @FindBy(xpath = "//span[@id='select2-chosen-1']")
    private WebElement SelectButton;

    @FindBy(xpath = "//input[@id='s2id_autogen1_search']")
    private WebElement inputSearch;

    @FindBy(xpath = "//i[@class='view-details fa fa-pencil-square-o']")
    private WebElement ViewKPI;

    @FindBy(xpath = "//span[@id='ui-id-1']")
    private WebElement Verify;


    //-----------------------------------------------------------------------------------------------------

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
        wait.until(ExpectedConditions.elementToBeClickable(SelectButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch)).sendKeys("2024", Keys.ENTER);
        
        wait.until(ExpectedConditions.elementToBeClickable(ViewKPI)).click();

    }


    public boolean VerifyKpiCaNhanTheoMonth() {
        return wait.until(ExpectedConditions.visibilityOf(Verify)).isDisplayed();
    }
}
