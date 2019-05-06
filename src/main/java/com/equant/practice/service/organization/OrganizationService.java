package com.equant.practice.service.organization;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.organization.OrgRequest;
import com.equant.practice.dto.organization.OrganizationDTOForAdd;
import com.equant.practice.dto.organization.OrganizationDTOForGetAndUpdate;
import com.equant.practice.dto.organization.OrganizationDTOForList;
import com.equant.practice.model.Organization;

import java.util.List;

public interface OrganizationService {
    OrganizationDTOForGetAndUpdate findByID(long id);

    List<OrganizationDTOForList> findByName(OrgRequest orgRequest);

    ResponseView update(OrganizationDTOForGetAndUpdate org);

    ResponseView add(OrganizationDTOForAdd org);

}
