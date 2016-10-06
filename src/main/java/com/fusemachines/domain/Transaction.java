package com.fusemachines.domain;

public class Transaction {
	
	private int id;
	private String name;
	private boolean verify;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean getVerify() {
		return verify;
	}
	
	public void setVerify(boolean verify) {
		this.verify = verify;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Transaction(int id, String name, boolean verify){
		this.id = id;
		this.name = name;
		this.verify = verify;
	}

}
