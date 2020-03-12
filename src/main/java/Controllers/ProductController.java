package Controllers;

import Dao.ProductDao;
import Entities.Product;
import Exceptions.ElementNotFoundException;
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


    private static final Logger logger = Logger.getLogger(ProductController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(">> GET request income");
        try {
            if (req.getParameter("id") != null) { //one product with explicit code requested
                Long productCode = Long.valueOf(req.getParameter("id"));
                Product product = productDao.getById(productCode);

                req.setAttribute("product", product);

                RequestDispatcher dispatcher = req.getRequestDispatcher(ONE_PRODUCT_PAGE);
                dispatcher.forward(req, resp);

            } else { //all products requested
                List<Product> products = productDao.getAll();

                req.setAttribute("products", products);

                RequestDispatcher dispatcher = req.getRequestDispatcher(ALL_PRODUCTS_PAGE);
                dispatcher.forward(req, resp);
            }

        } catch (ElementNotFoundException e) {
                e.printStackTrace();
        }

    }
}
