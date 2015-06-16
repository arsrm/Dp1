/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.InternmentOrder;
import Model.LocationCellDetailInventory;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public interface DaoInternmentOrder {

    public List<InternmentOrder> IntOrderQry();

    public String IntOrderIns(InternmentOrder intOrder);
//

    public String IntOrderDel(List<Integer> ids);
////
//
    public InternmentOrder IntOrderGet(Integer idIntOrder);
////
//
//    public String IntOrderUpd(InternmentOrder intOrder);

//    public List<Object[]> usersCbo();    
//    
//    public Integer ProductsGetMaxID ();
//    
    public List<InternmentOrder> IntOrderSearch(Integer idIntOrder, Date dateIni, Date dateEnd);
    
    public String IntOrdersIntern(List<Integer> ids);
    
    public String IntOrdersInternAdjustManual(List<InternmentOrder> listIntOrd);
    
    public String IntOrdersInternAdjustManual(List<InternmentOrder> listIntOrd, LocationCellDetailInventory locCelInv);
    
    public void IntOrdUpdStatus(Integer intOrd, Integer status);
}
