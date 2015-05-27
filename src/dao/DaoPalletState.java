/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.PalletState;
import java.util.List;

/**
 *
 * @author gzavala
 */
public interface DaoPalletState {

    public List<PalletState>PalletStateQry();
    
    public String PalletStateIns(PalletState pallet);
   
    public String PalletStateDel(PalletState pallet ); 
    
    public String PalletStateUpd(PalletState pallet);
    
    public PalletState PalletStateGet(Integer idpalletstate);
    
    public Integer PalletStateIdGet(String description); 
    
    public List<Object[]> PalletStateCbo();
    
}
