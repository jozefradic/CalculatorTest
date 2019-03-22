import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;



public class SeleniumTest {

    @Test
    public void Test(){

        System.setProperty("webdriver.chrome.driver","src\\main\\java\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://www.mortgageloan.com/calculator");
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.id("calculator_widget_amount")).click();
        chromeDriver.findElement(By.id("calculator_widget_amount")).sendKeys("200000");
        chromeDriver.findElement(By.id("calculator_widget_interest")).click();
        chromeDriver.findElement(By.id("calculator_widget_interest")).sendKeys("5.0");
        chromeDriver.findElement(By.id("calculator_widget_Length")).click();
        chromeDriver.findElement(By.id("calculator_widget_Length")).sendKeys("30");
        chromeDriver.findElement(By.id("calculator_widget_HomeValue")).click();
        chromeDriver.findElement(By.id("calculator_widget_HomeValue")).sendKeys("235000");
        chromeDriver.findElement(By.xpath("//*[@id=\"wizard-pager\"]/li[2]/a")).click();
        chromeDriver.findElement(By.id("calculator_widget_PropertyTaxes")).click();
        chromeDriver.findElement(By.id("calculator_widget_PropertyTaxes")).sendKeys("2000");
        chromeDriver.findElement(By.id("calculator_widget_Insurance")).click();
        chromeDriver.findElement(By.id("calculator_widget_Insurance")).sendKeys("1865");
        chromeDriver.findElement(By.id("calculator_widget_PMI")).click();
        chromeDriver.findElement(By.id("calculator_widget_PMI")).sendKeys("0.52");
        chromeDriver.findElement(By.xpath("//*[@id=\"wizard-pager\"]/li[5]/a")).click();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String result= chromeDriver.findElement(By.xpath("//th[contains(text(),'Monthly Principal & Interests')]/following-sibling::td")).getText();
        Assert.assertEquals(result,"$1,073.64");
        String result2= chromeDriver.findElement(By.xpath("//th[contains(text(),'Loan To Value Ratio')]/following-sibling::td")).getText();
        Assert.assertEquals(result2,"85.11%");
        String result3= chromeDriver.findElement(By.xpath("//th[contains(text(),'Total Monthly Payments')]/following-sibling::td")).getText();
        Assert.assertEquals(result3,"$1,482.39");

    }
}
