package service;

import entity.Categroy;

import java.util.List;
import java.util.Locale;

public interface CategoryService {
    public void addCategory(Categroy categroy);
    public List<Categroy> getCategory();
}
