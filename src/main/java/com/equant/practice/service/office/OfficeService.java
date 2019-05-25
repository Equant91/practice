package com.equant.practice.service.office;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.office.OfficeDTOForGetAndUpdate;
import com.equant.practice.dto.office.OfficeDTOResponseForList;
import com.equant.practice.dto.office.OfficeDTORequestForAdd;
import com.equant.practice.dto.office.OfficeDTORequestForList;

import java.util.List;

public interface OfficeService {

    OfficeDTOForGetAndUpdate findByID(long id);

    List<OfficeDTOResponseForList> findByOrgId(OfficeDTORequestForList officeDTORequestForList);

    ResponseView update(OfficeDTOForGetAndUpdate office);

    ResponseView add(OfficeDTORequestForAdd office);

}
