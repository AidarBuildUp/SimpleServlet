package Basket;

import Entities.BaseProduct;
import Exceptions.BasketNotIncludeSuchElementException;

import java.util.LinkedHashMap;
import java.util.Map;

public class BasketImpl implements Basket {
    private static Map<BaseProduct, Long> basket = new LinkedHashMap();

    public Map<BaseProduct, Long> getAllItems() {
        return basket;
    }

    public Map<BaseProduct, Long>addItem(BaseProduct product) throws BasketNotIncludeSuchElementException {
        if (basket.containsKey(product)) {

            basket.put(product, basket.get(product) + 1 );

        } else {

            basket.put(product, new Long(1) );

        }
        return basket;
    }

    public Map<BaseProduct, Long> removeItem(BaseProduct product) throws BasketNotIncludeSuchElementException {


        if (basket.containsKey(product)) {

            Long oldCount = basket.get(product);

            if (oldCount == 1) {

                basket.remove(product);

            } else{

                basket.put(product, ++oldCount);

            }

        } else {

            throw new BasketNotIncludeSuchElementException();

        }

        return basket;

    }
}
