package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    private static final Logger log = LogManager.getLogger(AddCustomerPage.class.getName());

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerButton;


    public void enterFirstNameField(String name) {
        Reporter.log("Enter first name : " + firstName + " to  first name field : " + firstName.toString() + "<br>");
        sendTextToElement(firstName, name);
        log.info("Enter first name  : " + firstName + " to first name  field : " + firstName.toString());
    }


    public void enterListNameField(String name) {
        Reporter.log("Enter last name : " + lastName + " to  last name field : " + lastName.toString() + "<br>");
        sendTextToElement(lastName, name);
        log.info("Enter  last name  : " + lastName + " to Last Name field : " + lastName.toString());

    }

    public void enterPostCodeField(String postcode) {
        Reporter.log("Enter postcode :  " + postcode + " to post code field : " + postCode.toString() + "<br>");
        sendTextToElement(postCode, postcode);
        log.info("Enter  postcode  : "  + postCode.toString());
    }

    public void clickOnAddToCustomerButton() {
        Reporter.log("click on Add to Button :" + addCustomerButton.toString() + "<br>");
        log.info("Click on Add to Button  : "  + addCustomerButton.toString());
        clickOnElement(addCustomerButton);


    }
    public String verifyPopUpMessage(){
        Alert alertDialog = driver.switchTo().alert();
        return alertDialog.getText();
    }
    public void  clickOnPopUpButton(){
        Alert alertDialogue = driver.switchTo().alert();
          alertDialogue.accept();
    }

}
