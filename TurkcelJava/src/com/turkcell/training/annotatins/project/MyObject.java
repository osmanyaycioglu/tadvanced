package com.turkcell.training.annotatins.project;

public class MyObject {
	@Random
	private String myStr1;
	@Random
	private String myStr2;
	@Random(max=20)
	private int myInt;
	@Random
	private double myDouble;
	public String getMyStr1() {
		return myStr1;
	}
	public void setMyStr1(String myStr1) {
		this.myStr1 = myStr1;
	}
	public String getMyStr2() {
		return myStr2;
	}
	public void setMyStr2(String myStr2) {
		this.myStr2 = myStr2;
	}
	public int getMyInt() {
		return myInt;
	}
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
	public double getMyDouble() {
		return myDouble;
	}
	public void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}
	
	
	@Override
	public String toString() {
		return "MyObject [myStr1=" + myStr1 + ", myStr2=" + myStr2 + ", myInt=" + myInt + ", myDouble=" + myDouble
				+ "]";
	}
	
	

}
