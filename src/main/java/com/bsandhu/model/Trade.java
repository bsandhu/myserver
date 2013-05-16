package com.bsandhu.model;

import java.util.Date;

public class Trade {

    private String tradeId;
    private double quantity;
    private int trancheId;
    private Date tradeDate;
    private String entryDate;
    private String counterParty;
    private String bookName;
    private String notes;
    private double price;
    private String buySell;
    private boolean isActive;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getTrancheId() {
        return trancheId;
    }

    public void setTrancheId(int trancheId) {
        this.trancheId = trancheId;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "quantity=" + quantity +
                ", trancheId=" + trancheId +
                ", tradeDate=" + tradeDate +
                ", entryDate='" + entryDate + '\'' +
                ", counterParty='" + counterParty + '\'' +
                ", bookName='" + bookName + '\'' +
                ", notes='" + notes + '\'' +
                ", price=" + price +
                ", buySell=" + buySell +
                ", isActive=" + isActive +
                '}';
    }
}
