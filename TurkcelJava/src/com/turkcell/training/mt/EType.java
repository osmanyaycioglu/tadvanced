package com.turkcell.training.mt;

public enum EType {
	A1("str1") {
		@Override
		public String hello() {
			return "hello from A1";
		}
		
	},A2("sjdj"),DENEME("drewr");
	
	
	private String str;

	private EType(String str) {
		this.str = str;
		
	}
	
	public String hello() {
		return "hello";
	}
	
}
