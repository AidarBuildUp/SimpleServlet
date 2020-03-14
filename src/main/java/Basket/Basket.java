package Basket;

import Entities.BaseProduct;
import Exceptions.BasketNotIncludeSuchElementException;

import java.util.Map;

public interface Basket {
    Map<BaseProduct, Long> getAllItems ();

    Map<BaseProduct, Long> addItem(BaseProduct item) throws BasketNotIncludeSuchElementException;

    Map<BaseProduct, Long> removeItem(BaseProduct item)throws BasketNotIncludeSuchElementException;
}
