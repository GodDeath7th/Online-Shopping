package controller;

import domainlogic.BehaviorConductor;
// parent class of all controller
public class Controller {
	public BehaviorConductor bc;
	// limit length of a string at most fixlength long by only leaving first-fixlength-long charactor if actual length of string exceeds
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
	
	// initialize behavior conductor to all controllers
	public void initializeBehaviorConductor(BehaviorConductor bc) {
		this.bc = bc;
	}
	
	// get behavior conductor
	public BehaviorConductor getBehaviorConductor() {
		return bc;
	}
}
