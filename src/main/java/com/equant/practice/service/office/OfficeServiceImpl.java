package com.equant.practice.service.office;

import com.equant.practice.ResponseView;
import com.equant.practice.model.Office;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
public class OfficeServiceImpl implements OfficeService {
    private ResponseView responseView;

    private Office getOfficeForTest() {
        Office office = new Office();
        office.setName("Центральный");
        office.setAddress("ул.Цюрупы");
        office.setPhone("899889");
        return office;
    }

    @Transactional
    @Override
    public Office findByID(long id) {
        return getOfficeForTest();
    }
    @Transactional
    @Override
    public Office findByName(String name) {
        return getOfficeForTest();
    }
    @Transactional
    @Override
    public ResponseView update(Office office) {
        return responseView = new ResponseView(true);
    }
    @Transactional
    @Override
    public ResponseView add(Office office) {
        return responseView = new ResponseView(true);
    }
}
