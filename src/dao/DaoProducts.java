/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Product;
import Model.Users;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public interface DaoProducts {

    public List<Product> ProductsQry();

    public String ProductsIns(Product product);
//
    public String ProductsDel(List<Integer> ids);
//
    public Product ProductsGet(Integer idProduct);
//
    public String ProductsUpd(Product product);

//    public List<Object[]> usersCbo();    
    
    public Integer ProductsGetMaxID ();
}
