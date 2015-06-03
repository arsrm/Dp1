/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.Movement;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kari
 */
public interface DaoKardex {
    public List<Movement> MovementSearch(Integer idProduct, Integer idwh, Date dateIni, Date dateEnd);
    public String MovementIns(Movement mov);
    public List<Movement> ProductsQry();
}
