/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosSAT;

/**
 *
 * @author edward
 */
public class Item {
        private int NumeroTracking;
        private int Cantidad;
        private int Categoria;
        private double Peso;
        private double precio;
        private String Descripcion;
        private double PorcentajeArancel;
        private int CodigoUsuario;

    /**
     * @return the NumeroTracking
     */
    public int getNumeroTracking() {
        return NumeroTracking;
    }

    /**
     * @param NumeroTracking the NumeroTracking to set
     */
    public void setNumeroTracking(int NumeroTracking) {
        this.NumeroTracking = NumeroTracking;
    }

    /**
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * @return the Categoria
     */
    public int getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
    }

    /**
     * @return the Peso
     */
    public double getPeso() {
        return Peso;
    }

    /**
     * @param Peso the Peso to set
     */
    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the PorcentajeArancel
     */
    public double getPorcentajeArancel() {
        return PorcentajeArancel;
    }

    /**
     * @param PorcentajeArancel the PorcentajeArancel to set
     */
    public void setPorcentajeArancel(double PorcentajeArancel) {
        this.PorcentajeArancel = PorcentajeArancel;
    }

    /**
     * @return the CodigoUsuario
     */
    public int getCodigoUsuario() {
        return CodigoUsuario;
    }

    /**
     * @param CodigoUsuario the CodigoUsuario to set
     */
    public void setCodigoUsuario(int CodigoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
    }
}
