/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.PalletIni;
import java.util.List;

/**
 *
 * @author gzavala
 */
public interface DaoPalletIni {
    
    public List<PalletIni>PalletIniQry();
    
    public String PalletIniIns(PalletIni palletini);
    
    public String PalletIniDel(PalletIni palletini);
    
    public String PalletIniUpd(PalletIni palletini);
    
    public PalletIni PalletIniGet(Integer idpallet);
    
    
    
}