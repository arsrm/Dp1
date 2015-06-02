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
public class ExecutionAlgorithmByVehicle {
    private Integer idExecutionAlgorithmByVehicle;
    private String route;
    private Integer Execution_Algorithm_idExecutionAlgorithm;
    private Integer Vehicle_idVehicle;
    private Integer Vehicle_Vehicle_State_idVehicleState;
    private Integer Vehicle_Driver_idDriver;

    /**
     * @return the idExecutionAlgorithmByVehicle
     */
    public Integer getIdExecutionAlgorithmByVehicle() {
        return idExecutionAlgorithmByVehicle;
    }

    /**
     * @param idExecutionAlgorithmByVehicle the idExecutionAlgorithmByVehicle to set
     */
    public void setIdExecutionAlgorithmByVehicle(Integer idExecutionAlgorithmByVehicle) {
        this.idExecutionAlgorithmByVehicle = idExecutionAlgorithmByVehicle;
    }

    /**
     * @return the route
     */
    public String getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * @return the Execution_Algorithm_idExecutionAlgorithm
     */
    public Integer getExecution_Algorithm_idExecutionAlgorithm() {
        return Execution_Algorithm_idExecutionAlgorithm;
    }

    /**
     * @param Execution_Algorithm_idExecutionAlgorithm the Execution_Algorithm_idExecutionAlgorithm to set
     */
    public void setExecution_Algorithm_idExecutionAlgorithm(Integer Execution_Algorithm_idExecutionAlgorithm) {
        this.Execution_Algorithm_idExecutionAlgorithm = Execution_Algorithm_idExecutionAlgorithm;
    }

    /**
     * @return the Vehicle_idVehicle
     */
    public Integer getVehicle_idVehicle() {
        return Vehicle_idVehicle;
    }

    /**
     * @param Vehicle_idVehicle the Vehicle_idVehicle to set
     */
    public void setVehicle_idVehicle(Integer Vehicle_idVehicle) {
        this.Vehicle_idVehicle = Vehicle_idVehicle;
    }

    /**
     * @return the Vehicle_Vehicle_State_idVehicleState
     */
    public Integer getVehicle_Vehicle_State_idVehicleState() {
        return Vehicle_Vehicle_State_idVehicleState;
    }

    /**
     * @param Vehicle_Vehicle_State_idVehicleState the Vehicle_Vehicle_State_idVehicleState to set
     */
    public void setVehicle_Vehicle_State_idVehicleState(Integer Vehicle_Vehicle_State_idVehicleState) {
        this.Vehicle_Vehicle_State_idVehicleState = Vehicle_Vehicle_State_idVehicleState;
    }

    /**
     * @return the Vehicle_Driver_idDriver
     */
    public Integer getVehicle_Driver_idDriver() {
        return Vehicle_Driver_idDriver;
    }

    /**
     * @param Vehicle_Driver_idDriver the Vehicle_Driver_idDriver to set
     */
    public void setVehicle_Driver_idDriver(Integer Vehicle_Driver_idDriver) {
        this.Vehicle_Driver_idDriver = Vehicle_Driver_idDriver;
    }
}
