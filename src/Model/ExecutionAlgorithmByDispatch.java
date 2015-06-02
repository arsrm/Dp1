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
public class ExecutionAlgorithmByDispatch {
    private Integer idExecutionAlgorithmByDispatch;
    private Integer Dispatch_Order_idDispatch_Order;
    private Integer Execution_Algorithm_idExecutionAlgorithm;
    private Integer status;

    /**
     * @return the idExecutionAlgorithmByDispatch
     */
    public Integer getIdExecutionAlgorithmByDispatch() {
        return idExecutionAlgorithmByDispatch;
    }

    /**
     * @param idExecutionAlgorithmByDispatch the idExecutionAlgorithmByDispatch to set
     */
    public void setIdExecutionAlgorithmByDispatch(Integer idExecutionAlgorithmByDispatch) {
        this.idExecutionAlgorithmByDispatch = idExecutionAlgorithmByDispatch;
    }

    /**
     * @return the Dispatch_Order_idDispatch_Order
     */
    public Integer getDispatch_Order_idDispatch_Order() {
        return Dispatch_Order_idDispatch_Order;
    }

    /**
     * @param Dispatch_Order_idDispatch_Order the Dispatch_Order_idDispatch_Order to set
     */
    public void setDispatch_Order_idDispatch_Order(Integer Dispatch_Order_idDispatch_Order) {
        this.Dispatch_Order_idDispatch_Order = Dispatch_Order_idDispatch_Order;
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
}
