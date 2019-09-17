package serviceImp;

import java.util.ArrayList;

import daoImpl.CategoryDaoImpl;
import daoImpl.ItemDaoImpl;
import entity.Item;
import entity.User;
import service.ItemAdd;

public class ItemAddServiceImpl implements ItemAdd {
    private   ItemDaoImpl itemDao = new ItemDaoImpl();

    private ArrayList<Item> newItems = new ArrayList<>();
    private ArrayList<Item> dirtyItems = new ArrayList<>();
    private ArrayList<Item> cleanItems = new ArrayList<>();
    private ArrayList<Item> deleteItems = new ArrayList<>();

    public boolean addItem(Item item, boolean instant) {
        newItems.add(item);
        if(instant) {
        	doItemCommit();
        }
        return true;
    }
    
    public boolean updateItem(Item item, boolean instant) {
    	for(Item cleanItem:cleanItems) {
    		if(item.getId() == cleanItem.getId()) {
    			cleanItems.remove(cleanItem);
    			dirtyItems.add(item);
    			break;
    		}
    	}  	
    	if(instant) {
    		doItemCommit();
    	}    	
    	return true;
    }
   
    public boolean deleteItem(Item item, boolean instant) {

    	for(Item cleanItem:cleanItems) {
    		if(item.getId() == cleanItem.getId()) {
    			cleanItems.remove(cleanItem);
    			deleteItems.add(item);
    			break;
    		}
    	}
    	if(instant) {
    		doItemCommit();
    	}   	
    	return true;
    }
    
    
    public ArrayList<Item> getItem(int userId){
    	if(cleanItems.size() != 0) {
    		return cleanItems;
    	}
    	else {
    		cleanItems = itemDao.getItem(userId);
    		return cleanItems;
    	}
    }
    
    public void doItemCommit() {
    	if(newItems.size() > 0) {
    		if(itemDao.addItem(newItems)) {
    			cleanItems = itemDao.getItem(newItems.get(0).getUserId());
    			newItems.clear();
    		}
    	}
    	if(dirtyItems.size() > 0) {
    		if(itemDao.updateItem(dirtyItems)) {
    			cleanItems = itemDao.getItem(dirtyItems.get(0).getUserId());
    			dirtyItems.clear();
    		}
    	}
    	if(deleteItems.size() > 0) {
    		if(itemDao.deleteItem(deleteItems)) {
    			deleteItems.clear();
    		}
    	}
    }
}
