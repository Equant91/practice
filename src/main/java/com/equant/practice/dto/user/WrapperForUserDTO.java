package com.equant.practice.dto.user;

import com.equant.practice.model.CertainDocument;
import com.equant.practice.model.Country;
import com.equant.practice.model.Document;
import com.equant.practice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WrapperForUserDTO {
    User user ;
    CertainDocument certainDocument;
    Document document;
    Country country;
}
