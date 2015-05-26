/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Gustavo
 */
public class InternmentOrderDetail {
    private Integer idInternmentOrderDetail;
    private Integer quantityPallets;
    private Integer status;
    private Product product;

    /**
     * @return the idInternmentOrderDetail
     */
    public Integer getIdInternmentOrderDetail() {
        return idInternmentOrderDetail;
    }

    /**
     * @param idInternmentOrderDetail the idInternmentOrderDetail to set
     */
    public void setIdInternmentOrderDetail(Integer idInternmentOrderDetail) {
        this.idInternmentOrderDetail = idInternmentOrderDetail;
    }

    /**
     * @return the quantityPallets
     */
    public Integer getQuantityPallets() {
        return quantityPallets;
    }

    /**
     * @param quantityPallets the quantityPallets to set
     */
    public void setQuantityPallets(Integer quantityPallets) {
        this.quantityPallets = quantityPallets;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
