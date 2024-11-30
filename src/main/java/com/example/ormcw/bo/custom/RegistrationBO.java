package com.example.ormcw.bo.custom;

import com.example.ormcw.bo.SuperBO;
import com.example.ormcw.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationBO extends SuperBO {
    void placeRegister(List<RegistrationDTO> registrationDTOList);

    int getCurrentRegistrationId();
}
