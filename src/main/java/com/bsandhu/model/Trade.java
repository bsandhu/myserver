package com.bsandhu.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Trade {

	private long quantity;
	private String id;
	private Date tradeDate;
	private Date entryDate;
	private List<Instrument> instruments;
	private Entity counterParty;
	private boolean isActive;
	private Random random = new Random();

	public boolean isActive() {
		return true;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public long getQuantity() {
		return random.nextInt(10000);
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getId() {
		return String.valueOf(random.nextInt(10000));
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTradeDate() {
		return new Date();
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Date getEntryDate() {
		return new Date();
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public List<Instrument> getInstruments() {
		return Arrays.asList(new Instrument(), new Instrument(),
				new Instrument());
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Entity getCounterParty() {
		return new Entity();
	}

	public void setCounterParty(Entity counterParty) {
		this.counterParty = counterParty;
	}

}
