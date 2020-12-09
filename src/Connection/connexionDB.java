/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP01
 */
public class connexionDB {
        Connection cnn;

    public connexionDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

           // cnn = (Connection) DriverManager.getConnection("jdbc:mysql://gobaa-PC/lacroix", "test", "Test2017");
           cnn = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@hp01:1521:form", "coswin", "coswin");
           
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es);
            System.out.println(es);
        }
    }

    public Connection Obtenirconnexion() {
        return cnn;
    }
public void EXP_DATA(String ID,String name , String age,String salaire) throws SQLException{
connexionDB cn = new connexionDB();
Statement stat;

    String SQL ="ATMI_INTERF_IMPORT_GPS("+ID+",'"+name+"',"+age+","+salaire+")";
    
    stat = cn.Obtenirconnexion().createStatement();
     int rs;   
    rs=stat.executeUpdate(SQL);
    
    stat.close();

}
}
