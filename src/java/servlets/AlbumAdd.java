/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import db.DB;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yaroslav
 */
@WebServlet(name = "AlbumAdd", urlPatterns = {"/AlbumAdd"})
public class AlbumAdd extends HttpServlet {
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
            out.println("<title>Servlet AlbumAdd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlbumAdd at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
         request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        
        String filePath = "/home/PhotoAlbum/User/Email/AlbumName/1.jpg";
        response.setContentType("image/jpg");
        ServletOutputStream stream = response.getOutputStream();
        FileInputStream fis = new FileInputStream(filePath);
        BufferedInputStream bin = new BufferedInputStream(fis);  
        BufferedOutputStream bout = new BufferedOutputStream(stream);  
        int ch = 0;
        while((ch = bin.read())!=-1)  
        {  
            bout.write(ch);
        } 
        bin.close();  
        fis.close();  
        bout.close();  
        stream.close(); 
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
         
        String name="";
       if(request.getParameter("album_name")!=null)
         name=request.getParameter("album_name");
        String description = "";
        if(request.getParameter("album_description")!=null)
            description=request.getParameter("album_description");
        System.out.println("name "+name+" description "+description);
        if(name.length()>2 && description.length()>5)
        {
            DB d=new DB();       
        try {
            
            HttpSession session = request.getSession(true);
            String owner="2018";
            if(session.getAttribute("album_owner_id")!=null)
            {
                owner= session.getAttribute("album_owner_id").toString();  
            }
            System.out.println("success "+owner);
            d.dbAlbumAdd(name,description,owner);
            System.out.println("album add ok");
        } catch (Exception ex) {
            System.out.println("ex: "+ex);
        } 
        }
        else
        {
            System.out.println("album wasn't created");    
        }
        
       
       
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
