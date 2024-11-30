package com.example.ormcw.bo;

import com.example.ormcw.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null)?  boFactory =  new BOFactory():boFactory;

    }

    public enum BOTypes{
        Student, Programs,Registration, Users, Query, Payment
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case Student:
                return new StudentBOImpl();

            case Programs:
                return  new ProgramBOImpl();

            case Registration:
                return  new RegistrationBOImpl();

            case Users:
                return  new UserBOImpl();

            case Payment:
                return  new PaymentBOImpl();



            default:
                return null;
        }
    }
}
