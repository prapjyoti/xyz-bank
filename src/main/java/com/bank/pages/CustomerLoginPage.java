package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(CustomerLoginPage.class.getName());

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logOutButton;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement verifyText;

    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameTextVerify;


    public void clickOnLoginLink() {
        Reporter.log("click on login link:" + loginButton.toString() + "<br>");
        clickOnElement(loginButton);
        log.info("Click on login link  : " + loginButton.toString());

    }

    public void verifyLogoutButtonDisplayed() {
        Reporter.log("verify logout tab displayed:" + logOutButton.toString() + "<br>");
        verifyThatElementIsDisplayed(logOutButton);
        log.info("verify logout tab displayed  : " + logOutButton.toString());


    }

    public String getLogOutText() {

        Reporter.log("Verify Logout Text:" + logOutButton.toString() + "<br>");
        log.info("Verify Logout Text : " + logOutButton.toString());
        return getTextFromElement(logOutButton);

    }

    public void clickOnLogOutButton() {
        Reporter.log("click on logout button:" + logOutButton.toString() + "<br>");
        clickOnElement(logOutButton);
        log.info("click on logout button  : " + logOutButton.toString());

    }

    public void verifyTextYourName(String text) {
        Reporter.log("verify your name is displayed:" + yourNameTextVerify.toString() + "<br>");
        log.info("verify your name is displayed  : " + yourNameTextVerify.toString());
        verifyThatTextIsDisplayed(verifyText, text);

    }

    public String verifyToGetYourNameText() {
        Reporter.log("verify your name text:" + yourNameTextVerify.toString() + "<br>");
        log.info("verify your name text  : " + yourNameTextVerify.toString());
        return getTextFromElement(yourNameTextVerify);
    }
}
