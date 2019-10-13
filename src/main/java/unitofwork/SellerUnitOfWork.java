package unitofwork;

import java.util.ArrayList;

import datasource.SellerMapper;
import dto.Seller;

public class SellerUnitOfWork {
	// user cannot be deleted, so no deleteUsers
	private ArrayList<Seller> newSellers;
	private ArrayList<Seller> dirtySellers;
	private SellerMapper sellerMapper;
	
	public SellerUnitOfWork() {

	    sellerMapper = new SellerMapper();
	}
    
    public boolean addSeller(Seller seller, boolean instantCommit) {
    	if(newSellers == null) {
    		newSellers = new ArrayList<>();
    	}
    	// add this seller in new list
    	newSellers.add(seller);
    	
    	// if need this change be committed to database instantly, set this boolean true
    	if(instantCommit) {
    		return this.doCommit()[0];
    	}
    	return true;
    }
    
    public boolean updateSeller(Seller seller, boolean instantCommit) {
    	if(dirtySellers == null) {
    		dirtySellers = new ArrayList<>();
    	}
    	// update a existing seller
    	dirtySellers.add(seller);
  	
    	// if need this change be committed to database instantly, set this boolean true
    	if(instantCommit) {
    		return this.doCommit()[1];
    	}    	
    	return true;
    }
    
    // get a seller by id
    public Seller getSellerById(int id) {  	
    	Seller thisSeller = sellerMapper.getSellerById(id);
    	return thisSeller;
    }
    
    public boolean changeIncome(int sellerId, float money) {
    	return sellerMapper.changeIncome(sellerId, money);
    }
    
    // commit change to database
    public boolean[] doCommit() {
    	boolean isNewSuccess = true;
    	boolean isUpdateSuccess = true;
    	if(newSellers != null) {
    		if(newSellers.size() > 0) {
    			if(sellerMapper.insert(newSellers)) {
    				newSellers.clear();
    			}
    			else {
    				isNewSuccess = false;
    			}
    		}
    	}
    	
    	if(dirtySellers != null) {
    		if(dirtySellers.size() > 0) {
    			if(sellerMapper.update(dirtySellers)) {
    				dirtySellers.clear();
    			}
    			else {
    				isUpdateSuccess = false;
    			}
    		}
    	}
    	
    	return new boolean[] {isNewSuccess, isUpdateSuccess};
    }
    	    
}
