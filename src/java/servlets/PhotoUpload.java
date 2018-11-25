/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import db.DB;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import static java.nio.file.Files.newOutputStream;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
/*
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
*/
/*
@MultipartConfig( fileSizeThreshold = 1024 * 1024 * 1,
maxFileSize = 1024 * 1024 * 10, 
maxRequestSize = 1024 * 1024 * 15, 
location = "/h" )
*/
/**
 *
 * @author yaroslav
 */

@WebServlet(name = "PhotoUpload", urlPatterns = {"/PhotoUpload"})
@MultipartConfig()
public class PhotoUpload extends HttpServlet {

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
            out.println("<title>Servlet PhotoUpload</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PhotoUpload at " + request.getContextPath() + "</h1>");
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
         String name="";
       if(request.getParameter("photo_name")!=null)
         name=request.getParameter("photo_name");
        String description = "";
        if(request.getParameter("photo_description")!=null)
            description=request.getParameter("photo_description");
        String photoAlbum="";
        photoAlbum=request.getParameter("album_key");
        Part image=request.getPart("f");
        String fileName = Paths.get(image.getSubmittedFileName()).getFileName().toString();
        
        HttpSession session = request.getSession(true);
        System.out.println("photo name "+name+" photo description "+description+" album "+photoAlbum+" file name "+fileName );

        if(name.length()>2 && description.length()>5)
        {            
            String owner="2018";
            if(session.getAttribute("album_owner_id")!=null)
            {
                owner= session.getAttribute("album_owner_id").toString(); 
            }
        }
     
        String owner = "1";
        
        int id=1;
        if(session.getAttribute("album_owner_id")!=null)
        {
            System.out.println("session "+session.getAttribute("album_owner_id").toString());
            owner = session.getAttribute("album_owner_id").toString();
        }
        InputStream fileContent = image.getInputStream();
        File imageFile = new File(System.getProperty("user.home")+"/PhotoAlbum/"+owner+"/"+photoAlbum+"/"+fileName);
        java.nio.file.Files.copy(fileContent, imageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);        
        fileContent.close();
        //System.out.println("path "+imageFile.toString() );
        //OutputStream os = new FileOutputStream(imageFile);
        //image.write(fileName);
        System.out.println("finished uploading a file");
        DB d = new DB();      
                try 
                {
                    //String name,String description,String owner,String album
                    System.out.println("success for Photo Upload "+owner);
                    d.dbPhotoUpload(name,description,owner,photoAlbum);
                    System.out.println("in db Photo Upload ok");
                } 
                catch (Exception ex) 
                {
                    System.out.println("ex: "+ex);
                }
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
