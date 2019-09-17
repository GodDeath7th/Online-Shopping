package serviceImp;

import daoImpl.AddressDaoImpl;
import entity.Address;
import service.AddressService;
import util.Util;

public class AddressServiceImpl implements AddressService {
    private AddressDaoImpl addressDao = new AddressDaoImpl();

    @Override
    public void addAddress(Address address) {
        address.setId(1);
        if(address.getIsDefault()==null){
            address.setIsDefault("2");
        }
        addressDao.addAddress(address);
    }
}
