package com.equant.practice.dao.office;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.office.OfficeDTORequestForList;
import com.equant.practice.model.Office;

import java.util.List;

public interface OfficeDao {
    Office findByID(long id);

    List<Office> findByOrgId(OfficeDTORequestForList officeDTORequestForList);

    ResponseView update(Office office);

    ResponseView add(Office office, Long orgId);

}
