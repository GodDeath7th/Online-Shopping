package service;

import java.util.ArrayList;

import entity.Item;
import entity.User;

public interface ItemAdd {
    public boolean addItem(Item item, boolean instant);
    
    public boolean updateItem(Item item, boolean instant);
    
    public boolean deleteItem(Item item, boolean instant);
    
    public ArrayList<Item> getItem(int userId);

}
