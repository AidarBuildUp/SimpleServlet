package Controllers;

import Basket.BasketImpl;
import Dao.ProductDao;
import Entities.Product;
import Exceptions.BasketNotIncludeSuchElementException;
import Exceptions.ElementNotFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BasketController extends HttpServlet {

    private final ProductDao productDao = new ProductDao();

    private final String BASKET = "/pages/basket.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">> GET request income basket");

        HttpSession session = req.getSession();

        try {
            if (req.getParameter("id") != null) { //one product will be added
                Long productCode = Long.valueOf(req.getParameter("id"));
                Product product = productDao.getById(productCode);

                if ( session.isNew() ) {
                    session.setAttribute("basket", new BasketImpl());
                }

                BasketImpl basket = (BasketImpl) session.getAttribute("basket");

                if ( req.getParameter("action").equals("add") ) {
                    basket.addItem(product);
                }

                if ( req.getParameter("remove").equals("remove") ) {
                    basket.removeItem(product);
                }

            } else { //show all items from basket

                if ( session.isNew() ) {

                    session.setAttribute("basket", new BasketImpl());

                }
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher(BASKET);
            dispatcher.forward(req, resp);

        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        } catch (BasketNotIncludeSuchElementException e) {
            e.printStackTrace();
        }

    }
}

