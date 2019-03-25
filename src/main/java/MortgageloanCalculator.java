import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MortgageloanCalculator extends PageObject{

    @FindBy(id="calculator_widget_amount")
    private WebElement amount;

    @FindBy(id="calculator_widget_interest")
    private WebElement interest;

    @FindBy(id="calculator_widget_Length")
    private WebElement length;

    @FindBy(id="calculator_widget_HomeValue")
    private WebElement homeValue;

    @FindBy(xpath="//*[@id=\"wizard-pager\"]/li[2]/a")
    private WebElement buttonNext;

    @FindBy(id="calculator_widget_PropertyTaxes")
    private WebElement propertyTaxes;

    @FindBy(id="calculator_widget_Insurance")
    private WebElement insurance;

    @FindBy(id="calculator_widget_PMI")
    private WebElement pmi;

    @FindBy(xpath="//*[@id=\"wizard-pager\"]/li[5]/a")
    private WebElement buttonSubmit;

    @FindBy(xpath="//th[contains(text(),'Monthly Principal & Interests')]/following-sibling::td")
    private  WebElement monthlyPrincipal;

    @FindBy(xpath="//th[contains(text(),'Loan To Value Ratio')]/following-sibling::td")
    private WebElement loanValue;

    @FindBy(xpath="//th[contains(text(),'Total Monthly Payments')]/following-sibling::td" )
    private WebElement monthlyPayments;


    public MortgageloanCalculator(WebDriver driver){
        super(driver);
    }

    public void firstPage(String amount, String interest,String length,String homeValue){
        this.amount.clear();
        this.amount.sendKeys(amount);

        this.interest.clear();
        this.interest.sendKeys(interest);

        this.length.clear();
        this.length.sendKeys(length);

        this.homeValue.clear();
        this.homeValue.sendKeys(homeValue);

        this.buttonNext.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void secondPage(String propertyTaxes, String insurance, String pmi){
        this.propertyTaxes.clear();
        this.propertyTaxes.sendKeys(propertyTaxes);

        this.insurance.clear();
        this.insurance.sendKeys(insurance);

        this.pmi.clear();
        this.pmi.sendKeys(pmi);

        this.buttonSubmit.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public List<String> result(){

        List<String> result = new ArrayList<String>();
        result.add(this.monthlyPrincipal.getText());
        result.add(this.monthlyPayments.getText());
        result.add(this.loanValue.getText());
        return result;

    }
}


