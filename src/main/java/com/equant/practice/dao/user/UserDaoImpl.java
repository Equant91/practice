package com.equant.practice.dao.user;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.user.UserDTORequestForList;
import com.equant.practice.dto.user.UserDTOResponseForList;
import com.equant.practice.dto.user.WrapperForUserDTO;
import com.equant.practice.model.CertainDocument;
import com.equant.practice.model.Country;
import com.equant.practice.model.Document;
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
    public WrapperForUserDTO findByID(long id) {
        User user = em.find(User.class, id);
        CertainDocument certainDocument = em.find(CertainDocument.class, user.getCertainDocument().getId());
        Document document = em.find(Document.class, certainDocument.getDocument().getId());
        Country country = em.find(Country.class, user.getCountry().getId());
        WrapperForUserDTO wrapperForUserDTO = new WrapperForUserDTO(user, certainDocument, document, country);
        System.out.println(user.getFirstName());
        return wrapperForUserDTO;
    }

    @Override
    public List<User> findByOfficeId(UserDTORequestForList userDTORequestForList) {
        Long officeId = userDTORequestForList.getOfficeId();
        String firstName = userDTORequestForList.getFirstName();
        String secondName = userDTORequestForList.getSecondName();
        String middleName = userDTORequestForList.getMiddleName();
        String position = userDTORequestForList.getPosition();
        Integer citizenshipCode = userDTORequestForList.getCitizenshipCode();
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

        if(docCode!=null) {
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                Long myDocCode = user.getCertainDocument().getDocument().getDocCode();

                if (myDocCode != docCode) {
                    users.remove(user);
                }
            }
        }
        return users;
    }

    @Override
    public ResponseView update(User user) {
        return null;
    }

    @Override
    public ResponseView add(User user) {
        return null;
    }
}
