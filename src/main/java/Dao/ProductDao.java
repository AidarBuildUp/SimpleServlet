package Dao;

import Entities.EntityEnums.EntitiesEnum;
import Entities.Product;
import Exceptions.ElementNotFoundException;
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
