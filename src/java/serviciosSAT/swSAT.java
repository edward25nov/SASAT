/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosSAT;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author edward
 */
@WebService(serviceName = "swSAT")
public class swSAT {
    org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(swSAT.class.getName());
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ValidarManifiesto")
    public MasterClass ValidarManifiesto(@WebParam(name = "master") MasterClass master) {
        //TODO write your implementation code here:
        logger.info("Iniciando a Validar Manifiesto");
        double monto = 0;
        for(Item i : master.getDetalleItem())
        {
            int cantidadI = i.getCantidad();
            double precioI = i.getPrecio();
            double impuesto = i.getPorcentajeArancel();
            monto += cantidadI * ( (precioI*impuesto) / 100);
        }
        //INSERTAR A MANIFIESTO Y RETORNAR NUMERO DE FORMULARIO Y MONTO
        consultas query = new consultas();  
        conexionMysql a = new conexionMysql();
        MasterClass respReturn = query.SetManifiestoSAT(a.obtener(),monto);
        logger.info("Fin de Validar Manifiesto");
        return respReturn;
        //return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerEstadoForm")
    public MasterClass ObtenerEstadoForm(@WebParam(name = "parameter") MasterClass parameter) {
        //TODO write your implementation code here:
        logger.info("Iniciando a Obtener Estado de Formulario");
        consultas query = new consultas();     
        conexionMysql a = new conexionMysql();
        MasterClass respReturn = query.GetEstadoManifiestoSAT(a.obtener(),parameter.getNumeroFormulario());
        logger.info("Fin de Obtener Estado de Formulario");
        return respReturn;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CambiarEstadoForm")
    public MasterClass CambiarEstadoForm(@WebParam(name = "parameter") MasterClass parameter) {
        logger.info("Iniciando a Cambiar Estado Formulario");
        consultas query = new consultas();     
        conexionMysql a = new conexionMysql();
        MasterClass respReturn = query.SetEstadoManifiestoSAT(a.obtener(),parameter.getNumeroFormulario());
        logger.info("Fin de Cambio a Estado Formulario");
        return respReturn;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConsultarAracelPorCategoria")
    public MasterClass ConsultarAracelPorCategoria(@WebParam(name = "parameter") MasterClass parameter) {
        logger.info("Iniciando a Consultar Aracel por Categoria");
        consultas query = new consultas();     
        conexionMysql a = new conexionMysql();
        logger.info("Vino la solicitud de categoria "+parameter.getCategoria());
        MasterClass respReturn = query.GetAracelPorCategoria(a.obtener(),parameter.getCategoria());
        logger.info("Finalizando  Consulta de Aracel por Categoria");
        return respReturn;
    }
    
    
}
