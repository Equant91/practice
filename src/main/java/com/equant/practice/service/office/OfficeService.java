package com.equant.practice.service.office;

import com.equant.practice.ResponseView;
import com.equant.practice.model.Office;
import com.equant.practice.model.Organization;
public interface OfficeService {

        Office findByID(long id);
        Office findByName(String name);
        ResponseView update(Office office);
        ResponseView add(Office office);

}
