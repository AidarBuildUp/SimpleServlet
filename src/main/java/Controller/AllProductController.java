package Controller;

import Dao.ProductDao;
import Entity.Product;
import Exception.ElementNotFoundException;
import Util.PageConstants;
import Util.ParamConstants;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllProductController extends HttpServlet {

    private final ProductDao productDao = new ProductDao();

    private static final Logger logger = Logger.getLogger(AllProductController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info(">> GET request income allProductController");

        try {
                List<Product> products = productDao.getAll();

                req.setAttribute(ParamConstants.PARAM_ALL_PRODUCTS, products);

                RequestDispatcher dispatcher = req.getRequestDispatcher(PageConstants.ALL_PRODUCTS_PAGE);
                dispatcher.forward(req, resp);

        } catch (ElementNotFoundException e) {
                e.printStackTrace();
        }

    }
}
