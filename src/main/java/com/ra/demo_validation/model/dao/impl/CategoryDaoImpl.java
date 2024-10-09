package com.ra.demo_validation.model.dao.impl;

import com.ra.demo_validation.model.dao.ICategoryDao;
import com.ra.demo_validation.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class CategoryDaoImpl implements ICategoryDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll()
    {
        try (Session session = sessionFactory.openSession())
        {
            // HQL - Hibernate Query Language
            // MySQL -
            return session.createQuery("select c from Category as c", Category.class).list();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    // DTO - Data Transfer Object

    @Override
    public boolean save(Category category)
    {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession())
        {
            tx = session.beginTransaction();
            session.save(category);
            tx.commit();
            return true;
        }
        catch (Exception e)
        {
            if (tx != null)
            {
                tx.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existByCategoryName(String categoryName)
    {
        try (Session session = sessionFactory.openSession())
        {
            // HQL - Hibernate query language
            Long count = session.createQuery("select count(c) from Category c where c.categoryName like :categoryName",Long.class)
                    .setParameter("categoryName",categoryName)
                    .getSingleResult();

//            Viết dưới dạng MySQL
//            Object count = session.createNativeQuery("select count(id) from categories where category_name like :categoryName")
//                    .setParameter("categoryName",categoryName)
//                    .getSingleResult();
//            System.out.println(count);
//            return !count.equals(0);
            return count > 0;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
