package com.fdmgroup.Designpatterns.Adapter;

public interface IUKelectronicDevice {

	public void plugIn(IUKsocket socket);
	
	public void setPlug(ThreePinPlug plug); 
	
}
