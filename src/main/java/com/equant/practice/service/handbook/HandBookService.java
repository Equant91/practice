package com.equant.practice.service.handbook;

import com.equant.practice.dto.country.CountryDTO;
import com.equant.practice.dto.document.DocumentDTO;

import java.util.List;

public interface HandBookService {
    List<DocumentDTO> getAllDocument();
    List<CountryDTO> getAllCountry();

}
