/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.RequestOrderDetail;
import Model.RequestOrderDetail;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoRequestOrderDetail {
    
    public List<RequestOrderDetail> requestOrderDetailQry(Integer idOrder);

    public String requestOrderIns(RequestOrderDetail requestOrderDetail);
    
    public String requestOrderDetailDel(Integer idRequestOrderDetail, Integer idRequestOrder, Integer status);
    
    public RequestOrderDetail requestOrderDetailGet(Integer idRequestOrderDetail, Integer idRequestOrder);
    
    public String requestOrderDetailUpd(RequestOrderDetail requestOrderDetail);
    
    public String requestOrderDetailsDel(List<Integer> idOrderDetailList, Integer idRequestOrder);
}
