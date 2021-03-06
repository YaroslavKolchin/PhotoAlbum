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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author talgat
 */
public class PhotoServlet7 extends HttpServlet {

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
            out.println("<title>Servlet PhotoServlet7</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PhotoServlet7 at " + request.getContextPath() + "</h1>");
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
    private String encoding = "UTF-8";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        int thisServlet = 7;
        
        String albumId = request.getParameter("albumId");
        String owner = request.getParameter("photo_owner_id"); 
        
        ServletOutputStream stream = response.getOutputStream();
        String userDirectory=System.getProperty("user.home");
        File PhotoDirectory = new File(userDirectory+"/PhotoAlbum/"+owner+"/"+albumId);
        File[] listOfFiles = PhotoDirectory.listFiles();
        //sort start        
        for (int i = 0; i < listOfFiles.length-1; i++) 
            for (int j = 0; j < listOfFiles.length-i-1; j++) 
                if (listOfFiles[j].compareTo(listOfFiles[j+1])>0) 
                { 
                    // swap arr[j+1] and arr[i] 
                    File temp = listOfFiles[j]; 
                    listOfFiles[j] = listOfFiles[j+1]; 
                    listOfFiles[j+1] = temp; 
                }
        //sort end
        if(listOfFiles.length > 6 && listOfFiles.length <= 10)
        {
            FileInputStream fis = new FileInputStream(PhotoDirectory.getAbsolutePath()+"/"+listOfFiles[6].getName());
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
        else if( listOfFiles.length < thisServlet && listOfFiles.length>0)
        {           
            int i = 0;
            if(listOfFiles.length != 1)       
            {
                i = thisServlet%listOfFiles.length;    
            }
            FileInputStream fis = new FileInputStream(PhotoDirectory.getAbsolutePath()+"/"+listOfFiles[i].getName());
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
        else if(listOfFiles.length < 1)
        {
            File NoPhotoDirectory = new File(userDirectory+"/PhotoAlbum/NoPhoto/1.png");
            FileInputStream fis = new FileInputStream(NoPhotoDirectory.getAbsolutePath());
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
