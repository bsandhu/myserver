package com.bsandhu.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Trade {

    private int quantity;
    private int trancheId;
    private Date tradeDate;
    private String entryDate;
    private int counterParty;
    private String bookName;
    private int notes;
    private int price;
    private int buySell;

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTrancheId() {
        return trancheId;
    }

    public void setTrancheId(int trancheId) {
        this.trancheId = trancheId;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public int getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(int counterParty) {
        this.counterParty = counterParty;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNotes() {
        return notes;
    }

    public void setNotes(int notes) {
        this.notes = notes;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBuySell() {
        return buySell;
    }

    public void setBuySell(int buySell) {
        this.buySell = buySell;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "quantity=" + quantity +
                ", trancheId=" + trancheId +
                ", tradeDate='" + tradeDate + '\'' +
                ", entryDate='" + entryDate + '\'' +
                ", counterParty=" + counterParty +
                ", bookName=" + bookName +
                ", notes=" + notes +
                ", price=" + price +
                ", buySell=" + buySell +
                '}';
    }
}
