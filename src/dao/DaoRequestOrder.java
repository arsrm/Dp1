/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.RequestOrder;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoRequestOrder {
     public List<RequestOrder> requestOrderQry();
    
    public List<RequestOrder> requestOrderQry_search(String ruc , String dateFrom, String dateTo);
    
    public String requestOrderIns(RequestOrder requestOrder);
    
    public String requestOrderDel(List<String> ids);
    
    public RequestOrder requestOrderGet(String idRequestOrder);
    
    public String requestOrderUpd(RequestOrder requestOrder);
    
}
