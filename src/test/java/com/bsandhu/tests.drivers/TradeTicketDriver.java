package com.bsandhu.tests.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keyboard;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import junit.framework.Assert;

import java.util.Date;

public class TradeTicketDriver {

    private RemoteWebDriver driver;

    public TradeTicketDriver(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void setCounterParty(String name) {
        WebElement cp = driver.findElement(By.id("ticketView.Counterparty"));
        cp.clear();
        cp.sendKeys("JP Morgan");
    }

    public void save() {
        WebElement element = driver.findElement(By.id("ticketView.saveTicket"));
        element.click();
    }

    public void assertSuccess() {
        WebElement statusDiv = driver.findElement(By.id("ticketView.status"));
        Assert.assertTrue("Status div not visible", statusDiv.isDisplayed());
        Assert.assertEquals(statusDiv.getText(), "success X");
    }

    public void setQuantity(int qty) {
        WebElement qtyField = driver.findElementById("ticketView.Quantity");
        qtyField.clear();
        qtyField.sendKeys(String.valueOf(qty));
    }

    public void setTradeDate(String date) throws InterruptedException {
        Keyboard keyboard = driver.getKeyboard();
        WebElement dateField = driver.findElement(By.id("ticketView.TradeDate"));
        dateField.sendKeys(date);
        keyboard.pressKey(Keys.ESCAPE);
        keyboard.releaseKey(Keys.ESCAPE);
    }
}
