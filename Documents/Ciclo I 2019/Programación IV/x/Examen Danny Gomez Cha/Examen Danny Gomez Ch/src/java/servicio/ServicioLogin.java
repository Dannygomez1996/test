
package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.GestorLogin;

/**
 *
 * @author Danny Gomez Chaves
 */

@WebServlet(name = "ServicioLogin", urlPatterns = {"/ServicioLogin"})
public class ServicioLogin extends HttpServlet {

      protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
        
           String username = request.getParameter("username");
           String password = request.getParameter("password");
           
           if(GestorLogin.obtenerInstancia().validateLogin(username, password)){
               HttpSession session = request.getSession(true);
               session.setAttribute("user",username);
               session.setMaxInactiveInterval(60 * 3);
               response.sendRedirect("datos.jsp");
           }
           else{
               response.sendRedirect("index.jsp");
           }
      }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
