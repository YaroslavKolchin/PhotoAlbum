/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageWeb;

/**
 *
 * @author yaroslav
 */
public class Photo {
    public int photoId;
    public int photoOwnerId;
    public int photoAlbumId;
    public String photoName;
    public String dateTaken;
    public String description;
    public String dateUpload;
    public String filePath;

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getPhotoOwnerId() {
        return photoOwnerId;
    }

    public void setPhotoOwnerId(int photoOwnerId) {
        this.photoOwnerId = photoOwnerId;
    }

    public int getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(int photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(String dateUpload) {
        this.dateUpload = dateUpload;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
   
   
   
   
    
    
}
