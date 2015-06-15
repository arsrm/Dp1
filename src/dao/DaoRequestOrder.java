/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.RequestOrder;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoRequestOrder {
     public List<RequestOrder> requestOrderQry();
    
    public List<RequestOrder> requestOrderQry_search(Integer id , Date dateFrom, Date dateTo, Integer index_status);
    
    public String requestOrderIns(RequestOrder requestOrder);
    
    public String requestOrderDel(Integer idRequestOrder);
    
    public RequestOrder requestOrderGet(Integer idRequestOrder);
    
    public String requestOrderUpd(RequestOrder requestOrder);
    
    public String requestsDel(List<Integer> requestListToDelete);
    
    public String requestsDelInvalidate(Integer idRequest);
    
    public RequestOrder requestOrderGetClient(String idclient);
      
    
}
