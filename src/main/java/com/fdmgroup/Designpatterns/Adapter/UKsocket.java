package com.fdmgroup.Designpatterns.Adapter;

public class UKsocket implements IUKsocket {

	public String supplyPower(ThreePinPlug plug) {
		return "power supplied from UK socket";
	}

}
