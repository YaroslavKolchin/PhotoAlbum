/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import db.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import packageWeb.Photo;

/**
 *
 * @author talgat
 */
public class PhotoServlet extends HttpServlet {
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
            out.println("<title>Servlet PhotoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PhotoServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        ArrayList <Photo> photoList = new ArrayList<>(); 
         
        
        String result = "";
        String albumId = request.getParameter("albumId");
        /*
        HttpSession session = request.getSession(true);
        if(session.getAttribute("albumId")!=null)
        {
            System.out.println("session "+session.getAttribute("albumId").toString());
            albumId = session.getAttribute("albumId").toString();
        }
        */
        if(albumId!=null)
        {
            DB d = new DB();            
            try 
            {
                photoList = d.dbPhotoInfo(albumId); 
                for (int i = 0; i < photoList.size(); i++)
            {
                Photo ph=photoList.get(i);
                System.out.println("photo name "+ph.photoName+" photo des "+ph.description);
            }
            }
            catch (Exception ex)
            {
                System.out.println("exception in calling photo info: "+ex);
            }     
        }
        else
        {
            System.out.println("album id is null");    
        }
        /*
        request.setAttribute("albumId", albumId);
        request.setAttribute("photos", photoList);
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(pageName);
        rd.include(request, response); 
        processRequest(request, response);
        */
        response.setCharacterEncoding(encoding);
        response.setContentType("application/json");
        result = new Gson().toJson(photoList);
        response.getWriter().write(result);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
