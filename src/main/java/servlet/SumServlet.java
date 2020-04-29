package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sum")
public class SumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("a")); // 2
        int b = Integer.parseInt(req.getParameter("b")); // 3

        // 2 + 3 = 5
        resp.getWriter().println(a + " + " + b + " = " + (a + b));
    }
}
