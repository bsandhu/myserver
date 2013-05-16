package com.bsandhu.controllers;

import com.bsandhu.model.Trade;
import com.bsandhu.services.TradeService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/trade")
public class TradeController {

    static Logger logger = Logger.getLogger(ClientController.class);
    private TradeService service;

    @Autowired
    public TradeController(TradeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/trades", method = RequestMethod.GET)
    public
    @ResponseBody
    String list() {
        logger.info("Listing trades");
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(service.getAllTrades());
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @RequestMapping(value="save", method=RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody String save(@RequestBody Trade bean) {
        logger.info("Saving trade: " + bean);
        return "100";
    }


}
