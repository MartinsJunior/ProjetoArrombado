/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.hanze.cci;

import java.sql.SQLException;
import project.hanze.cdp.Teacher;
import project.hanze.cgd.TeacherDAO;
import project.hanze.cih.RegisterTeacherFrame;

/**
 *
 * @author juniorm10
 */
public class CtrlRegisterTeacher {

   RegisterTeacherFrame registerTeacher = new RegisterTeacherFrame(this);
    
   public void startFrame(){     
        registerTeacher.setVisible(true);
    }

    public void insertTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        TeacherDAO.getInstance().insert(teacher);
    }


    
    
    
    
    
}
