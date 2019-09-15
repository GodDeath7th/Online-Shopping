package dao;

import entity.Categroy;

import java.util.List;

public interface CategoryDao {
    public void addCategort(Categroy categroy);
    public List<Categroy> getCategory();
    public  void updateItemNum(String id, int number);
}
