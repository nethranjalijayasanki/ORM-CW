package com.example.ormcw.dao.custom;

import com.example.ormcw.dao.CrudDAO;
import com.example.ormcw.entity.Program;

import java.sql.SQLException;
import java.util.List;

public interface ProgramDAO  extends CrudDAO<Program> {
    public  String getCurrentId() throws SQLException;

    public Program searchId(String id);

    Program searchByName(String name);

    public List<String> getProgramNamesByStudentId(String studentId);


}
