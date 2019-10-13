package facade;

import dto.Address;

public class AddressFacade {
	private Address addr;
	public void setAddress(int userId, String address, String country, String state, String zip) {
		if(addr == null) {
			addr = new Address();
		}
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

