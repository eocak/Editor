/**
 *
 * @author Erdinç Ocak WissenAcademie Ödev 4 Basit not defteri projesi
 */
package notdefteri;

import java.sql.*;

//import java.util.logging.Level;
//import java.util.logging.Logger;
public class SQLiteFunctions {

    Statement st = null;
    Connection conn = null;
    ResultSet rs = null;
    final String DRIVER = "org.sqlite.JDBC";

    protected SQLiteFunctions() {

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection("jdbc:sqlite:Databases/notlar.db");
            st = conn.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(SQLiteFunctions.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Bağlantı hatası: " + ex.getLocalizedMessage());
        }

    }

    protected ResultSet notlariGetir() {

        try {
            rs = st.executeQuery("SELECT * FROM notlar");
        } catch (SQLException ex) {
            //Logger.getLogger(SQLiteFunctions.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Tüm notları getirirken hata: " + ex.getLocalizedMessage());
        }

        return rs;

    }

    protected int notGuncelle(int gelenId, String yeniNot) {
        int update = -1;

        try {
            update = st.executeUpdate("UPDATE notlar SET 'not' = + '"+yeniNot+"'" + " " + "WHERE id = " + gelenId);
        } catch (SQLException ex) {
            //Logger.getLogger(SQLiteFunctions.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Not güncelleme hatası: " + ex.getLocalizedMessage());
        }

        return update;

    }

    public int notSil(int gelenId) {
        int delete = -1;
        try {
            delete = st.executeUpdate("DELETE FROM notlar WHERE id = " + gelenId);
        } catch (Exception e) {
            System.out.println("Not silmede hata: " + e.getLocalizedMessage());
        }
        return delete;
    }

    public ResultSet notGetir(int gelenId) {

        try {
            rs = st.executeQuery("SELECT * FROM notlar WHERE id = " + gelenId);
        } catch (Exception e) {
            System.out.println("Not getirme hatası: " + e.getLocalizedMessage());
        }
        return rs;
    }

    public int notEkle(String gelenBaslik, String gelenNot, String gelenTarih) {
        int sonuc = -1;
        try {
            sonuc = st.executeUpdate("INSERT INTO notlar VALUES(null,  '"+gelenBaslik+"',  '"+gelenNot+"', '"+gelenTarih+"'  )");
        } catch (Exception e) {
            System.out.println("Ekleme hatası: " + e.getLocalizedMessage());
        }
        return sonuc;
    }

}
