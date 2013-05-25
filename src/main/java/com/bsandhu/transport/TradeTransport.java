package com.bsandhu.transport;

import com.bsandhu.model.Trade;
import com.bsandhu.services.TradeService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trade")
public class TradeTransport {

    static Logger logger = Logger.getLogger(TradeTransport.class);
    private TradeService service;

    @Autowired
    public TradeTransport(TradeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/trades/{count}", method = RequestMethod.GET)
    public
    @ResponseBody
    String list(@PathVariable("count") int count) {
        logger.info("Listing trades");
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(service.getAllTrades().subList(0, count));
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
