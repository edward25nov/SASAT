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
    org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(swSAT.class.getName());
     
    public MasterClass SetManifiestoSAT(Connection conexion, double monto)  {
        MasterClass mc = new MasterClass();
        mc.setMonto(monto);
        try{
            Statement consulta = conexion.createStatement();
            consulta.executeUpdate("INSERT INTO manifiesto(monto,estado) values ("+monto+",0)");
            logger.info("INSERT INTO manifiesto(monto,estado) values ("+monto+",0)");
            ResultSet resultado = consulta.executeQuery("SELECT MAX(m.idmanifiesto) as fosfi FROM manifiesto m");
            while(resultado.next()){
                mc.setNumeroFormulario(resultado.getInt("fosfi"));
            }
        }catch(SQLException ex){
            try {
                mc.setDescripcion(ex.getMessage());
                logger.info("Exception en SetManifiestoSAT "+ex.getMessage());
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                mc.setDescripcion(ex1.getMessage());
                 logger.info("Exception en SetManifiestoSAT "+ex1.getMessage());
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
                 logger.info("Estado de manifiesto es Pagado");
              }else{
                  h.setMonto(a);
                  h.setEstado(0); //no pagado
                  h.setNumeroFormulario(id);
                  logger.info("Estado de manifiesto No ha Pagado");                  
              }
            }
            h.setDescripcion("manifiesto obtenido");
        } catch (SQLException ex) {
            logger.info("Exception en GetEstadoManifiestoSAT "+ex.getMessage());
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
            logger.info("UPDATE manifiesto SET estado = 1 WHERE idmanifiesto = "+id);
        } catch (SQLException ex) {
            logger.info("Exception en SetEstadoManifiestoSAT "+ex.getMessage());
            h.setDescripcion(ex.getMessage());
            h.setEstado(0);
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
     return h;
    }
    
    public MasterClass GetAracelPorCategoria(Connection conexion, int id){
        MasterClass h = new MasterClass();
            
        try {
            Statement consulta = conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("SELECT a.porcentaje,a.nombre FROM arancel a where idarancel =  "+id);
            while(resultado.next()){
                h.setPorcentajeArancelario(resultado.getFloat("porcentaje"));
                h.setDescripcion(resultado.getString("nombre"));
            }      
        } catch (SQLException ex) {
            logger.info("Exception en GetAracelPorCategoria "+ex.getMessage());
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return h;
    }
    
    
}
