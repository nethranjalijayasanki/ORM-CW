package com.example.ormcw.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Payment;
import org.hibernate.Session;

public interface PaymentDAO extends CrudDAO<Payment> {
    public boolean savePayment(Payment entity, Session session);
}
