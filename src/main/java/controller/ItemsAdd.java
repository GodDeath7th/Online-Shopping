package controller;

import entity.Item;
import entity.User;
import serviceImp.ItemAddServiceImpl;

import java.util.ArrayList;


public class ItemsAdd{

   private ArrayList<Item> items = new ArrayList<>();
   private ItemAddServiceImpl itemService = new ItemAddServiceImpl();
   
   public ArrayList<Item> getItems(int userId) {
	   return itemService.getItem(userId);
   }
}
