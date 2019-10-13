package controller;

import dto.Address;
import facade.AddressFacade;

public class UpdateAddressController extends Controller{
	// update address of a buyer
	public boolean updateAddress(String addrId, String addr, String state, String country, String zip) {
		AddressFacade addrFacade = new AddressFacade();
		addrFacade.setAddress(Integer.parseInt(addrId), addr, country, state, zip);
		
		return bc.updateAddress(addrFacade.getAddrData());
	}
}