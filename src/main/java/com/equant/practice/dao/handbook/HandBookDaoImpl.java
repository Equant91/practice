package com.equant.practice.dao.handbook;

import com.equant.practice.model.Country;
import com.equant.practice.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class HandBookDaoImpl implements HandBookDao {

    private final EntityManager em;

    @Autowired
    public HandBookDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Document loadDocById(long id) {
        return em.find(Document.class, id);
    }

    @Override
    public List<Document> allDocument() {
        TypedQuery<Document> query = em.createQuery("Select d From Document d", Document.class);
        return query.getResultList();
    }

    @Override
    public Country loadCountryById(long id) {
        return em.find(Country.class, id);
    }

    @Override
    public List<Country> allCountry() {
        TypedQuery<Country> query = em.createQuery("Select c From Country c", Country.class);
        return query.getResultList();
    }
}
