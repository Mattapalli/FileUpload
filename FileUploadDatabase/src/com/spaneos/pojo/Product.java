package com.spaneos.pojo;

public class Product {

	private int id;
	private String KEYWORD;
	private int TOTAL_COUNT;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getKEYWORD() {
		return KEYWORD;
	}


	public void setKEYWORD(String kEYWORD) {
		KEYWORD = kEYWORD;
	}


	public int getTOTAL_COUNT() {
		return TOTAL_COUNT;
	}


	public void setTOTAL_COUNT(int tOTAL_COUNT) {
		TOTAL_COUNT = tOTAL_COUNT;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", KEYWORD=" + KEYWORD + ", TOTAL_COUNT="
				+ TOTAL_COUNT + "]";
	}
	
	

}
