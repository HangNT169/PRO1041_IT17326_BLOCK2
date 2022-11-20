/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group1.response;

import com.poly.it17326.group1.domainmodel.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author hangnt
 */
@Getter
@Setter
@ToString
public class ViewProductResponse {

    private Long productID;
    private String categoryCode;
    private String categoryName;
    private String productName;
    private Float price;

    public ViewProductResponse() {
    }

//    Mapping du lieu
    public ViewProductResponse(Product product) {
        this.productID = product.getId();
        this.categoryCode = product.getCategory().getCategoryCode();
        this.categoryName = product.getCategory().getCategoryName();
        this.productName = product.getProductName();
        this.price = product.getPrice();
    }

}
