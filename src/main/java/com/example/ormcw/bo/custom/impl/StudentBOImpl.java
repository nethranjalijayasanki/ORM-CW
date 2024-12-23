package com.example.ormcw.bo.custom.impl;

import com.example.ormcw.bo.custom.StudentBO;
import com.example.ormcw.dao.DAOFactory;
import com.example.ormcw.dao.custom.StudentDAO;
import com.example.ormcw.dto.StudentDTO;
import com.example.ormcw.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Student);

    public boolean saveStudent(StudentDTO studentDTO) {
        return studentDAO.save( new Student(studentDTO.getS_id(),studentDTO.getS_name(), studentDTO.getAddress(),studentDTO.getContact_no(),studentDTO.getEmail(),null));
    }

    public String getCurrentStudentId() throws SQLException {
        return studentDAO.getCurrentId();
    }

    public boolean updateStudent(StudentDTO studentDTO) {
        return studentDAO.update(new Student(studentDTO.getS_id(),studentDTO.getS_name(), studentDTO.getAddress(),studentDTO.getContact_no(),studentDTO.getEmail(),null));
    }

    @Override
    public StudentDTO searchStudentId(String id) {
        Student student = studentDAO.searchId(id);
        return new StudentDTO(student.getS_id(),student.getS_name(),student.getAddress(),student.getContact_no(),student.getEmail());
    }

    @Override
    public List<StudentDTO> getAllCustomer() throws SQLException,ClassNotFoundException{

        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<Student> students = studentDAO.getAll();

        for (Student student:students) {
            StudentDTO studentDTO = new StudentDTO(student.getS_id(),student.getS_name(),student.getAddress(),student.getContact_no(),student.getEmail() );
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    public boolean delete(String id){
        return studentDAO.delete(id);
    }

    public List<Student> getStudentWithEnrolledPrograms(){
        return studentDAO.getStudentWithEnrolledPrograms();
    }

}
