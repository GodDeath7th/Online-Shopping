package serviceImp;

import java.util.ArrayList;

import daoImpl.CategoryDaoImpl;
import daoImpl.ItemDaoImpl;
import entity.Items;
import service.ItemAdd;

public class ItemAddServiceImpl implements ItemAdd {
    private   ItemDaoImpl itemDao = new ItemDaoImpl();
    private CategoryDaoImpl categoryDao = new CategoryDaoImpl();

    private ArrayList<Items> newItems;
    private ArrayList<Items> dirtyItems;
    private ArrayList<Items> cleanItems;
    private ArrayList<Items> deleteItems;

    @Override
    public void addItem(Items items) {
        itemDao.addItem(items);
        categoryDao.updateItemNum(items.getCategoryId(),1);
    }

}
