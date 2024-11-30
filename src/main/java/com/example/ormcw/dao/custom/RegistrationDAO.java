package com.example.ormcw.dao.custom;

import com.example.ormcw.dao.CrudDAO;
import com.example.ormcw.entity.Registration;
import org.hibernate.Session;

import java.util.List;

public interface RegistrationDAO extends CrudDAO<Registration> {
    boolean saveRegistration(List<Registration> registrationList, Session session);

    int getCurrentId();
}
