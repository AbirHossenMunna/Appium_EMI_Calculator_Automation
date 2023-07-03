package Screens;

import base.Setup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EMIScreen {
    @FindBy(id = Setup.PACKAGE_ID + ":id/btnStart")
    public AndroidElement btnStart;
    @FindBy(id = Setup.PACKAGE_ID + ":id/etLoanAmount")
    AndroidElement txtLoanAmount;
    @FindBy(id = Setup.PACKAGE_ID + ":id/etInterest")
    AndroidElement txtInterest;
    @FindBy(id = Setup.PACKAGE_ID + ":id/etYears")
    AndroidElement txtPeriod;
    @FindBy(id = Setup.PACKAGE_ID + ":id/etFee")
    AndroidElement txtProcessingFee;
    @FindBy(id = Setup.PACKAGE_ID + ":id/btnCalculate")
    AndroidElement btnCalculate;

    @FindBy(id = Setup.PACKAGE_ID + ":id/btnDetail")
    AndroidElement btnDetail;
    @FindBy(id = Setup.PACKAGE_ID + ":id/btnReset")
    public AndroidElement btnReset;
    @FindBy(id = Setup.PACKAGE_ID + ":id/alertTitle")
    AndroidElement warningAlert;
    @FindBy(id = "android:id/message")
    public AndroidElement warningMessage;
    @FindBy(id = "android:id/button2")
    public AndroidElement btnOk;
    @FindBy(id = Setup.PACKAGE_ID + ":id/monthly_emi_result")
    public AndroidElement monthlyEmiResult;
    @FindBy(id = Setup.PACKAGE_ID + ":id/total_interest_result")
    public AndroidElement interestResult;
    @FindBy(id = Setup.PACKAGE_ID + ":id/processing_fee_result")
    public AndroidElement ProcessingFeeResult;
    @FindBy(id = Setup.PACKAGE_ID + ":id/total_payment_result")
    public AndroidElement paymentResult;

    public EMIScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean emptyFields() {
        btnCalculate.click();
        return warningAlert.isDisplayed();
    }

    public void emiCalculation(int loanAmount, double interest, int period, double processingFee) {
        txtLoanAmount.sendKeys("" + loanAmount + "");
        txtInterest.sendKeys("" + interest + "");
        txtPeriod.sendKeys("" + period + "");
        txtProcessingFee.sendKeys("" + processingFee + "");
        btnCalculate.click();
    }
}
