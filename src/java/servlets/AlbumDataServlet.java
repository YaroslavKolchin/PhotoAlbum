/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import db.DB;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import packageWeb.Photo;
/**
 *
 * @author talgat
 */
@WebServlet(name = "AlbumDataServlet", urlPatterns = {"/AlbumDataServlet"})
public class AlbumDataServlet extends HttpServlet {
        private String encoding = "UTF-8";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlbumDataServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlbumDataServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        @SuppressWarnings("empty-statement")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {        
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        String albumId = request.getParameter("albumId");
        //System.out.println("album data servlet is called from js "+albumId);
        DB db = new DB();
        try
        {   
            //System.out.println("test");
            ArrayList<Photo> photoList = db.dbPhotoInfo(albumId);
           
            /*
                for(Photo photo:photoList)
                {
                //System.out.println("servlet photo name "+photo.getPhotoName()+" photo des "+photo.getDescription()+" photo date "+photo.getDateUploud()+" photo path "+photo.getFilePath());
                System.out.println("photo name "+PhotoDirectory.getAbsolutePath());
                }
            */            
        }
        catch(Exception ex)
        {
            System.out.println("exception in album Data servlet: ");
        };
        //response.setContentType("application/json");   
        String result = new Gson().toJson("Test Message From the Servlet");
	response.getWriter().write(result);
        //processRequest(request, response); 
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