package dao;

import java.util.ArrayList;

import entity.Item;
import entity.User;

public interface ItemDao {

    public boolean addItem(ArrayList<Item> items);
    
    public boolean updateItem(ArrayList<Item> items);
    
    public boolean deleteItem(ArrayList<Item> items);
    
    public ArrayList<Item> getItem(int userId);

}
