package Controller;

import Dao.ProductDao;
import Entity.Product;
import Exception.ElementNotFoundException;
import Util.ParamConstants;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AddToBasketController extends HttpServlet {

    private final ProductDao productDao = new ProductDao();

    private static final Logger logger = Logger.getLogger(AddToBasketController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Add to basket controller get request");

        HttpSession session = req.getSession();

        try {
            if (req.getParameter(ParamConstants.PARAM_ID) != null) {
                logger.info("id param is founded");

                Long productCode = Long.valueOf(req.getParameter(ParamConstants.PARAM_ID));
                logger.info("Value is " + productCode);

                Product product = productDao.getById(productCode);

                if ( session.getAttribute(ParamConstants.PARAM_BASKET) == null ) {
                    logger.info("User session is new");
                    session.setAttribute(ParamConstants.PARAM_BASKET,
                            new LinkedHashMap<Product, Long>() {{put( product, new Long(1) );}});

                } else {
                    Map<Product, Long> basket = (Map<Product, Long>) session.getAttribute(ParamConstants.PARAM_BASKET);
                    basket.put(product, basket.get(product) + 1);

                    session.setAttribute(ParamConstants.PARAM_BASKET, basket);

                }
                resp.sendRedirect(req.getContextPath() + "/product?" + ParamConstants.PARAM_ID + "=" + productCode);

            }

        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

