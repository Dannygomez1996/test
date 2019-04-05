/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;
import modelo.dao.GestorCursos;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Danny Gomez Chaves
 */

@WebServlet(name = "ServicioCursos", urlPatterns = {"/ServicioCursos"})
public class ServicioCursos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        try(PrintWriter out = response.getWriter()){
            List<Curso> cursos = GestorCursos.obtenerInstancia().listarCursos();
            System.out.println(cursos);
            
            JSONObject obj = new JSONObject();
            JSONArray array = new JSONArray();  
            
            for(Curso c : cursos){
                JSONObject pobj = new JSONObject();
                pobj.put("codigo", c.getCodigo());
                pobj.put("nombre", c.getNombre());
                pobj.put("creditos", c.getCreditos());
                array.put(pobj);
            }
            
            
            obj.put("cursosDisponibles", array);
            System.out.println(obj);
            out.print(obj);
  

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
