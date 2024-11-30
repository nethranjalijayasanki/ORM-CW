package com.example.ormcw.dao.custom;

import com.example.ormcw.dao.CrudDAO;
import com.example.ormcw.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {

    public  String getCurrentId() throws SQLException;

    public Student searchId(String id);

    public List<Student> getStudentWithEnrolledPrograms();



}
