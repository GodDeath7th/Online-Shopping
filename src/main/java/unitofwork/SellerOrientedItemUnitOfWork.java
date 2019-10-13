package unitofwork;

import java.util.ArrayList;

import datasource.ItemMapper;
import dto.SellerOrientedItem;

/* 
 * this class manages create query update and delete operation for "item" object in "entity" package 
 */
public class SellerOrientedItemUnitOfWork{

    private ArrayList<SellerOrientedItem> newSellerItems;
    private ArrayList<SellerOrientedItem> dirtySellerItems;
    private ArrayList<SellerOrientedItem> deleteSellerItems;
    private ItemMapper itemMapper; 

    public SellerOrientedItemUnitOfWork() {
    	itemMapper = new ItemMapper();
    }
    
    public boolean addSellerItem(SellerOrientedItem sellerItem, boolean instantCommit) {
    	if(newSellerItems == null) {
    		newSellerItems = new ArrayList<>();
    	}
        newSellerItems.add(sellerItem);
        if(instantCommit) {
        	return doCommit()[0];
        }
        return true;
    }
    
    public boolean updateSellerItem(SellerOrientedItem sellerItem, boolean instantCommit) {
    	if(dirtySellerItems == null) {
    		dirtySellerItems = new ArrayList<>();
    	}
    	dirtySellerItems.add(sellerItem);

    	if(instantCommit) {
    		return doCommit()[1];
    	}    	
    	return true;
    }
   
    public boolean deleteSellerItem(SellerOrientedItem sellerItem, boolean instantCommit) {
    	if(deleteSellerItems == null) {
    		deleteSellerItems = new ArrayList<>();
    	}
    	deleteSellerItems.add(sellerItem);

    	if(instantCommit) {
    		return doCommit()[2];
    	}   	
    	return true;
    }
        
    public ArrayList<SellerOrientedItem> getItemsByRange(String range, String[] parameters){
    	ArrayList<SellerOrientedItem> allItems = itemMapper.getItemsByRange(range, parameters);
    	return allItems;
    }
    
    public boolean changeStock(int itemId, int stock) {
    	return itemMapper.changeStock(itemId, stock);
    }
    
    public boolean[] doCommit() {
    	boolean isNewSuccess = true;
    	boolean isUpdateSuccess = true;
    	boolean isDeleteSuccess = true;
    	
    	if(newSellerItems != null) {
    		if(newSellerItems.size() > 0) {
    			if(itemMapper.insert(newSellerItems)) {
    				newSellerItems.clear();
    			}
    			else {
    				isNewSuccess = false;
    			}
    		}
    	}
    	if(dirtySellerItems != null) {
    		if(dirtySellerItems.size() > 0) {
    			if(itemMapper.update(dirtySellerItems)) {
    				dirtySellerItems.clear();
    			}
    			else {
    				isUpdateSuccess = false;
    			}
    		}
    	}
    	if(deleteSellerItems != null) {
    		if(deleteSellerItems.size() > 0) {
    			if(itemMapper.delete(deleteSellerItems)) {
    				deleteSellerItems.clear();
    			}
    			else {
    				isDeleteSuccess = false;
    			}
    		}
    	}
    	
    	return new boolean[] {isNewSuccess, isUpdateSuccess, isDeleteSuccess};
    }
}
