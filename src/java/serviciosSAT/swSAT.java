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
        MasterClass respReturn = query.SetManifiestoSAT(conexionMysql.obtener(),monto);
    //   conexionMysql.cerrar();
        return respReturn;
        //return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerEstadoForm")
    public MasterClass ObtenerEstadoForm(@WebParam(name = "parameter") MasterClass parameter) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CambiarEstadoForm")
    public MasterClass CambiarEstadoForm(@WebParam(name = "parameter") MasterClass parameter) {
        //TODO write your implementation code here:
        return null;
    }
    
    
}
