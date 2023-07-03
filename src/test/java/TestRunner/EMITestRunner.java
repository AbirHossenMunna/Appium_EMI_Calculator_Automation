package TestRunner;

import Dataset.Dataset;
import Screens.EMIScreen;
import base.Setup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EMITestRunner extends Setup {
    EMIScreen emiScreen;

    @BeforeTest
    public void emiCalculatorClick() throws InterruptedException {
        emiScreen = new EMIScreen(driver);
        emiScreen.btnStart.click();
        Thread.sleep(1000);
    }

    @Test(priority = 1, description = "Clicking on Calculate button without giving any data")
    public void emptyFields() throws InterruptedException {
        emiScreen = new EMIScreen(driver);
        boolean warningAlert = emiScreen.emptyFields();
        Assert.assertTrue(warningAlert);
        Assert.assertTrue(emiScreen.warningMessage.getText().contains("Please fill all the info for calculation"));
        emiScreen.btnOk.click();
        Thread.sleep(1000);
    }

    @Test(priority = 2, dataProvider = "data-provider-emi", dataProviderClass = Dataset.class)
    public void emiCalculation(int loanAmount, double interest, int period, double processingFee, double monthlyEmiResult, double interestResult, int ProcessingFeeResult, double paymentResult) {
        emiScreen = new EMIScreen(driver);
        emiScreen.emiCalculation(loanAmount, interest, period, processingFee);

        String emiMonthlyEmiResultActual = emiScreen.monthlyEmiResult.getText().replace(",", "");
        double interestResultActual = Double.parseDouble(emiScreen.interestResult.getText().replace(",", ""));
        String ProcessingFeeResultActual = emiScreen.ProcessingFeeResult.getText().replace(",", "");
        double paymentResultActual = Double.parseDouble(emiScreen.paymentResult.getText().replace(",", ""));

        String emiMonthlyEmiResultExpected = String.valueOf(monthlyEmiResult);
        double interestResultExpected = interestResult;
        String ProcessingFeeResultExpected = String.valueOf(ProcessingFeeResult);
        double paymentResultExpected = paymentResult;

        Assert.assertEquals(emiMonthlyEmiResultActual, emiMonthlyEmiResultExpected);
        Assert.assertEquals(interestResultActual, interestResultExpected);
        Assert.assertEquals(ProcessingFeeResultActual, ProcessingFeeResultExpected);
        Assert.assertEquals(paymentResultActual, paymentResultExpected);
    }

    @AfterMethod
    public void emiCalculatorReset() throws InterruptedException {
        emiScreen = new EMIScreen(driver);
        Thread.sleep(3000);
        emiScreen.btnReset.click();
        Thread.sleep(3000);
    }
}
