package serviceImp;

import daoImpl.CategoryDaoImpl;
import entity.Categroy;
import service.CategoryService;
import util.Util;

import java.util.List;

public class CategoryServiceImp implements CategoryService {
    private CategoryDaoImpl categoryDao = new CategoryDaoImpl();
    @Override
    public void addCategory(Categroy categroy) {
        categroy.setId(Util.getId());
        categoryDao.addCategort(categroy);
    }

    @Override
    public List<Categroy> getCategory() {
        return categoryDao.getCategory();
    }
}
