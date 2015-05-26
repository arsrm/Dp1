
package Model;

/**
 *
 * @author Alejandro
 */
public class Profile {

    
    private Integer idprofile;
    private String name; 
    private String description;
    private Integer status;
    
    
    public Integer getIdprofile() {
        return idprofile;
    }

    public void setIdprofile(Integer idprofile) {
        this.idprofile = idprofile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getStatus(){
        return status;
    }
    
    public void setStatus(Integer status){
        this.status = status;
    }
    
}
