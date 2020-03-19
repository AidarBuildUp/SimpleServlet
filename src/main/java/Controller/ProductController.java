package Controller;

import Dao.ProductDao;
import Entity.Product;
import Exception.ElementNotFoundException;
import Util.ParamConstants;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductController extends HttpServlet {

    private final ProductDao productDao = new ProductDao();

    private final String ALL_PRODUCTS_PAGE = "/pages/allProducts.jsp";
    private final String ONE_PRODUCT_PAGE = "/pages/product.jsp";

    private final String PARAM_ID = "id";


    private static final Logger logger = Logger.getLogger(ProductController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("ProductController get request");

        try {
            if (req.getParameter(PARAM_ID) != null) { //one product with explicit code requested
                logger.info("Param id is founded");

                Long productCode = Long.valueOf(req.getParameter(PARAM_ID));

                logger.info("Value is " + productCode);

                Product product = productDao.getById(productCode);

                req.setAttribute(ParamConstants.PARAM_PRODUCT, product);

                RequestDispatcher dispatcher = req.getRequestDispatcher(ONE_PRODUCT_PAGE);
                dispatcher.forward(req, resp);
            }

        } catch (ElementNotFoundException e) {
                e.printStackTrace();
        }

    }
}
