package controller;

import dto.Address;

public class DeleteAddressController extends Controller{
	public boolean deleteAddress(String addressId) {
		Address thisAddr = new Address();
		thisAddr.setId(Integer.parseInt(addressId));
		return bc.deleteAddress(thisAddr);
	}
}