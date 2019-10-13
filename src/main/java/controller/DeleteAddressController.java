package controller;

import dto.Address;

public class DeleteAddressController extends Controller{
	public boolean deleteAddress(String addressId) {
		// delete a address by giving its id in database table
		Address thisAddr = new Address();
		thisAddr.setId(Integer.parseInt(addressId));
		return bc.deleteAddress(thisAddr);
	}
}