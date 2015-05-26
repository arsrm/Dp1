/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.RequestOrderDetail;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoRequestOrderDetail {
    
     public String requestOrderIns(RequestOrderDetail requestOrderDetail);
    
    public String requestOrderDetailDel(List<String> ids);
    
    public RequestOrderDetail requestOrderDetailGet(String idRequestOrderDetail);
    
    public String requestOrderDetailUpd(RequestOrderDetail requestOrder);
}
