/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
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
 * @author talgat
 */
@WebServlet(name = "PhotoServlet1", urlPatterns = {"/PhotoServlet1"})
public class PhotoServlet1 extends HttpServlet {
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
            out.println("<title>Servlet PhotoServlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PhotoServlet1 at " + request.getContextPath() + "</h1>");
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
        
        String albumId = request.getParameter("albumId");
        String owner = request.getParameter("photo_owner_id"); 
        
        ServletOutputStream stream = response.getOutputStream();
        String userDirectory=System.getProperty("user.home");
        File PhotoDirectory = new File(userDirectory+"/PhotoAlbum/"+owner+"/"+albumId);
        System.out.println("servlet 1 photoDirectory "+PhotoDirectory.getAbsolutePath());
        File[] listOfFiles = PhotoDirectory.listFiles();
        if(listOfFiles.length > 0 && listOfFiles.length <= 10)
        {
            System.out.println("File: " + listOfFiles[0].getName());
            FileInputStream fis = new FileInputStream(PhotoDirectory.getAbsolutePath()+"/"+listOfFiles[0].getName());
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
        }
        stream.close();     
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
