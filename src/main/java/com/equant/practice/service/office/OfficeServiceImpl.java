package com.equant.practice.service.office;

import com.equant.practice.ResponseView;
import com.equant.practice.dao.office.OfficeDao;
import com.equant.practice.dto.office.OfficeDTOForGet;
import com.equant.practice.dto.office.OfficeDTOForList;
import com.equant.practice.dto.office.OfficeDTORequestForAdd;
import com.equant.practice.dto.office.OfficeDTORequestForList;
import com.equant.practice.mapper.MapperFacade;
import com.equant.practice.model.Office;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
public class OfficeServiceImpl implements OfficeService {
    private ResponseView responseView;

    OfficeDao officeDao;
    MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao ;
        this.mapperFacade = mapperFacade;
    }


    @Transactional
    @Override
    public OfficeDTOForGet findByID(long id) {
        return mapperFacade.map(officeDao.findByID(id), OfficeDTOForGet.class);
    }

    @Transactional
    @Override
    public List<OfficeDTOForList> findByOrgId(OfficeDTORequestForList officeDTORequestForList) {
        return mapperFacade.mapAsList(officeDao.findByOrgId(officeDTORequestForList),OfficeDTOForList.class);
    }
    @Transactional
    @Override
    public ResponseView update(OfficeDTOForGet office) {
        return officeDao.update(mapperFacade.map(office,Office.class));
    }

    @Transactional
    @Override
    public ResponseView add(OfficeDTORequestForAdd officeDTOForUpdateRequest) {
        Long orgId = officeDTOForUpdateRequest.getOrgId();
        Office office = mapperFacade.map(officeDTOForUpdateRequest,Office.class);
        return officeDao.add(office, orgId);
    }
}
