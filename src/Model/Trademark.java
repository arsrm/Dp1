/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Gustavo
 */
public class Trademark {
    private Integer id_Trademark;
    private String name;

    /**
     * @return the id_Trademark
     */
    public Integer getId_Trademark() {
        return id_Trademark;
    }

    /**
     * @param id_Trademark the id_Trademark to set
     */
    public void setId_Trademark(Integer id_Trademark) {
        this.id_Trademark = id_Trademark;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
