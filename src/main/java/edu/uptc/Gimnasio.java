package edu.uptc;

import java.util.HashMap;
import java.util.HashSet;

public class Gimnasio {

    private HashMap<String, Miembro> miembros;
    private Membresia membresiaGold;
    private Membresia membresiaPlatinum;
    private Membresia membresiaBronze;
    private HashSet<Coach> coaches;

    public Gimnasio() {
        this.miembros = new HashMap<>();
        //MEMBRESIA GOLD
        this.membresiaGold = new Membresia();
        this.membresiaGold.setIdMembresia("1234");
        this.membresiaGold.setPrecio(200000);
        this.membresiaGold.setTipoMembresia("Gold");
        this.membresiaGold.setDescripcion("Membresia con acceso a todos los servicios del gimnasio");
        this.membresiaGold.setDerechoSpa(true);
        this.membresiaGold.setDerechoClasesGrupales(true);
        //MEMBRESIA PLATINUM
        this.membresiaPlatinum = new Membresia("4321", 120000, "Platinum",
                "Membresia con acceso a todos los servicios del gimnasio menos spa",
                false, true);
        //MEMBRESIA BRONZE
        this.membresiaBronze = new Membresia("3241", 80000, "Bronze",
                "Membresia con acceso unico a maquinas de ejercicio anaerobico",
                false, false);
        this.coaches = new HashSet<>();

        this.coaches.add(new Coach("123", "Andres", "Lopez", "Educador Fisico",
                5));
        this.coaches.add(new Coach("234", "Andrea", "Perez", "Fisioterapeuta",
                10));
        this.coaches.add(new Coach("345", "Juan Andres", "Torres", "Empirico",
                2));
    }

    public boolean crearMiembro(String nombre, String apellido, String cedula, int edad, String idMembresia) {
        if (miembros.keySet().contains(cedula)) {
            return false;
        } else {
            Miembro nuevoMiembro = new Miembro(nombre, apellido, cedula, edad, 0, null);
            if (idMembresia.equals(this.membresiaGold.getIdMembresia())) {
                nuevoMiembro.setMembresia(this.membresiaGold);
            } else if (idMembresia.equals(this.membresiaPlatinum.getIdMembresia())) {
                nuevoMiembro.setMembresia(this.membresiaPlatinum);
            } else if (idMembresia.equals(this.membresiaBronze.getIdMembresia())) {
                nuevoMiembro.setMembresia(this.membresiaBronze);
            } else {
                return false;
            }

            this.miembros.put(cedula, nuevoMiembro);
            return true;
        }
    }

    public String mostrarMiembro() {
        if (miembros.isEmpty()) {
            return "No hay miembros registrados.";
        }
        String resultado = "Lista de miembros:\n";
        for (Miembro m : miembros.values()) {
            resultado += m.toString() + "\n";
        }
        return resultado;
    }

    //EL METODO CONTEINSKEY YA REGRESA UN FALSO O VERDADERO
  /*  public boolean idBuscar(String idBuscado){
        if (miembros.containsKey(idBuscado)){
            return true;
        } else {
            return false;
        }
    }*/

    public boolean idBuscar(String idBuscado) {
        return miembros.containsKey(idBuscado);
    }

    public boolean eliminarMiembroPorId(String idEliminar) {
        miembros.remove(idEliminar);
        return true;
    }

    public String mostrarNombre(String id) {
        return miembros.get(id).getNombre();
    }

    public double calcularMembresia(String idMiembro) {
        double precioMensualidad = miembros.get(idMiembro).getMembresia().getPrecio();
        double descuento = 0;
        double precioCoach = 0;
        // descuentos
        if ((miembros.get(idMiembro).getEdad() < 18) && ((miembros.get(idMiembro).getMembresia().getIdMembresia())
                .equals("4321") || (miembros.get(idMiembro).getMembresia().getIdMembresia()).equals("3241"))) {
            descuento = precioMensualidad * 0.3;
        } else if ((miembros.get(idMiembro).getEdad()) >= 18 && ((miembros.get(idMiembro).getEdad()) <= 60)) {
            if ((miembros.get(idMiembro).getMesesInscripcion()) > 15) {
                descuento = precioMensualidad * 0.15;
            }
        } else if (miembros.get(idMiembro).getEdad() > 60) {
            descuento = precioMensualidad * 0.5;
        }
        // coach precio

        if (miembros.get(idMiembro).getCoach() != null) {
            precioCoach = 200000 + (miembros.get(idMiembro).getCoach().getAnhosExperiencia()) * 20000;
        }
        double precioTotal = (precioMensualidad - descuento) + precioCoach;

        return precioTotal;
    }

   /* public String asignarCoach(String idMiembro, String cedulaCoach) {
        for (String cedula : this.miembros.keySet()) {
            if (cedula.equals(idMiembro)) {
                for (Coach coachAux : this.coaches) {
                    if (coachAux.getCedula().equals(idMiembro)) {
                        this.miembros.get(idMiembro).setCoach(coachAux);
                        return "El coach se ha asignado";
                    }
                }
            }
        }
        return "Miembro o coach no encontrados";
    }*/

    public String asignarCoach(String idMiembro, String cedulaCoach) {
        for (Coach coachAux : this.coaches) {
            if (coachAux.getCedula().equals(cedulaCoach)) {
                this.miembros.get(idMiembro).setCoach(coachAux);
                return "Coach Asiganado";
            }
        }
        if (cedulaCoach.equals("0")){
            this.miembros.get(idMiembro).setCoach(null);
            return "Coach eliminado";
        }
        return "Coach no asignado";
    }


    public String mostrarCoaches() {
        return this.coaches.toString();
    }

    public boolean actualizarMembresia(String idMiembro, String idMembresia) {
        if (idMembresia.equals(membresiaBronze.getIdMembresia())) {
            this.miembros.get(idMiembro).setMembresia(membresiaBronze);
            return true;
        } else if (idMembresia.equals(membresiaPlatinum.getIdMembresia())) {
            this.miembros.get(idMiembro).setMembresia(membresiaPlatinum);
            return true;
        } else if (idMembresia.equals(membresiaGold.getIdMembresia())) {
            this.miembros.get(idMiembro).setMembresia(membresiaGold);
            return true;
        }
        return false;

    }


}
