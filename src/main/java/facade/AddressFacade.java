package facade;

import dto.Address;

public class AddressFacade {
	private Address addr = new Address();
	public void setAddress(int userId, String address, String country, String state, String zip) {
		addr.setUserId(userId);
		addr.setAddress(address);
		addr.setState(state);
		addr.setCountry(country);
		addr.setZip(zip);
	}
	
	public Address getAddrData() {
		return addr;
	}
}

