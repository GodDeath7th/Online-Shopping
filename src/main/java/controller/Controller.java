package controller;

import domainlogic.BehaviorConductor;

public class Controller {
	public BehaviorConductor bc;
	public String fixOutputlength(int fixLength, String rawStr) {
		String appendStr = "";
		if(rawStr.length() < fixLength) {
			for(int i=0; i< (fixLength-rawStr.length()); i++) {
				appendStr = appendStr + " ";
			}
		}
		else {
			rawStr = rawStr.substring(0, fixLength-3) + "...";
		}
		return rawStr+appendStr;
	}
	
	public void initializeBehaviorConductor(BehaviorConductor bc) {
		this.bc = bc;
	}
	
	public BehaviorConductor getBehaviorConductor() {
		return bc;
	}
}
