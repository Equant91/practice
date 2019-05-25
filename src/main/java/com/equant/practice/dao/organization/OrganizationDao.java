package com.equant.practice.dao.organization;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.organization.OrgDTORequestForList;
import com.equant.practice.model.Organization;

import java.util.List;

public interface OrganizationDao {

    Organization findByID(long id);

    List<Organization> findByName(OrgDTORequestForList orgDTORequestForList);

    ResponseView update(Organization org);

    ResponseView add(Organization org);

}
