package com.example.ormcw.bo.custom;

import com.example.ormcw.bo.SuperBO;
import com.example.ormcw.dto.StudentDTO;
import com.example.ormcw.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean saveStudent(StudentDTO studentDTO);

    public String getCurrentStudentId() throws SQLException;

    public boolean updateStudent(StudentDTO studentDTO);

    StudentDTO searchStudentId(String id);

    List<StudentDTO> getAllCustomer() throws SQLException,ClassNotFoundException;

    public boolean delete(String id);

    public List<Student> getStudentWithEnrolledPrograms();

}
