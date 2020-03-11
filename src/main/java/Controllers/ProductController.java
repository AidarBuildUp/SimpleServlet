package Controllers;

import Dao.ProductDao;
import Entities.Product;
import Exceptions.ElementNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ProductController extends HttpServlet {

    private final ProductDao productDao = new ProductDao();

    private final String productPage = "product.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("id") != null) {
                Long productId = new Long(req.getParameter("id"));
                Product product = productDao.getById(productId);

                req.setAttribute(productId.toString(), product);

            } else {
                Map<Long, Product> products = productDao.getAll();

                for (Long productId: products.keySet()) {
                    req.setAttribute(productId.toString(), products.get(productId));
                }
            }

        } catch (ElementNotFoundException e) {
                e.printStackTrace();
        }
    }
}
