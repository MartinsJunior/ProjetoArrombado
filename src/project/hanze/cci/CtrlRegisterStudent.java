/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.hanze.cci;

import java.sql.SQLException;
import project.hanze.cdp.Student;
import project.hanze.cgd.StudentDAO;
import project.hanze.cih.RegisterStudentFrame;

/**
 *
 * @author juniorm10
 */
public class CtrlRegisterStudent {
   RegisterStudentFrame registerStudent = new RegisterStudentFrame(this);
    
   public void startFrame(){     
        registerStudent.setVisible(true);
    }

    public void insertStudent(Student student) throws SQLException, ClassNotFoundException {
         StudentDAO.getInstance().insert(student);
    }
}
