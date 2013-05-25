package com.bsandhu.tests.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/25/13
 * Time: 9:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class TradeBlotterDriver {

    private RemoteWebDriver driver;

    public TradeBlotterDriver(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void assertCounterpartyInTable(String counterParty) {
        WebElement table = driver.findElement(By.id("tradeBlotterView.table"));
        String xpathExpr = String.format(".//tbody/tr/td[.='%s']", counterParty);
        List<WebElement> cells = table.findElements(By.xpath(xpathExpr));
        assertTrue(cells.size() == 1);
        assertEquals(counterParty + "not found in trade blotter", cells.get(0).getText(), counterParty);
    }
}
