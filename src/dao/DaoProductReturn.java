/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.ProductReturn;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoProductReturn {
    
    public List<ProductReturn> productReturnQry();
    
    public List<ProductReturn> productReturnQry_search(String dni , String name);
    
    public String productReturnIns(ProductReturn productReturn);
    
    public String productReturnDel(List<String> ids);
    
    public ProductReturn productReturnGet(String idproductReturn);
    
    public String productReturnUpd(ProductReturn productReturn);
    
    
}
