package edu.uptc;

public class Membresia {
    private String idMembresia;
    private double precio;
    private String tipoMembresia;
    private String descripcion;
    private boolean derechoSpa;
    private boolean derechoClasesGrupales;

    public Membresia(String idMembresia, double precio, String tipoMembresia, String descripcion, boolean derechoSpa,
                     boolean derechoClasesGrupales) {
        this.idMembresia = idMembresia;
        this.precio = precio;
        this.tipoMembresia = tipoMembresia;
        this.descripcion = descripcion;
        this.derechoSpa = derechoSpa;
        this.derechoClasesGrupales = derechoClasesGrupales;
    }

    public Membresia() {
    }

    public String getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(String idMembresia) {
        this.idMembresia = idMembresia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDerechoSpa() {
        return derechoSpa;
    }

    public void setDerechoSpa(boolean derechoSpa) {
        this.derechoSpa = derechoSpa;
    }

    public boolean isDerechoClasesGrupales() {
        return derechoClasesGrupales;
    }

    public void setDerechoClasesGrupales(boolean derechoClasesGrupales) {
        this.derechoClasesGrupales = derechoClasesGrupales;
    }

    @Override
    public String toString() {
        return tipoMembresia +
                " (ID: " + idMembresia +
                ", Precio: $" + precio +
                ", Descripción: " + descripcion +
                ", Spa: " + (derechoSpa ? "Sí" : "No") +
                ", Clases grupales: " + (derechoClasesGrupales ? "Sí" : "No") + ")";
    }
}
