/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosSAT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edward
 */
public class consultas {

     
    public MasterClass SetManifiestoSAT(Connection conexion, double monto)  {
        MasterClass mc = new MasterClass();
        mc.setMonto(monto);
        try{
            Statement consulta = conexion.createStatement();
            consulta.executeUpdate("INSERT INTO manifiesto(monto,estado) values ("+monto+",0)");
    
            ResultSet resultado = consulta.executeQuery("SELECT MAX(m.idmanifiesto) as fosfi FROM manifiesto m");
            while(resultado.next()){
                mc.setNumeroFormulario(resultado.getInt("fosfi"));
            }
        }catch(SQLException ex){
            try {mc.setDescripcion(ex.getMessage());
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                mc.setDescripcion(ex1.getMessage());
                Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex1);
                
            }
        }
        return mc;
    }

    public MasterClass GetEstadoManifiestoSAT(Connection conexion, int id){
        MasterClass h = new MasterClass();
        try {
            Statement consulta = conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("SELECT m.estado,m.monto FROM manifiesto m WHERE m.idmanifiesto = "+id);
            while(resultado.next()){
                int r = resultado.getInt("estado");
                double a = resultado.getFloat("monto");
              if(r==1){
                 h.setEstado(1); // pagado
              }else{
                 h.setMonto(a);
                  h.setEstado(0); //no pagado
                  h.setNumeroFormulario(id);
              }
            }
           // h.setEstado(1);
            h.setDescripcion("manifiesto obtenido");
        } catch (SQLException ex) {
            h.setDescripcion(ex.getMessage());
            h.setEstado(0);
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
     return h;
    }

    public MasterClass SetEstadoManifiestoSAT(Connection conexion, int id){
        MasterClass h = new MasterClass();
        try {
            Statement consulta = conexion.createStatement();
            consulta.executeUpdate("UPDATE manifiesto SET estado = 1 WHERE idmanifiesto = "+id);
            h.setEstado(1);
            h.setDescripcion("se pudo actualizar");
        } catch (SQLException ex) {
            h.setDescripcion(ex.getMessage());
            h.setEstado(0);
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
     return h;
    }
    
}
