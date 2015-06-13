/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Luis Miguel
 */
public class ExecutionDetail {
    private Integer idExecutionAlgorithm;
    private Integer idDispatch_Order;
    private Integer idPicking_Order;
    private Integer idVehicle;
    private Integer idVehicle_State;
    private Integer idDriver;
    private Integer order_route;
    
    public ExecutionDetail(){
        
    }
            

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
     * @return the idDispatch_Order
     */
    public Integer getIdDispatch_Order() {
        return idDispatch_Order;
    }

    /**
     * @param idDispatch_Order the idDispatch_Order to set
     */
    public void setIdDispatch_Order(Integer idDispatch_Order) {
        this.idDispatch_Order = idDispatch_Order;
    }

    /**
     * @return the idPicking_Order
     */
    public Integer getIdPicking_Order() {
        return idPicking_Order;
    }

    /**
     * @param idPicking_Order the idPicking_Order to set
     */
    public void setIdPicking_Order(Integer idPicking_Order) {
        this.idPicking_Order = idPicking_Order;
    }

    /**
     * @return the idVehicle
     */
    public Integer getIdVehicle() {
        return idVehicle;
    }

    /**
     * @param idVehicle the idVehicle to set
     */
    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    /**
     * @return the idVehicle_State
     */
    public Integer getIdVehicle_State() {
        return idVehicle_State;
    }

    /**
     * @param idVehicle_State the idVehicle_State to set
     */
    public void setIdVehicle_State(Integer idVehicle_State) {
        this.idVehicle_State = idVehicle_State;
    }

    /**
     * @return the idDriver
     */
    public Integer getIdDriver() {
        return idDriver;
    }

    /**
     * @param idDriver the idDriver to set
     */
    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    /**
     * @return the order_route
     */
    public Integer getOrder_route() {
        return order_route;
    }

    /**
     * @param order_route the order_route to set
     */
    public void setOrder_route(Integer order_route) {
        this.order_route = order_route;
    }

    
}
