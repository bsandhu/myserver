package com.bsandhu.dao;

import au.com.bytecode.opencsv.CSVReader;
import com.bsandhu.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TradeDao {

    private final File csvFile;
    private Map<String, Trade> tradesCache = new HashMap<>();

    @Autowired
    public TradeDao(ResourceLoader ctx) throws IOException {
        this.csvFile = ctx.getResource("classpath:MockTradeData.csv").getFile();
    }

    public boolean save(Trade trade) {
        tradesCache.put(trade.getTradeId(), trade);
        return true;
    }

    public Trade getTrade(String id) {
        if (tradesCache.containsKey(id)) {
            return tradesCache.get(id);
        }
        throw new RuntimeException(String.format("Trade %s not found", id));
    }

    /**
     * Read from CSV data. CSV columns.
     * TradeId,CounterParty,Price,TradeDate,Quantity,EntryDate,Notes,BuySell,TrancheId,BookName,Active
     */
    public List<Trade> getAllTrades() throws IOException, ParseException {
        CSVReader reader = new CSVReader(new FileReader(csvFile));
        String[] nextLine;
        List<Trade> trades = new ArrayList<>(10000);
        reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
            Trade t = new Trade();

            t.setTradeId(nextLine[0]);
            t.setCounterParty(nextLine[1]);
            t.setPrice(Double.parseDouble(nextLine[2]));
            t.setTradeDate(formatter.parse(nextLine[3]));
            t.setQuantity(Double.parseDouble(nextLine[4]));
            t.setEntryDate(nextLine[5]);
            t.setNotes(nextLine[6]);
            t.setBuySell(nextLine[7]);
            t.setTrancheId(Integer.parseInt(nextLine[8]));
            t.setBookName(nextLine[9]);
            t.setActive(Boolean.parseBoolean(nextLine[10]));

            this.tradesCache.put(t.getTradeId(), t);
            trades.add(t);
        }
        return trades;
    }


}
