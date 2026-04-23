package edu.uptc;

public class Miembro {

    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private int mesesInscripcion;
    private Membresia membresia;

    public Miembro(String nombre, String apellido, String cedula, int edad, int mesesInscripcion, Membresia membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.mesesInscripcion = mesesInscripcion;
        this.membresia = membresia;
    }

    public Miembro() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getMesesInscripcion() {
        return mesesInscripcion;
    }

    public void setMesesInscripcion(int mesesInscripcion) {
        this.mesesInscripcion = mesesInscripcion;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "\n===================================" +
                "\nNombre: " + nombre + " " + apellido +
                "\nCédula: " + cedula +
                "\nEdad: " + edad + " años" +
                "\nMeses inscrito: " + mesesInscripcion +
                membresia.toString() +
                "\n===================================";
    }
}
