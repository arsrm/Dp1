/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Date;

/**
 *
 * @author Luis Miguel
 */
public class ExecutionAlgorithm {
    private Integer idExecutionAlgorithm;
    private Date date;
    private Integer status;
    private Double function_value;
    private Integer vehicles_number;

    /**
     * @return the idExecutionAlgorithm
     */
    public Integer getIdExecutionAlgorithm() {
        return idExecutionAlgorithm;
    }

    /**
     * @param idExecutionAlgorithm the idExecutionAlgorithm to set
     */
    public void setIdExecutionAlgorithm(Integer idExecutionAlgorithm) {
        this.idExecutionAlgorithm = idExecutionAlgorithm;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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
     * @return the function_value
     */
    public Double getFunction_value() {
        return function_value;
    }

    /**
     * @param function_value the function_value to set
     */
    public void setFunction_value(Double function_value) {
        this.function_value = function_value;
    }

    /**
     * @return the vehicles_number
     */
    public Integer getVehicles_number() {
        return vehicles_number;
    }

    /**
     * @param vehicles_number the vehicles_number to set
     */
    public void setVehicles_number(Integer vehicles_number) {
        this.vehicles_number = vehicles_number;
    }
    
    
    
    
}
