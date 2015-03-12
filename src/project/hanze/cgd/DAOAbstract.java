/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.hanze.cgd;

import java.sql.*;

public abstract class DAOAbstract {

    protected Connection connection;
    protected Statement statement;

    protected void openConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: failed to load Sqlite JDBC driver.");
            e.printStackTrace();
            return;
        }
        this.connection = DriverManager.getConnection("jdbc:sqlite:arrombado.db");
        if (this.connection == null) {
            System.out.println("Problema ao abrir conexao");
        }
    }

    protected void execute(String query) throws SQLException {
        this.statement = connection.createStatement();
        statement.execute(query);
        statement.close();
    }

    protected ResultSet executeQuery(String query) throws SQLException {
        this.statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        return rs;
    }

    protected int executeUpdate(String query) throws SQLException {
        this.statement = connection.createStatement();		
            int numero = 0;
		// Comando para update, insert e delete		
            statement.executeUpdate(query);		
            ResultSet rs = statement.getGeneratedKeys();		
            if (rs.next())
            {
                numero = rs.getInt(1);
            }
            statement.close();
            return numero;
    }

    protected void closeConnection() throws SQLException {
        connection.close();
        statement.close();
    }

}
