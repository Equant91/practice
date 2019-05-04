package com.equant.practice.service.organization;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.organization.OrgRequest;
import com.equant.practice.dto.organization.OrganizationDTOForGet;
import com.equant.practice.dto.organization.OrganizationDTOForList;
import com.equant.practice.model.Organization;

import java.util.List;

public interface OrganizationService {
    OrganizationDTOForGet findByID(long id);

    List<OrganizationDTOForList> findByName(OrgRequest orgRequest);

    ResponseView update(OrganizationDTOForGet org);

    ResponseView add(Organization org);

}
