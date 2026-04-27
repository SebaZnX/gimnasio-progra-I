package edu.uptc;

public class Miembro {

    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private int mesesInscripcion;
    private Membresia membresia;
    private Coach coach;

    public Miembro(String nombre, String apellido, String cedula, int edad, int mesesInscripcion, Membresia membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.mesesInscripcion = mesesInscripcion;
        this.membresia = membresia;
        this.coach = null;
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

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @Override
    public String toString() {
        String texto = "\n===================================\n";
        texto += "  Miembro:\n";
        texto += "    Nombre: " + nombre + " " + apellido + "\n";
        texto += "    Cédula: " + cedula + "\n";
        texto += "    Edad: " + edad + " años\n";
        texto += "    Meses inscrito: " + mesesInscripcion + "\n";

        if (membresia != null) {
            texto += "    Membresía: " + membresia.toString() + "\n";
        } else {
            texto += "    Membresía: No asignada\n";
        }

        if (coach != null) {
            texto += "    Coach: " + coach.toString() + "\n";
        } else {
            texto += "    Coach: Sin coach asignado\n";
        }

        texto += "===================================";
        return texto;
    }
}
