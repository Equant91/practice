package com.equant.practice.service.organization;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.organization.OrgDTORequestForList;
import com.equant.practice.dto.organization.OrganizationDTOForAdd;
import com.equant.practice.dto.organization.OrganizationDTOForGetAndUpdate;
import com.equant.practice.dto.organization.OrganizationDTOResponseForList;

import java.util.List;

public interface OrganizationService {

    OrganizationDTOForGetAndUpdate findByID(long id);

    List<OrganizationDTOResponseForList> findByName(OrgDTORequestForList orgDTORequestForList);

    ResponseView update(OrganizationDTOForGetAndUpdate org);

    ResponseView add(OrganizationDTOForAdd org);

}
