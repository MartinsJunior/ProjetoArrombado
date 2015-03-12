package projetoarrombado;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.hanze.cgd.BookDAO;
import project.hanze.cgd.BorrowDAO;
import project.hanze.cgd.StudentDAO;
import project.hanze.cgd.TeacherDAO;
import project.hanze.cih.MainFrame;

public class ProjetoArrombado {

    public static void main(String[] args) {
        try {
            StudentDAO.getInstance().create();
            BookDAO.getInstance().create();
            TeacherDAO.getInstance().create();
            BorrowDAO.getInstance().create();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjetoArrombado.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
    
}
