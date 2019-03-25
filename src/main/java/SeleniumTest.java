import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest extends FunctionalTest {

    @Test
    public void Test(){
        driver.get("https://www.mortgageloan.com/calculator");

        MortgageloanCalculator mortgageloanCalculator = new MortgageloanCalculator(driver);
        mortgageloanCalculator.firstPage("200,000","5.0","30","235,000");

        mortgageloanCalculator.secondPage("2,000","1,865","0.52");

        Assert.assertEquals(mortgageloanCalculator.result().get(0),"$1,073.64");
        Assert.assertEquals(mortgageloanCalculator.result().get(1),"$1,482.39");
        Assert.assertEquals(mortgageloanCalculator.result().get(2),"85.11%");

    }
}
