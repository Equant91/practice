package com.equant.practice.dao.office;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.office.OfficeDTORequestForList;
import com.equant.practice.model.Office;
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
public class OfficeDaoImpl implements OfficeDao {

    private EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Office findByID(long id) {
        return em.find(Office.class, id);
    }

    @Override
    public List<Office> findByOrgId(OfficeDTORequestForList officeDTORequestForList) {
        Long orgId = officeDTORequestForList.getOrgId();
        String name = officeDTORequestForList.getName();
        String phone = officeDTORequestForList.getPhone();
        Boolean isActive = officeDTORequestForList.getIsActive();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = builder.createQuery(Office.class);
        Root<Office> officeRoot = criteriaQuery.from(Office.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);

        List<Predicate> predicates = new ArrayList<>();
        Predicate orgIdPredicate = builder.equal(organizationRoot.get("id"), orgId);
        predicates.add(orgIdPredicate);

        if (phone!=null) {
            Predicate phonePredicate = builder.equal(officeRoot.get("phone"), phone);
            predicates.add(phonePredicate);
        }
        if (isActive != null) {
            Predicate isActivePredicate = builder.equal(officeRoot.get("isActive"), isActive.booleanValue());
            predicates.add(isActivePredicate);
        }
        if (name!=null) {
            Predicate phonePredicate = builder.equal(officeRoot.get("name"), name);
            predicates.add(phonePredicate);
        }
        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        criteriaQuery.select(officeRoot);
        TypedQuery<Office> typedQuery = em.createQuery(criteriaQuery);
        List<Office> offices= typedQuery.getResultList();
        return offices;

    }

    @Override
    public ResponseView update(Office office) {
       Office officeMerge = em.merge(office);
        return new ResponseView(em.contains(officeMerge));
    }

    @Override
    public ResponseView add(Office office, Long orgId) {
        Organization organization = em.find(Organization.class,orgId);
        office.addOrganizations(organization);
        em.persist(office);
        return new ResponseView(em.contains(office));
    }
}
