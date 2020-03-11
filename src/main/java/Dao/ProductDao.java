package Dao;

import Entities.EntityEnums.Entities;
import Exceptions.ElementNotFoundException;
import MapDataBase.MapDb;

import java.util.Map;

public class ProductDao {

    public Map<Long, String> getAll () throws ElementNotFoundException {
      return MapDb.getAllEntities(Entities.Product);
    }

    public String getById (Long id) throws ElementNotFoundException {
        return MapDb.getOne(Entities.Product, id);
    }
}
