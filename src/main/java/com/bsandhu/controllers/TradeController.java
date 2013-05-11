package com.bsandhu.controllers;

import com.bsandhu.model.Trade;
import com.bsandhu.services.TradeService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/trade")
public class TradeController {

    static Logger logger = Logger.getLogger(ClientController.class);
    private TradeService service;

    @Autowired
    public TradeController(TradeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String list(@PathVariable("id") String id) {
        logger.info("Trade info for: " + id);
        Trade trade = service.getTrade(id);

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(trade);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }


}
