package MapDataBase;

import Entities.EntityEnums.Entities;
import Exceptions.ElementNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDb {

    private static final Map <Long, String> productDb = new LinkedHashMap<Long, String>() {{
        put(new Long (1), "Bread");
        put(new Long (2), "Butter");
        put(new Long (2), "Banana");
    }};

    public static Map <Long, String> getAllEntities (Entities tableName) throws ElementNotFoundException {
        switch (tableName){
            case Product: return productDb;
            default: throw new ElementNotFoundException();
        }
    }

    public static String getOne (Entities tableName, Long id) throws ElementNotFoundException {
        switch (tableName){
            case Product: return productDb.get(id);
            default: throw new ElementNotFoundException();
        }
    }
}
