package com.example.ormcw.dao;

import com.example.ormcw.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class SQLUtil implements SuperDAO {

    public Object[] getProgramPaymentDetails(String studentId, String programId) {
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            // HQL Query
            String hql = "SELECT p.fee, r.upfrontpayment, SUM(pay.amount) " +
                    "FROM Registration r " +
                    "JOIN r.program p " +
                    "JOIN r.payment pay " +
                    "WHERE r.student.s_id = :studentId AND p.pId = :programId";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            query.setParameter("studentId", studentId);
            query.setParameter("programId", programId);

            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

}
