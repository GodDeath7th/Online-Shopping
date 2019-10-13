package unitofwork;

import java.util.ArrayList;

import datasource.BuyerMapper;
import dto.Buyer;

public class BuyerUnitOfWork {
	// user cannot be deleted, so no deleteUsers
	private ArrayList<Buyer> newBuyers;
	private ArrayList<Buyer> dirtyBuyers;
	private BuyerMapper buyerMapper;
	
	public BuyerUnitOfWork() {
	    buyerMapper = new BuyerMapper();
	}
    
    public boolean addBuyer(Buyer buyer, boolean instantCommit) {
    	if(newBuyers == null) {
    		newBuyers = new ArrayList<>();
    	}
    	// add this buyer in new list
    	newBuyers.add(buyer);
    	
    	// if need this change be committed to database instantly, set this boolean true
    	if(instantCommit) {
    		return this.doCommit()[0];
    	}
    	return true;
    }
    
    public boolean updateBuyer(Buyer buyer, boolean instantCommit) {
    	if(dirtyBuyers == null) {
    		dirtyBuyers = new ArrayList<>();
    	}
    	// update a existing buyer
    	dirtyBuyers.add(buyer);
    	
    	// if need this change be committed to database instantly, set this boolean true
    	if(instantCommit) {
    		return this.doCommit()[1];
    	}    	
    	return true;
    }
    
    // get buyer by id
    public Buyer getBuyerById(int id) {
    	Buyer thisBuyer =  buyerMapper.getBuyerById(id);
    	return thisBuyer;
    }
    
    public boolean changeBalance(int buyerId, float money) {
    	return buyerMapper.changeBalance(buyerId, money);
    }
    
    public boolean hasEnoughBalance(int buyerId, float money) {
    	return buyerMapper.hasEnoughBalance(buyerId, money);
    }
    
    // commit change to database
    public boolean[] doCommit() {
    	boolean isNewSuccess = true;
    	boolean isUpdateSuccess = true;
    	if(newBuyers != null) {
    		if(newBuyers.size() > 0) {
    			if(buyerMapper.insert(newBuyers)) {
    				newBuyers.clear();
    			}
    			else {
    				isNewSuccess = false;
    			}
    		}
    	}
    	
    	if(dirtyBuyers != null) {
    		if(dirtyBuyers.size() > 0) {
    			if(buyerMapper.update(dirtyBuyers)) {
    				dirtyBuyers.clear();
    			}
    			else {
    				isUpdateSuccess = false;
    			}
    		}
    	}
    	
    	return new boolean[] {isNewSuccess, isUpdateSuccess};
    }
    	    
}
