/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Timestamp;

/**
 *
 * @author Luigi
 */

public class ProfileWindow {
    
    public Integer idProfile;
    public String id_windows;
    public Integer status;
    public String description;
    public Integer id_menu;    
    
    public ProfileWindow() {
    }

    /**
     * @return the idProfile
     */
    public Integer getIdProfile() {
        return idProfile;
    }

    /**
     * @param idProfile the idProfile to set
     */
    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    /**
     * @return the id_windows
     */
    public String getId_windows() {
        return id_windows;
    }

    /**
     * @param id_windows the id_windows to set
     */
    public void setId_windows(String id_windows) {
        this.id_windows = id_windows;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the id_menu
     */
    public Integer getId_menu() {
        return id_menu;
    }

    /**
     * @param id_menu the id_menu to set
     */
    public void setId_menu(Integer id_menu) {
        this.id_menu = id_menu;
    }

        
}
