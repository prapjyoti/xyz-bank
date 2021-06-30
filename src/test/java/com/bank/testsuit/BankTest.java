package com.bank.testsuit;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankTest extends TestBase {


    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        accountPage = new AccountPage();

    }

    @Test(priority = 0, groups = {"smoke", "sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginLink();
        //click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddToCustomerLink();
        //enter FirstName
        addCustomerPage.enterFirstNameField("Shivansh");
        //enter LastName
        addCustomerPage.enterListNameField("Doshi");
        //enter PostCode
        addCustomerPage.enterPostCodeField("Ha0 1BJ");
        Thread.sleep(1000);
        addCustomerPage.clickOnAddToCustomerButton();
        Thread.sleep(1000);
        String actualMessage = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage.contains("Customer added successfully"));
        Thread.sleep(500);
        addCustomerPage.clickOnPopUpButton();

        homePage.clickOnHomePage();


    }

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {

        homePage.clickOnBankManagerLoginLink();

        bankManagerLoginPage.clickOnAddToCustomerLink();
        //enter FirstName
        addCustomerPage.enterFirstNameField("Shivansh");
        //enter LastName
        addCustomerPage.enterListNameField("Doshi");
        //enter PostCode
        addCustomerPage.enterPostCodeField("Ha0 1BJ");
        Thread.sleep(1000);
        addCustomerPage.clickOnAddToCustomerButton();
        Thread.sleep(1000);
        String actualMessage = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage.contains("Customer added successfully"));
        Thread.sleep(500);
        addCustomerPage.clickOnPopUpButton();
        bankManagerLoginPage.clickOnOpenAccountTab();
        Thread.sleep(500);
        openAccountPage.selectExistingCustomerNameFromDropdown(6);
        openAccountPage.selectCurrencyFromList(2);
        openAccountPage.clickOnProcessButton();
        Thread.sleep(500);
        String actualMessage1 = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage1.contains("Account created successfully"));

        addCustomerPage.clickOnPopUpButton();
    }

    @Test(priority = 2, groups = {"regression"})
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginLink();
        //click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddToCustomerLink();
        //enter FirstName
        addCustomerPage.enterFirstNameField("Shivansh");
        //enter LastName
        addCustomerPage.enterListNameField("Doshi");
        //enter PostCode
        addCustomerPage.enterPostCodeField("Ha0 1BJ");
        Thread.sleep(1000);
        addCustomerPage.clickOnAddToCustomerButton();
        Thread.sleep(1000);
        String actualMessage = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage.contains("Customer added successfully"));
        Thread.sleep(500);
        addCustomerPage.clickOnPopUpButton();

        bankManagerLoginPage.clickOnOpenAccountTab();
        Thread.sleep(500);
        openAccountPage.selectExistingCustomerNameFromDropdown(6);
        openAccountPage.selectCurrencyFromList(2);
        openAccountPage.clickOnProcessButton();
        Thread.sleep(500);
        String actualMessage1 = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage1.contains("Account created successfully"));

        addCustomerPage.clickOnPopUpButton();

        homePage.clickOnHomePage();
        homePage.clickOnCustomerLoginLink();
        Thread.sleep(500);
        openAccountPage.selectExistingCustomerNameFromDropdown(6);
        customerLoginPage.clickOnLoginLink();
        customerLoginPage.verifyLogoutButtonDisplayed();
        String expectedText = "Logout";
        String actualText = customerLoginPage.getLogOutText();
        Assert.assertEquals(actualText, expectedText);
        Thread.sleep(500);
        customerLoginPage.clickOnLogOutButton();
        customerLoginPage.verifyTextYourName("Your Name");
        String expectedVerify = "Your Name :";
        String actualVerify = customerLoginPage.verifyToGetYourNameText();
        Assert.assertEquals(actualVerify, expectedVerify);
        homePage.clickOnHomePage();


    }

    @Test(priority = 3, groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {


        homePage.clickOnBankManagerLoginLink();

        bankManagerLoginPage.clickOnAddToCustomerLink();
        //enter FirstName
        addCustomerPage.enterFirstNameField("Shivansh");
        //enter LastName
        addCustomerPage.enterListNameField("Doshi");
        //enter PostCode
        addCustomerPage.enterPostCodeField("Ha0 1BJ");
        Thread.sleep(1000);
        addCustomerPage.clickOnAddToCustomerButton();
        Thread.sleep(1000);
        String actualMessage = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage.contains("Customer added successfully"));
        Thread.sleep(500);
        addCustomerPage.clickOnPopUpButton();
        bankManagerLoginPage.clickOnOpenAccountTab();
        Thread.sleep(500);
        openAccountPage.selectExistingCustomerNameFromDropdown(6);
        openAccountPage.selectCurrencyFromList(2);
        openAccountPage.clickOnProcessButton();
        Thread.sleep(500);
        String actualMessage1 = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage1.contains("Account created successfully"));

        addCustomerPage.clickOnPopUpButton();

        homePage.clickOnHomePage();
        homePage.clickOnCustomerLoginLink();
        Thread.sleep(500);
        openAccountPage.selectExistingCustomerNameFromDropdown(6);
        customerLoginPage.clickOnLoginLink();
        accountPage.clickOnDepositTab();
        accountPage.depositMoney(100);
        accountPage.clickOnDepositDepositTab();

        String expectedMessage2 = "Deposit Successful";
        String actualMessage2 = accountPage.getMessageToVerifyDeposit();
        Assert.assertEquals(actualMessage2, expectedMessage2);
        homePage.clickOnHomePage();

    }

    @Test(priority = 4, groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {

        homePage.clickOnBankManagerLoginLink();

        bankManagerLoginPage.clickOnAddToCustomerLink();
        //enter FirstName
        addCustomerPage.enterFirstNameField("Shivansh");
        //enter LastName
        addCustomerPage.enterListNameField("Doshi");
        //enter PostCode
        addCustomerPage.enterPostCodeField("Ha0 1BJ");
        Thread.sleep(1000);
        addCustomerPage.clickOnAddToCustomerButton();
        Thread.sleep(1000);
        String actualMessage = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage.contains("Customer added successfully"));
        Thread.sleep(500);
        addCustomerPage.clickOnPopUpButton();
        bankManagerLoginPage.clickOnOpenAccountTab();
        Thread.sleep(500);
        openAccountPage.selectExistingCustomerNameFromDropdown(6);
        openAccountPage.selectCurrencyFromList(2);
        openAccountPage.clickOnProcessButton();
        Thread.sleep(500);
        String actualMessage1 = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage1.contains("Account created successfully"));

        addCustomerPage.clickOnPopUpButton();

        homePage.clickOnHomePage();
        homePage.clickOnCustomerLoginLink();
        Thread.sleep(500);
        openAccountPage.selectExistingCustomerNameFromDropdown(6);
        customerLoginPage.clickOnLoginLink();
        accountPage.clickOnDepositTab();
        accountPage.depositMoney(100);
        accountPage.clickOnDepositDepositTab();

        String expectedMessage2 = "Deposit Successful";
        String actualMessage2 = accountPage.getMessageToVerifyDeposit();
        Assert.assertEquals(actualMessage2, expectedMessage2);

        Thread.sleep(500);
        accountPage.clickToWithdrawalButton();
        Thread.sleep(500);
        accountPage.enterWithdrawalAmount(50);
        accountPage.clickOnWithdrawalFinalTab();
        String expectedMessage3 = "Transaction successful";
        String actualMessage3 = accountPage.getMessageToVerifyTransaction();
        Assert.assertEquals(actualMessage3, expectedMessage3);


    }
}





