package Dao;

import Entities.EntityEnums.EntitiesEnum;
import Entities.Product;
import Exceptions.ElementNotFoundException;
import MapDataBase.MapDb;

import java.util.Map;

public class ProductDao {

    public Map<Long, Product> getAll () throws ElementNotFoundException {
      return MapDb.getAllEntities(EntitiesEnum.Product);
    }

    public Product getById (Long id) throws ElementNotFoundException {
        return MapDb.getOne(EntitiesEnum.Product, id);
    }
}
