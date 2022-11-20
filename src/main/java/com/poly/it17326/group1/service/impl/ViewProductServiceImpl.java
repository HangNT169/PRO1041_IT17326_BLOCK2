/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group1.service.impl;

import com.poly.it17326.group1.domainmodel.Product;
import com.poly.it17326.group1.repository.ProductRepository;
import com.poly.it17326.group1.response.ViewProductResponse;
import com.poly.it17326.group1.service.ViewProductService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class ViewProductServiceImpl implements ViewProductService {

    private ProductRepository productRepository = new ProductRepository();

    @Override
    public List<ViewProductResponse> getProducts() {
        List<ViewProductResponse> responses = new ArrayList<>();
        List<Product> lists = productRepository.getAll(); // lay list tu repo

        // Mapping product -> productResponse 
        for (Product product : lists) {
            ViewProductResponse viewProductResponse = new ViewProductResponse(product);
            responses.add(viewProductResponse);
        }

        return responses;
    }

    public static void main(String[] args) {
        List<ViewProductResponse> lists = new ViewProductServiceImpl().getProducts();
        for (ViewProductResponse v : lists) {
            System.out.println(v.toString());
        }
    }
}
