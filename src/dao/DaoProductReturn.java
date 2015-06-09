/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.DispatchOrder;
import Model.ProductReturn;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoProductReturn {
    
    public List<ProductReturn> productReturnQry();
    
    public List<ProductReturn> productReturnQry(Integer idClient, Date dateFrom, Date dateTo, Integer status);
    
    public List<ProductReturn> productReturnQry_search(String dni , String name);
    
    public String productReturnIns(ProductReturn productReturn);
    
    public String productReturnDel(List<String> ids);
    
    public ProductReturn productReturnGet(String idproductReturn);
    
    public String productReturnUpd(ProductReturn productReturn);
    
    public List<DispatchOrder> dispatchOrderInDevolution(Integer idClient, Date dateFrom, Date dateTo, Integer status);
}
