package Dao;

import Entity.EntityEnums.EntitiesEnum;
import Entity.Product;
import Exception.ElementNotFoundException;
import DataBase.DbEmulator;

import java.util.List;

public class ProductDao {

    public List<Product> getAll () throws ElementNotFoundException {
      return DbEmulator.getAllEntities(EntitiesEnum.Product);
    }

    public Product getById (Long id) throws ElementNotFoundException {
        return DbEmulator.getOne(EntitiesEnum.Product, id);
    }
}
