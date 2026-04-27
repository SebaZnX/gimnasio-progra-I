package edu.uptc;

public class Coach {
    private String cedula;
    private String nombre;
    private String apellido;
    private String profesion;
    private int anhosExperiencia;

    public Coach() {
    }

    public Coach(String cedula, String nombre, String apellido, String profesion, int anhosExperiencia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.anhosExperiencia = anhosExperiencia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getAnhosExperiencia() {
        return anhosExperiencia;
    }

    public void setAnhosExperiencia(int anhosExperiencia) {
        this.anhosExperiencia = anhosExperiencia;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido +
                " (Cédula: " + cedula +
                ", Profesión: " + profesion +
                ", Años de experiencia: " + anhosExperiencia + ")";
    }
}
