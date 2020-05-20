package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AlbumDao;
import database.ArtistDao;

@WebServlet("/albums")
public class AlbumsServlet extends HttpServlet {

    private ArtistDao artistDao = new ArtistDao();
    private AlbumDao albumDao = new AlbumDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistIdString = req.getParameter("ArtistId");
        long artistId = Long.parseLong(artistIdString);

        resp.getWriter().println("Artist id " + artistId);

        // TODO: hae artisti ArtistDao:lta
        // TODO: hae artistin albumit AlbumDao:lta

        // TODO: aseta artisti ja albumit pyynnön attribuuteiksi
        // TODO: välitä pyyntö edelleen JSP-sivulle (requestDispatcher)
    }
}
