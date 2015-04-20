package fr.univ.lille1.service;

import fr.univ.lille1.dal.BookDal;
import fr.univ.lille1.dal.ClientDal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 *
 * Cette servlet permet d'initialiser le contenu du site avec les livres et les
 * utilisateurs de base
 *
 * @author Quentin Warnant
 * @version 1.0
 */
@WebServlet(name = "BookInit", urlPatterns = {"/init"})
public class BookInit extends HttpServlet {

    @EJB
    private BookDal bookSession;

    @EJB
    private ClientDal userSession;

    /**
     * Cette méthode permet d'initialiser le contenu du site avec les livres et
     * les utilisateurs de base
     *
     * @param request Request la requête HTTP
     * @param response Response la réponse HTTP
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            if (bookSession.init()) {
                request.setAttribute("initBase", true);
            } else {
                request.setAttribute("initBase", false);
            }

            if (userSession.init()) {
                request.setAttribute("initUser", true);
            } else {
                request.setAttribute("initUser", false);
            }

        } catch (Exception e) {
            request.setAttribute("error", true);
        }

        ServletContext context = request.getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/init.jsp");
        rd.forward(request, response);
    }
}
