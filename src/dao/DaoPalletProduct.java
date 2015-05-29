/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import Model.PalletIni;
import Model.Product;
import Model.Trademark;
import Model.PalletProduct;
import java.util.List;

/**
 *
 * @author gzavala
 */
public interface DaoPalletProduct {

    public Trademark GetTrademarkname(String namemark); 
    
    public Trademark GetTradamarkid(Integer idmark); 
            
    public Product GetProduct(String nameproduct);
    
    public List<Product> GetProductList(Integer idmark);
    
    public List<PalletProduct> GetPalletProductList(String CadenaWhere); 
    
    public String PalletProductDelMasive(List<Integer> idpallet, List<Integer> idmark, List<Integer> idproduct,List<Integer> idstatus );    
    
}