/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import Model.Pallet;
import java.util.*;

/**
 *
 * @author gzavala
 */
public interface DaoPallet {

    public List<Pallet>PalletQry();
    
    public String PalletIns(Pallet pallet);
   
    public String PalletDel(Pallet pallet ); 
    
    public String PalletUpd(Pallet pallet);
    
    public Pallet PalletGet(Integer idpallet);
    
    public List<Object[]> PalletCbo();
}
