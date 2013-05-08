package com.bsandhu.model;

import java.util.Date;
import java.util.Random;

public class Instrument {

	private String name;
	private Date issue;
	private long amount;
	private Date maturity;
	private Random random = new Random();

	public String getName() {
		return "Instrument:" + random.nextInt(1000);
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getIssue() {
		return new Date();
	}

	public void setIssue(Date issue) {
		this.issue = issue;
	}

	public long getAmount() {
		return (long) random.nextDouble();
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getMaturity() {
		return new Date();
	}

	public void setMaturity(Date maturity) {
		this.maturity = maturity;
	}

}
