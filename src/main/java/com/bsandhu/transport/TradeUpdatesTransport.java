package com.bsandhu.transport;

import org.apache.log4j.Logger;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Meteor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class TradeUpdatesTransport {

    private static final Logger logger = Logger.getLogger(TradeUpdatesTransport.class);

    @RequestMapping(value = "/trades/updates", method = RequestMethod.GET)
    @ResponseBody
    public void tradeUpdates(HttpServletRequest req, HttpServletResponse res) throws InterruptedException {
        Meteor m = Meteor.build(req);
        AtmosphereResource resource = m.getAtmosphereResource();
        AtmosphereUtils.suspend(resource);
    }

    @RequestMapping(value = "/trades/doupdate", method = RequestMethod.GET)
    @ResponseBody
    public void doUpdate(HttpServletRequest req, HttpServletResponse res) throws InterruptedException {
        AtmosphereUtils.lookupBroadcaster().broadcast("Hello foo");
        logger.info("Broascasting..");

    }
}