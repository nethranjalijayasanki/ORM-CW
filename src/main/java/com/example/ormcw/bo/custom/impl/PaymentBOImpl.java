package com.example.ormcw.bo.custom.impl;

import com.example.ormcw.bo.custom.PaymentBO;
import com.example.ormcw.dao.DAOFactory;
import com.example.ormcw.dao.custom.PaymentDAO;
import com.example.ormcw.dao.custom.QueryDAO;
import com.example.ormcw.entity.Payment;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Payment);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Query);


    public Object[] getProgramPaymentDetails(String studentId, String programId){
       return queryDAO.getProgramPaymentDetails(studentId,programId);
    }

    public boolean savePayment(Payment payment){
        return paymentDAO.save(payment);
    }
}
