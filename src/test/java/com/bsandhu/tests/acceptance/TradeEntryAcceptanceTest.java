package com.bsandhu.tests.acceptance;

import com.bsandhu.tests.drivers.TradeBlotterDriver;
import com.bsandhu.tests.drivers.TradeTicketDriver;
import junit.framework.TestCase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class TradeEntryAcceptanceTest extends TestCase {

    private TradeTicketDriver ticketDriver;
    private TradeBlotterDriver blotterDriver;
    private RemoteWebDriver driver;

    @Override
    protected void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/test/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);

        driver.get("http://localhost:8080/myserver/resources/js/app/views/App.html");
        ticketDriver = new TradeTicketDriver(driver);
        blotterDriver = new TradeBlotterDriver(driver);
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
    }

    public void testEnteringNewTradeTicket() throws InterruptedException {
        ticketDriver.setQuantity(5000000);
        ticketDriver.setTradeDate("01-12-2012");
        ticketDriver.setCounterParty("JP Morgan Chase");
        ticketDriver.save();
        ticketDriver.assertSuccess();

        blotterDriver.assertCounterpartyInTable("Jaxworks");

    }

}
