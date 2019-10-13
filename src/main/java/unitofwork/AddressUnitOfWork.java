package unitofwork;

import java.util.ArrayList;

import datasource.AddressMapper;
import dto.Address;

public class AddressUnitOfWork {
	private ArrayList<Address> newAddresses;
	private ArrayList<Address> dirtyAddresses;
	private ArrayList<Address> deleteAddresses;
	private AddressMapper addressMapper;
	
	public AddressUnitOfWork() {
		addressMapper = new AddressMapper();
	}
	
	public boolean addAddress(Address address, boolean instantCommit) {
		if(newAddresses == null) {
			newAddresses = new ArrayList<>();
		}
		newAddresses.add(address);
		
		if(instantCommit) {
			return doCommit()[0];
		}
		return true;
	}
	
	public boolean updateAddress(Address address, boolean instantCommit) {
		if(dirtyAddresses == null) {
			dirtyAddresses = new ArrayList<>();
		}
		dirtyAddresses.add(address);

		if(instantCommit) {
			return doCommit()[1];
		}
		return true;
	}
	
	public boolean deleteAddress(Address address, boolean instantCommit) {
		if(deleteAddresses == null) {
			deleteAddresses = new ArrayList<>();
		}
		
		deleteAddresses.add(address);
		
		if(instantCommit) {
			return doCommit()[2];
		}
		
		return true;
	}
	
	public ArrayList<Address> getAddressesByUserId(int userId){
		return addressMapper.getAddressByUserId(userId);
	}
	
	public boolean[] doCommit() {
		boolean isNewSuccess = true;
		boolean isUpdateSuccess = true;
		boolean isDeleteSuccess = true;
		
		if(newAddresses != null) {
			if(newAddresses.size() > 0) {
				if(addressMapper.insert(newAddresses)){
					newAddresses.clear();
				}
				else {
					isNewSuccess = false;
				}
			}
		}
		if(dirtyAddresses != null) {
			if(dirtyAddresses.size() > 0) {
				if(addressMapper.update(dirtyAddresses)) {
					dirtyAddresses.clear();
				}
				else {
					isUpdateSuccess = true;
				}
			}
		}
		if(deleteAddresses != null) {
			if(deleteAddresses.size() > 0 ) {
				if(addressMapper.delete(deleteAddresses)) {
					deleteAddresses.clear();
				}
				else {
					isDeleteSuccess = false;
				}
			}
		}
		
		return new boolean[] {isNewSuccess, isUpdateSuccess, isDeleteSuccess};
	}
}
