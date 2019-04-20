package com.equant.practice.service;

import com.equant.practice.ResponseView;
import com.equant.practice.model.Organization;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    public Organization getOrganization() {
        return organization;
    }

    private Organization organization = new Organization();

    ResponseView responseView;

    public OrganizationServiceImpl() {
    }

    @Transactional
    @Override
    public Organization findByID(long id) {

        organization.setAddress("ул.Цюрупы");
        organization.setFull_name("Центр социального обслудивания Гармония");
        organization.setName("Гармония");
        organization.setInn("3903243212");
        return organization;
    }

    @Transactional
    @Override
    public Organization findByName(String name) {

        organization.setAddress("ул.Цюрупы");
        organization.setFull_name("Центр социального обслудивания Гармония");
        organization.setName("Гармония");
        organization.setInn("3903243212");
        return organization;
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
