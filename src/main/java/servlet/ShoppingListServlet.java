package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCShoppingListItemDao;
import database.ShoppingListItemDao;
import model.ShoppingListItem;

@WebServlet("/list")
public class ShoppingListServlet extends HttpServlet {

    private ShoppingListItemDao dao = new JDBCShoppingListItemDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShoppingListItem> allItems = this.dao.getAllItems();

        req.setAttribute("items", allItems);

        // BONUS: lisätään sivulle tieto onnistuneesta lisäyksestä
        String message = (String) req.getSession().getAttribute("message");
        if (message != null) {
            // laitetaan viesti JSP-sivun saataville
            req.setAttribute("message", message);

            // poistetaan viesti istunnosta
            req.getSession().removeAttribute("message");
        }

        req.getRequestDispatcher("/WEB-INF/shoppingList/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");

        ShoppingListItem newItem = new ShoppingListItem(title);

        boolean success = this.dao.addItem(newItem);

        // BONUS: laitetaan istuntoon talteen viesti:
        if (success) {
            req.getSession().setAttribute("message", "Saving " + title + " succeeded");
        } else {
            req.getSession().setAttribute("message", "Saving " + title + " was not successful :(");
        }

        resp.sendRedirect("/list");
    }
}
