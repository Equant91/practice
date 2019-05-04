package com.equant.practice.service.office;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.office.OfficeDTOForGet;
import com.equant.practice.dto.office.OfficeDTOForList;
import com.equant.practice.dto.office.OfficeDTORequestForAdd;
import com.equant.practice.dto.office.OfficeDTORequestForList;
import com.equant.practice.model.Office;

import java.util.List;

public interface OfficeService {

        OfficeDTOForGet findByID(long id);
        List<OfficeDTOForList> findByOrgId(OfficeDTORequestForList officeDTORequestForList);
        ResponseView update(Office office);
        ResponseView add(OfficeDTORequestForAdd office);

}
