package com.visa.prj.entity;

public class TV extends Product 
{
	private String screenType;

	public TV(int id, String name, double price, String screenType) {
		super(id, name, price);
		this.screenType = screenType;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public TV() {
	}

	@Override
	public boolean isExpensive() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
}
