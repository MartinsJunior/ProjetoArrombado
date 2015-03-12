package project.hanze.cgd;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    public void create()throws ClassNotFoundException, SQLException;
    public void insert(T obj)throws SQLException, ClassNotFoundException;
    public void delete(T obj) throws SQLException, ClassNotFoundException;
    public List<T> read(Class<T> classe) throws SQLException;  
}
