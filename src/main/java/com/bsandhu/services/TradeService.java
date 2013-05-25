package com.bsandhu.services;

import com.bsandhu.dao.TradeDao;
import com.bsandhu.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeDao tradeDao;

    public boolean save(Trade trade) {
        return tradeDao.save(trade);
    }

    public Trade getTrade(String id) {
        return tradeDao.getTrade(id);
    }

    public List<Trade> getAllTrades() throws IOException, ParseException {
        return tradeDao.getAllTrades();
    }
}
