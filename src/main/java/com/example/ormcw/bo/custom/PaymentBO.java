package com.example.ormcw.bo.custom;

import com.example.ormcw.bo.SuperBO;
import com.example.ormcw.entity.Payment;

public interface PaymentBO extends SuperBO {
    public Object[] getProgramPaymentDetails(String studentId, String programId);

    public boolean savePayment(Payment payment);
}
