package com.bsandhu.services;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	private String name = "Backend";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
