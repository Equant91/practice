package com.equant.practice.service.organization;

import com.equant.practice.ResponseView;
import com.equant.practice.model.Organization;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    ResponseView responseView;

    private Organization getOrganizationForTest() {
        Organization organization = new Organization();
        organization.setAddress("ул.Цюрупы");
        organization.setFull_name("Центр социального обслудивания Гармония");
        organization.setName("Гармония");
        organization.setInn("3903243212");
        return organization;
    }

    @Transactional
    @Override
    public Organization findByID(long id) {
        return getOrganizationForTest();
    }

    @Transactional
    @Override
    public Organization findByName(String name) {
        return getOrganizationForTest();
    }

    @Transactional
    @Override
    public ResponseView update(Organization org) {
        return responseView = new ResponseView(true);
    }

    @Transactional
    @Override
    public ResponseView add(Organization org) {
        return responseView = new ResponseView(true);
    }
}
