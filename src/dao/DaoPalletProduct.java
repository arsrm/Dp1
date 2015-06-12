/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import Model.LocationCell;
import Model.LocationCellDetail;
import Model.PalletIni;
import Model.PalletProduct;
import Model.Product;
import Model.Rack;
import Model.DispatchOrder;
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
    
    public Rack GetRackid(Integer idCD, Integer idware, Integer idrack);

    public Integer GetCantNumord(Integer numorden);
    
    public Integer GetCantNumpicking(Integer numpicking);
    
    public LocationCell GetLocationCellId(Integer idCD,Integer idware, Integer idrack, Integer idcelda );

    public LocationCellDetail GetLocationCellDetailId(Integer idCD,Integer idware, Integer idrack, Integer idcelda,Integer idceldadet );
            
    public Product GetProduct(Integer idmark, String nameproduct);
    
    public Product GetProductId(Integer idmark, Integer idproduct);

    public List<Product> GetProductList(Integer idmark);
    
    public List<PalletProduct> GetPalletProductList(String CadenaWhere); 

    public List<DispatchOrder> GetDispatchOrderList(String CadenaWhere); 
    
    public List<PalletProduct> GetPalletProductList2(String CadenaWhere); 
    
    public String PalletProductDelMasive(List<Integer> idpallet, List<Integer> idmark, List<Integer> idproduct,List<Integer> idstatus );    
   
    public String PalletProductLocationDelMasive(List<Integer> listidpallet, List<Integer> listidmarca, List<Integer> listidproduct,List<Integer> listidCD,List<Integer> listware,List<Integer>listrack,List<Integer>listcelda,List<Integer>listceldadet,List<Integer>listidstatus );    

    public String PalletProductInsMasive(List<Integer>listidpallet, Integer idmarca, Integer idproduct,Date expirationDate,Integer idIntOrd);
    
    public List<Integer> GetPalletByStatus(Integer status, Integer cantPallets);
    
    public List<Integer> GetPalletsByIntOrder(Integer idIntOrder, Integer IdProd);
    
    public PalletProduct getPalletProductById(Integer idPalletProduct);
}
