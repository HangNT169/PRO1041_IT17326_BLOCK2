/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group1.repository;

import com.poly.it17326.group1.config.HibernateConfig;
import com.poly.it17326.group1.domainmodel.Product;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author hangnt
 */
public class ProductRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM Product"; // HQL 

    public List<Product> getAll() {
        Query query = session.createQuery(fromTable, Product.class);
        return query.getResultList();
    }

}
