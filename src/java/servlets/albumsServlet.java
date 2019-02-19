/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import db.DB;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yaroslav
 */
@WebServlet(name = "MyAlbums", urlPatterns = {"/MyAlbums"})
public class albumsServlet extends HttpServlet {
   

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
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyAlbums</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyAlbums at " + request.getContextPath() + "</h1>");
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
        Map<Integer,String> albumNamesMap = new HashMap<Integer,String>();
        
        HttpSession session = request.getSession(true);
        String owner = "1";
        int id=1;
        if(session.getAttribute("album_owner_id")!=null)
        {
            System.out.println("session "+session.getAttribute("album_owner_id").toString());
            owner = session.getAttribute("album_owner_id").toString();
        }
        System.out.println("owner "+owner);
        boolean show = true;
        
        String pageName = "/jsp/PhotoAddtest.jsp";
        if(request.getRequestURL().toString().contains("/myAlbums.jsp")) 
        {
            pageName = "/jsp/myAlbumsList.jsp";
            show = false;
        }
        
        if(owner!=null)
        {
            DB d = new DB();            
            try 
            {
                System.out.println("success "+owner);
                albumNamesMap = d.dbOwnerAlbums(owner, show);
                /*
                Set<Integer> key =  albumNamesMap.keySet();
                Iterator<Integer> it = key.iterator();             
                if(key.size()>1)
                {
                    while(it.hasNext())
                    {
                        System.out.println("album list id"+it.next()+"; name: "+albumNamesMap.get(it.next()));
                    }
                }
                */
            }
            catch (Exception ex)
            {
                System.out.println("ex: "+ex);
            }     
        }
        else
        {
            System.out.println("created");    
        }        
        //System.out.println("GET MM");
        //String albums = "test album 2018";
          
        request.setAttribute("album_owner_id", owner);  
        //System.out.println("albumNamesMap:"+albumNamesMap);
        request.setAttribute("albums", albumNamesMap);
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(pageName);
        rd.include(request, response); 
        
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
