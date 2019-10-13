package controller;

import dto.Address;
import facade.AddressFacade;

public class AddAddressController extends Controller{
	public boolean addAddress(String userId, String address, String state, String country, String zip) {
		try {
			AddressFacade thisAddrFacade = new AddressFacade();
			thisAddrFacade.setAddress(Integer.parseInt(userId), address, country, state, zip);

			return bc.addAddress(thisAddrFacade.getAddrData());
		}catch(Exception error) {
			return false;
		}
	}
}