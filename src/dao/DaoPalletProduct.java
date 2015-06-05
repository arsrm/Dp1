/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import Model.PalletIni;
import Model.PalletProduct;
import Model.Product;
import Model.Trademark;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gzavala
 */
public interface DaoPalletProduct {

    public Trademark GetTrademarkname(String namemark); 
    
    public Trademark GetTradamarkid(Integer idmark); 
            
    public Product GetProduct(Integer idmark, String nameproduct);
    
    public List<Product> GetProductList(Integer idmark);
    
    public List<PalletProduct> GetPalletProductList(String CadenaWhere); 
    
    public String PalletProductDelMasive(List<Integer> idpallet, List<Integer> idmark, List<Integer> idproduct,List<Integer> idstatus );    
   
    public String PalletProductInsMasive(List<Integer>listidpallet, Integer idmarca, Integer idproduct,Date expirationDate,Integer idIntOrd);
    
    public List<Integer> GetPalletByStatus(Integer status, Integer cantPallets);
    
    public List<Integer> GetPalletsByIntOrder(Integer idIntOrder, Integer IdProd);
}
