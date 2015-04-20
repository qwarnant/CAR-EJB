package fr.univ.lille1.service;

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
 * Cette servlet permet d'afficher la page d'accueil principale du site
 *
 * @author Quentin Warnant
 * @version 1.0
 */
@WebServlet(name = "BookIndex", urlPatterns = {"/"})
public class BookIndex extends HttpServlet {

    /**
     * Cette méthode permet d'afficher la page d'accueil du site
     * @param request Request la requête HTTP
     * @param response Response la réponse HTTP
     * @throws ServletException
     * @throws IOException 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

}
