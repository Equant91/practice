package com.equant.practice.dao.organization;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.organization.OrgDTORequestForList;
import com.equant.practice.model.Organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {


    private EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Organization findByID(long id) {

        return em.find(Organization.class, id);
    }

    @Override
    public List<Organization> findByName(OrgDTORequestForList orgDTORequestForList) {
        String name = orgDTORequestForList.getName();
        String inn = orgDTORequestForList.getInn();
        Boolean isActive = orgDTORequestForList.getIsActive();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);

        List<Predicate> predicates = new ArrayList<>();
        Predicate namePredicate = builder.equal(organizationRoot.get("name"), name);
        predicates.add(namePredicate);
        if (inn!=null) {
            Predicate innPredicate = builder.equal(organizationRoot.get("inn"), inn);
            predicates.add(innPredicate);
        }
        if (isActive != null) {
            Predicate isActivePredicate = builder.equal(organizationRoot.get("isActive"), isActive.booleanValue());
            predicates.add(isActivePredicate);
        }
        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        criteriaQuery.select(organizationRoot);
        TypedQuery<Organization> typedQuery = em.createQuery(criteriaQuery);
        List<Organization> organizationList= typedQuery.getResultList();
        return organizationList;

    }

    @Override
    public ResponseView update(Organization org) {
      Organization organization =  em.merge(org);
        return new ResponseView(em.contains(organization));
    }

    @Override
    public ResponseView add(Organization org) {
        em.persist(org);
        return new ResponseView(em.contains(org));
    }
}
