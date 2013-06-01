package com.bsandhu.transport;

import com.bsandhu.model.Trade;
import com.bsandhu.services.TradeService;
import org.apache.log4j.Logger;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.Meteor;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Controller
public class TradeUpdatesTransport {

    private static final Logger logger = Logger.getLogger(TradeUpdatesTransport.class);
    private static final Random RANDOM = new Random();
    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    @Autowired
    private TradeService tradeService;

    @RequestMapping(value = "/trades/updates", method = RequestMethod.GET)
    @ResponseBody
    public void subscribeToTradeUpdates(HttpServletRequest req, HttpServletResponse res) throws InterruptedException {
        Meteor m = Meteor.build(req);
        AtmosphereResource resource = m.getAtmosphereResource();
        AtmosphereUtils.suspend(resource);
    }

    @RequestMapping(value = "/trades/stopUpdates", method = RequestMethod.GET)
    @ResponseBody
    public void stopUpdates() throws InterruptedException {
        executorService.shutdownNow();
        executorService = Executors.newScheduledThreadPool(1);
        logger.info("Stopped Broascasting..");
    }

    @RequestMapping(value = "/trades/startUpdates/{updateRate}", method = RequestMethod.GET)
    @ResponseBody
    public void startUpdates(@PathVariable("updateRate") final int updateRate) throws InterruptedException {
        final Broadcaster broadcaster = AtmosphereUtils.lookupBroadcaster();
        final ObjectMapper mapper = new ObjectMapper();

        stopUpdates();

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                logger.info("Broascasting @ " + updateRate + "/s");
                for (int i = 0; i < updateRate; i++) {
                    Trade trade = tradeService.getTrade(String.valueOf(RANDOM.nextInt(10000)));
                    try {
                        broadcaster.broadcast(mapper.writeValueAsString(trade));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }
}