package DataBase;

import Entities.EntityEnums.EntitiesEnum;
import Entities.Product;
import Exceptions.ElementNotFoundException;

import java.util.*;

public class DbEmulator {

    private static final Map <Long, Product> productDb = new HashMap<Long, Product>() {{
        put(new Long(1), new Product(new Long(1), "Bread") );
        put(new Long(2), new Product(new Long(2),"Butter") );
        put(new Long(3), new Product(new Long(3),"Banana") );
    }};

    public static List<Product> getAllEntities (EntitiesEnum tableName) throws ElementNotFoundException {
        switch (tableName){
            case Product: return new ArrayList<Product>(productDb.values());
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
