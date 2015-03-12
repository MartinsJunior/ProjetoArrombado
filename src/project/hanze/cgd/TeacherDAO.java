/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.hanze.cgd;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import project.hanze.cdp.Teacher;

/**
 *
 * @author juniorm10
 */
public class TeacherDAO extends DAOAbstract implements DAO<Teacher>{

    
    public static TeacherDAO getInstance() {
        return TeacherDAOHolder.INSTANCE;
    }
    
    private static class TeacherDAOHolder {

        private static final TeacherDAO INSTANCE = new TeacherDAO();
    }
    
    
    @Override
    public void create() throws ClassNotFoundException, SQLException {
                this.openConnection();
        String sql = "CREATE TABLE IF NOT EXISTS TEACHER ("
                + "Id INTEGER PRIMARY KEY   AUTOINCREMENT,"
                + "name VARCHAR(50) NOT NULL,"
                + "staffId VARCHAR(3) NOT NULL,"
                + "departmentName VARCHAR(20) NOT NULL)";

        this.execute(sql);

        this.closeConnection();
    }

    @Override
    public void insert(Teacher obj) throws SQLException, ClassNotFoundException {
        this.openConnection();
        String sql = "INSERT INTO TEACHER (name,staffId,departmentName) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getName());
        preparedStatement.setString(2, obj.getStaffId());
        preparedStatement.setString(3, obj.getDepartmentName());
        preparedStatement.executeUpdate();
        this.closeConnection();
    }

    @Override
    public void delete(Teacher obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Teacher> read(Class<Teacher> classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
