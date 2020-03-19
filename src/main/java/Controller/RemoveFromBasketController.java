package Controller;

import Dao.ProductDao;
import Entity.Product;
import Exception.BasketParamsNotFoundException;
import Exception.ElementNotFoundException;
import Util.ParamConstants;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class RemoveFromBasketController extends HttpServlet {

    ProductDao productDao = new ProductDao();

    private static final Logger logger = Logger.getLogger(RemoveFromBasketController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        logger.info("RemoveFromBasketController get request");

            if (session.getAttribute(ParamConstants.PARAM_BASKET) != null){

                logger.info("basket is founded");

                Map<Product, Long> basket = (Map<Product, Long>) session.getAttribute(ParamConstants.PARAM_BASKET);

                try {
                    if ( req.getParameter(ParamConstants.PARAM_ID) != null ) {

                        logger.info("id param is founded");

                        Long productId = Long.valueOf(req.getParameter(ParamConstants.PARAM_ID));

                        Product product = productDao.getById(productId);

                        logger.info(basket.get(product) + " products in basket");
                        if (basket.get(product) == 1) {
                            basket.remove(product);
                        } else {
                            basket.put(product, basket.get(product) - 1);
                        }
                        resp.sendRedirect(req.getContextPath() + "/product?" + ParamConstants.PARAM_ID + "=" + productId);
                    } else {
                        throw new BasketParamsNotFoundException();
                        }
                    } catch (ElementNotFoundException | BasketParamsNotFoundException e) {
                        logger.error(e.getCause());
                    }


            }


    }
}
