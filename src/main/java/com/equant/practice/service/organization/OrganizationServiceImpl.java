package com.equant.practice.service.organization;

import com.equant.practice.ResponseView;
import com.equant.practice.dao.organization.OrganizationDao;
import com.equant.practice.dto.organization.OrgRequest;
import com.equant.practice.dto.organization.OrganizationDTOForGetAndUpdate;
import com.equant.practice.dto.organization.OrganizationDTOForList;
import com.equant.practice.mapper.MapperFacade;
import com.equant.practice.model.Organization;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@NoArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {


    OrganizationDao organizationDao;
    MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }


    @Transactional
    @Override
    public OrganizationDTOForGetAndUpdate findByID(long id) {

        return mapperFacade.map(organizationDao.findByID(id), OrganizationDTOForGetAndUpdate.class);
    }

    @Transactional
    @Override
    public List<OrganizationDTOForList> findByName(OrgRequest orgRequest) {

        return mapperFacade.mapAsList(organizationDao.findByName(orgRequest), OrganizationDTOForList.class);
    }

    @Transactional
    @Override
    public ResponseView update(@Validated OrganizationDTOForGetAndUpdate org) {

        return organizationDao.update(mapperFacade.map(org,Organization.class));
    }

    @Transactional
    @Override
    public ResponseView add(Organization org) {

        return organizationDao.add(org);
    }
}
