/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosSAT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edward
 */
public class conexionMysql {
   private static Connection cnx = null;
   public static Connection obtener()  {
      if (cnx == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            
            cnx = DriverManager.getConnection("jdbc:mysql://christianagustin.com/coagus_sa", "coagus_engazado", "Barcelona5");
         } catch (SQLException ex) {
             try {
                 throw new SQLException(ex);
             } catch (SQLException ex1) {
                 Logger.getLogger(conexionMysql.class.getName()).log(Level.SEVERE, null, ex1);
             }
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
   }
/*   
   public static void cerrar() {
      if (cnx != null) {
          try {
              cnx.close();
          } catch (SQLException ex) {
              Logger.getLogger(conexionMysql.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
   }*/
}
