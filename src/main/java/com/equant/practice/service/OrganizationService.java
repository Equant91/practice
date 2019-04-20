package com.equant.practice.service;

import com.equant.practice.ResponseView;
import com.equant.practice.model.Organization;

public interface OrganizationService {
    Organization findByID(long id);
    Organization findByName(String name);
    ResponseView update(Organization org);
    ResponseView add(Organization org);

}
