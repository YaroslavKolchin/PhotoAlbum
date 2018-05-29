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
public class Album {
    public int albumId;
   public int albumOwnerId;
   public String albumName;
   public String albumDescription;
   public String albumDateCreated;
   public String albumPath;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getAlbumOwnerId() {
        return albumOwnerId;
    }

    public void setAlbumOwnerId(int albumOwnerId) {
        this.albumOwnerId = albumOwnerId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public String getAlbumDateCreated() {
        return albumDateCreated;
    }

    public void setAlbumDateCreated(String albumDateCreated) {
        this.albumDateCreated = albumDateCreated;
    }

    public String getAlbumPath() {
        return albumPath;
    }

    public void setAlbumPath(String albumPath) {
        this.albumPath = albumPath;
    }
   
    
}
