package com.bsandhu.services;

import com.bsandhu.model.Trade;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TradeService {

    private Map<String, Trade> tradesCache = new HashMap<>();
    private Random keys = new Random();

    public boolean save(Trade trade) {
        tradesCache.put(String.valueOf(keys.nextInt(10000)), trade);
        return true;
    }

    public Trade getTrade(String id) {
        if (tradesCache.containsKey(id)) {
            return tradesCache.get(id);
        }
        return new Trade();
    }
}
