package com.equant.practice.dao.user;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.user.UserDTORequestForList;
import com.equant.practice.model.Document;
import com.equant.practice.model.Country;
import com.equant.practice.model.DocumentType;
import com.equant.practice.model.Office;
import com.equant.practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import javax.persistence.criteria.Subquery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager em;


    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public User findByID(long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public List<User> findByOfficeId(UserDTORequestForList userDTORequestForList) {
        Long officeId = userDTORequestForList.getOfficeId();
        String firstName = userDTORequestForList.getFirstName();
        String secondName = userDTORequestForList.getSecondName();
        String middleName = userDTORequestForList.getMiddleName();
        String position = userDTORequestForList.getPosition();
        String citizenshipCode = userDTORequestForList.getCitizenshipCode();
        Long docCode = userDTORequestForList.getDocCode();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

        Root<User> userRoot = criteriaQuery.from(User.class);
        Root<Office> officeRoot = criteriaQuery.from(Office.class);
        Root<Country> countryRoot = criteriaQuery.from(Country.class);


        List<Predicate> predicates = new ArrayList<>();
        Predicate orgIdPredicate = builder.equal(officeRoot.get("id"), officeId);
        predicates.add(orgIdPredicate);

        if (firstName != null) {
            Predicate firstNamePredicate = builder.equal(userRoot.get("firstName"), firstName);
            predicates.add(firstNamePredicate);
        }
        if (secondName != null) {
            Predicate secondNamePredicate = builder.equal(userRoot.get("secondName"), secondName);
            predicates.add(secondNamePredicate);
        }
        if (middleName != null) {
            Predicate middleNamePredicate = builder.equal(userRoot.get("middleName"), middleName);
            predicates.add(middleNamePredicate);
        }

        if (position != null) {
            Predicate positionPredicate = builder.equal(userRoot.get("position"), position);
            predicates.add(positionPredicate);
        }
        if (citizenshipCode != null) {
            Predicate citizenshipCodePredicate = builder.equal(countryRoot.get("citizenshipCode"), citizenshipCode);
            predicates.add(citizenshipCodePredicate);
        }


        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        criteriaQuery.select(userRoot);
        TypedQuery<User> typedQuery = em.createQuery(criteriaQuery);
        List<User> users = typedQuery.getResultList();

        if (docCode != null) {
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                Long myDocCode = user.getDocument().getDocumentType().getDocCode();

                if (myDocCode != docCode) {
                    users.remove(user);
                }
            }
        }
        return users;
    }

    @Override
    public ResponseView update(User user, Country country, Document document, DocumentType documentType) {

        User userUpdated = em.find(User.class, 1L);
        userUpdated.setFirstName(user.getFirstName());
        userUpdated.setPosition(user.getPosition());

        if (user.getSecondName() != null) {
            userUpdated.setSecondName(user.getSecondName());
        }
        if (user.getMiddleName() != null) {
            userUpdated.setMiddleName(user.getMiddleName());
        }
        if (user.getPhone() != null) {
            userUpdated.setPhone(user.getPhone());
        }
        if (user.getIsIdentified() != null) {
            userUpdated.setIsIdentified(user.getIsIdentified());
        }
        if (document.getDocDate() != null) {
            Document documentUpdated = userUpdated.getDocument();
            documentUpdated.setDocDate(document.getDocDate());
        }
        if (document.getDocNumber() != null) {
            Document documentUpdated = userUpdated.getDocument();
            documentUpdated.setDocNumber(document.getDocNumber());
        }
        if (documentType.getDocName() != null) {
            TypedQuery<DocumentType> documentTypeTypedQuery = em.createQuery("SELECT d FROM DocumentType d WHERE d.docName = :docName", DocumentType.class);
            documentTypeTypedQuery.setParameter("docName", documentType.getDocName());
            DocumentType documentTypeUpdated = documentTypeTypedQuery.getSingleResult();
            userUpdated.getDocument().setDocumentType(documentTypeUpdated);
        }
        if (country.getCitizenshipCode() != null) {
            TypedQuery<Country> countryTypedQuery = em.createQuery("SELECT c FROM Country c WHERE c.citizenshipCode = :citizenshipCode", Country.class);
            countryTypedQuery.setParameter("citizenshipCode", country.getCitizenshipCode());
            Country countryUpdated = countryTypedQuery.getSingleResult();
            userUpdated.setCountry(countryUpdated);
        }

        return new ResponseView(em.contains(userUpdated));
    }

    @Override
    public ResponseView add(User user, Country country, Document document, DocumentType documentType, Long officeId) {
        user.setOffice(em.find(Office.class, officeId));

        if (country.getCitizenshipCode() != null) {
            TypedQuery<Country> countryTypedQuery = em.createQuery("SELECT c FROM Country c WHERE c.citizenshipCode = :citizenshipCode", Country.class);
            countryTypedQuery.setParameter("citizenshipCode", country.getCitizenshipCode());
            Country countryUpdated = countryTypedQuery.getSingleResult();
            user.setCountry(countryUpdated);
        }
        user.setDocument(document);
        if (documentType.getDocName() != null) {
            TypedQuery<DocumentType> documentTypeTypedQuery = em.createQuery("SELECT d FROM DocumentType d WHERE d.docName = :docName", DocumentType.class);
            documentTypeTypedQuery.setParameter("docName", documentType.getDocName());
            DocumentType documentTypeUpdated = documentTypeTypedQuery.getSingleResult();
            user.getDocument().setDocumentType(documentTypeUpdated);
        } else if (documentType.getDocCode() != null) {
            TypedQuery<DocumentType> documentTypeTypedQuery = em.createQuery("SELECT d FROM DocumentType d WHERE d.docCode = :docCode", DocumentType.class);
            documentTypeTypedQuery.setParameter("docCode", documentType.getDocCode());
            DocumentType documentTypeUpdated = documentTypeTypedQuery.getSingleResult();
            user.getDocument().setDocumentType(documentTypeUpdated);
        }
        em.persist(user);
        return new ResponseView(em.contains(user));
    }
}
