package com.bsandhu.model;

import java.util.Random;

public class Entity {

	private String legalName;
	private String id;
	private String parent;
	private Random random = new Random();

	public String getLegalName() {
		return "legalName " + random.nextInt();
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getId() {
		return String.valueOf(random.nextInt());
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParent() {
		return "Parent " + random.nextInt();
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

}
