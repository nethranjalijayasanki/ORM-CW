package com.example.ormcw.bo.custom;

import com.example.ormcw.bo.SuperBO;
import com.example.ormcw.dto.ProgramDTO;

import java.sql.SQLException;
import java.util.List;

public interface ProgramBO extends SuperBO {
    public boolean saveProgram(ProgramDTO programDTO);

    public String getCurrentProgramId() throws SQLException;


    public boolean updateProgram(ProgramDTO programDTO);

    public ProgramDTO searchProgramId(String id) ;


    public List<ProgramDTO> getAllPrograms() throws SQLException,ClassNotFoundException;

    public boolean delete(String id);

    ProgramDTO searchProgramByName(String name);

    public List<String> getProgramNamesByStudentId(String studentId);
}
