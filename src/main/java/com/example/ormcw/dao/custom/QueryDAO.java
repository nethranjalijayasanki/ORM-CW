package com.example.ormcw.dao.custom;

import com.example.ormcw.dao.SuperDAO;

public interface QueryDAO extends SuperDAO {
    public Object[] getProgramPaymentDetails(String studentId, String programId);

}
