package controller;

import facade.AddressFacade;

public class AddAddressController extends Controller{
    // controller for adding address for a buyer
	public boolean addAddress(String userId, String address, String state, String country, String zip) {
		    // generate address facade object
			AddressFacade thisAddrFacade = new AddressFacade();
			thisAddrFacade.setAddress(Integer.parseInt(userId), address, country, state, zip);
            
			// invoking behavior conductor to add address, return true if success
			return bc.addAddress(thisAddrFacade.getAddrData());
	}
}