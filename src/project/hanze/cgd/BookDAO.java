/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.hanze.cgd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import project.hanze.cdp.Book;

/**
 *
 * @author juniorm10
 */
public class BookDAO extends DAOAbstract implements DAO<Book> {

    public static BookDAO getInstance() {
        return BookDAOHolder.INSTANCE;
    }

    private static class BookDAOHolder {

        private static final BookDAO INSTANCE = new BookDAO();
    }

    @Override
    public void create() throws ClassNotFoundException, SQLException {
        this.openConnection();
        String sql = "CREATE TABLE IF NOT EXISTS BOOK ("
                + "Id INTEGER PRIMARY KEY   AUTOINCREMENT,"
                + "title VARCHAR(50) NOT NULL,"
                + "author VARCHAR(50) NOT NULL,"
                + "borrowed BOOLEAN NOT NULL)";

        this.execute(sql);

        this.closeConnection();
    }

    @Override
    public void insert(Book obj) throws SQLException, ClassNotFoundException {
        this.openConnection();
        String sql = "INSERT INTO BOOK (title,author,borrowed) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getTitle());
        preparedStatement.setString(2, obj.getAuthor());
        preparedStatement.setBoolean(3, false);
        preparedStatement.executeUpdate();
        this.closeConnection();
    }

    @Override
    public ArrayList<Book> read(Class<Book> classe) throws SQLException {
//        ArrayList<Book> books = new ArrayList<>();
//        this.openConnection();
//        String sql = "SELECT DISTINCT author FROM BOOK";
//        ResultSet r = this.executeQuery(sql);
        return null;
    }

    public ArrayList<String> readAuthor() throws SQLException {
        ArrayList<String> booksAuthor = new ArrayList<>();
        this.openConnection();
        String sql = "SELECT DISTINCT author FROM BOOK order by author";
        ResultSet r = this.executeQuery(sql);
        while (r.next()) {
            booksAuthor.add(r.getString("author"));
        }
        return booksAuthor;
    }

    public ArrayList<String> readBooksByAuthor(String author) throws SQLException {
        ArrayList<String> booksTitle = new ArrayList<>();
        this.openConnection();
        String sql = "SELECT DISTINCT title FROM BOOK  where author in ('" + author + "') order by title";
        ResultSet r = this.executeQuery(sql);
        while (r.next()) {
            booksTitle.add(r.getString("title"));
        }
        return booksTitle;
    }

    public int countBooksByAuthorAndTitle(String author, String title) throws SQLException {
        this.openConnection();
        String sql = "SELECT count(title)  AS total FROM BOOK where author='" + author + "' and title='" + title + "'";
        ResultSet r = this.executeQuery(sql);
        int total = 0;
        while (r.next()) {
            total = Integer.valueOf(r.getString("total"));
        }
        this.closeConnection();
        return total;
    }

    public int verifyAvailable(String title, String author) throws SQLException {
        this.openConnection();
        String sql = "SELECT  *  FROM BOOK WHERE author='" + author + "'and title='" + title + "' and borrowed=0";
        ResultSet r = this.executeQuery(sql);
        int id = 0;
        if (r.next()) {
            id = r.getInt("id");
        }
        this.closeConnection();
        this.closeStatement();
        return id;
    }

    public void delete(Book obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
