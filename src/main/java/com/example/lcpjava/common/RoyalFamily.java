package com.example.lcpjava.common;

import java.util.ArrayList;
import java.util.List;

public class RoyalFamily {
	
	public String name;
	
	public boolean isDead;
	
	public List<RoyalFamily> childs;
	
	public RoyalFamily() {  }
	
	public RoyalFamily(String name) {
		this.name = name;
		this.isDead = false;
		this.childs = new ArrayList<>();
	}
	
}
