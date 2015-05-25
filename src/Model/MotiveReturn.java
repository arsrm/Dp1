/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Luis Miguel
 */

public class MotiveReturn {
    private Integer idMotiveReturn;
    private String description;
    private Integer status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer userCreated;
    private Integer userUpdated;
    private List<ProductReturn> productReturnList;

    public MotiveReturn() {
    }

    public MotiveReturn(Integer idMotiveReturn) {
        this.idMotiveReturn = idMotiveReturn;
    }

    public Integer getIdMotiveReturn() {
        return idMotiveReturn;
    }

    public void setIdMotiveReturn(Integer idMotiveReturn) {
        this.idMotiveReturn = idMotiveReturn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Integer userCreated) {
        this.userCreated = userCreated;
    }

    public Integer getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(Integer userUpdated) {
        this.userUpdated = userUpdated;
    }

    public List<ProductReturn> getProductReturnList() {
        return productReturnList;
    }

    public void setProductReturnList(List<ProductReturn> productReturnList) {
        this.productReturnList = productReturnList;
    }
}
