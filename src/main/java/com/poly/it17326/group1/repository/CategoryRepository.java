/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group1.repository;

import com.poly.it17326.group1.config.HibernateConfig;
import com.poly.it17326.group1.domainmodel.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hangnt
 */
public class CategoryRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM Category"; // HQL 

    public List<Category> getAll() {
        Query query = session.createQuery(fromTable, Category.class);
        return query.getResultList();
    }

    public Category getOne(Long id) {
        String sql = fromTable + " WHERE id =:id ";
        Query query = session.createQuery(sql, Category.class);
        query.setParameter("id", id);
        return (Category) query.getSingleResult();
    }

    public Boolean add(Category category) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(Category category) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(Category category) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<Category> categorys = new CategoryRepository().getAll();
        for (Category category : categorys) {
            System.out.println(category.toString());
        }
    }
}
