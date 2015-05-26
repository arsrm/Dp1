/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.InternmentOrderDetail;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public interface DaoInternmentOrderDetail {

    public List<InternmentOrderDetail> IntOrderDetailQry(Integer idIntOrder);

    public String IntOrderDetailIns(Integer idIntOrder,InternmentOrderDetail intOrderDetail);
//

    public String IntOrderDetailsDel(Integer idIntOrder,List<Integer> idsIntOrdDetail);
////
//
//    public InternmentOrderDetail IntOrderDetailGet(Integer idIntOrder);
////
//
//    public String IntOrderUpd(InternmentOrderDetail intOrder);

}
