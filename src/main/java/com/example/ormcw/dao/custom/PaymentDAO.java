package com.example.ormcw.dao.custom;

import com.example.ormcw.dao.CrudDAO;
import com.example.ormcw.entity.Payment;
import org.hibernate.Session;

public interface PaymentDAO extends CrudDAO<Payment> {
    public boolean savePayment(Payment entity, Session session);
}
