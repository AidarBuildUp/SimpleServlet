package MapDataBase;

import Entities.EntityEnums.EntitiesEnum;
import Entities.Product;
import Exceptions.ElementNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDb {

    private static final Map <Long, Product> productDb = new LinkedHashMap<Long, Product>() {{
        put(new Long(1), new Product("Bread") );
        put(new Long(2), new Product("Butter") );
        put(new Long(3), new Product("Banana") );
    }};

    public static Map <Long, Product> getAllEntities (EntitiesEnum tableName) throws ElementNotFoundException {
        switch (tableName){
            case Product: return productDb;
            default: throw new ElementNotFoundException();
        }
    }

    public static Product getOne (EntitiesEnum tableName, Long id) throws ElementNotFoundException {
        switch (tableName){
            case Product: return productDb.get(id);
            default: throw new ElementNotFoundException();
        }
    }
}
