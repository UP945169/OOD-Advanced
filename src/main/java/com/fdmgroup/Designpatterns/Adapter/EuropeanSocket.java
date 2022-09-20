package com.fdmgroup.Designpatterns.Adapter;

public class EuropeanSocket implements IEuropeanSocket {

	public String supplyPower(TwoPinPlug plug) {
		
		return "power supplied from european socket";
	}

}
