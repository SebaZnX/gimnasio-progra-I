package edu.uptc;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        Gimnasio gimnasioUptc = new Gimnasio();

        String menu = """
                Bienvenido al gimnasio de la UPTC
                1. Añadir un nuevo miembro
                2. Eliminar miembro por ID
                3. Consultar mensualidad
                4. Actualizar membresia
                5. Adquirir Coach
                6. Mostrar todos los miembros
                7. Salir
                """;
        int opcion = 0;
        while (opcion != 7) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));


            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido");
                    String cedula = JOptionPane.showInputDialog("Ingrese la cedula");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad"));
                    String idMembresia = JOptionPane.showInputDialog("""
                            1234. Membresia Gold
                            4321. Membresia Platinium
                            3241. Membresia Bronze
                            """);

                    boolean isCreado = gimnasioUptc.crearMiembro(nombre, apellido, cedula, edad, idMembresia);

                    if (isCreado == true) {
                        JOptionPane.showMessageDialog(null, "El usuario fue creado");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "El usuario no fue creado, la cedula ya existe o membresia incorrecta");
                    }
                    break;

                case 2:
                    String idBuscado = JOptionPane.showInputDialog("Que miembro desea eliminar, coloque su id");
                    boolean isEncontrado = gimnasioUptc.idBuscar(idBuscado);

                    if (isEncontrado) {
                        boolean isEliminado = gimnasioUptc.eliminarMiembroPorId(idBuscado);
                        if (isEliminado) {
                            JOptionPane.showMessageDialog(null, "EL USUARIO CON CEDULA: "
                                    + idBuscado + " FUE ELIMINADO");
                        } else {
                            JOptionPane.showMessageDialog(null, "EL USUARIO CON CEDULA"
                                    + idBuscado + "NO PUDO SER ELIMINADO, INTENTE DE NUEVO");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "EL USUARIO CON CEDULA "
                                + idBuscado + " NO FUE ENCONTRADO");
                    }
                    break;
                case 3:
                    String idConsultar = JOptionPane.showInputDialog(
                            "Ingrese el id de la persona para consultar su mensualidad");
                    boolean isEncontradoConsulta = gimnasioUptc.idBuscar(idConsultar);

                    if (isEncontradoConsulta) {
                        double valorMensualidad = gimnasioUptc.calcularMembresia(idConsultar);
                        JOptionPane.showMessageDialog(null,
                                "EL VALOR DE LA MENSUALIDAD DE LA PERSONA "
                                        + gimnasioUptc.mostrarNombre(idConsultar) + " CON ID: " +
                                        idConsultar + " ES $" + valorMensualidad);
                    } else {
                        JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO");
                    }

                    break;
                case 4:
                    String idMiembroMembresia = JOptionPane.showInputDialog("INGRESE EL ID PARA CAMBIAR LA MENSUALIDAD");
                    boolean isCedulaEncontrado = gimnasioUptc.idBuscar(idMiembroMembresia);
                    if (isCedulaEncontrado) {
                        String idMembresiaNew = JOptionPane.showInputDialog("""
                                ----- INGRESE EL NUEVO TIPO DE MEMBRESIA -----
                                1234. Membresia Gold
                                4321. Membresia Platinium
                                3241. Membresia Bronze
                                """);
                        boolean isCambiado = gimnasioUptc.actualizarMembresia(idMiembroMembresia, idMembresiaNew);
                        if (isCambiado) {
                            JOptionPane.showMessageDialog(null, "MEMBRESIA ACTUALIZADA");
                        } else {
                            JOptionPane.showMessageDialog(null, "MEMBRESIA NO ENCOTNRADA");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "EL MIEMBRO NO FUE ENCONTRADO");
                    }
                    break;
                case 5:
                    String idMiembro = JOptionPane.showInputDialog("INGRESE LA CEDULA DEL MIEMBRO");
                    boolean isEncontradoMiembro = gimnasioUptc.idBuscar(idMiembro);
                    if (isEncontradoMiembro) {
                        String cedulaCoach = JOptionPane.showInputDialog("INGRESE LA CEDULA DEL COACH (0 Eliminar coach del miembro)\n" +
                                gimnasioUptc.mostrarCoaches());
                        JOptionPane.showMessageDialog(null, gimnasioUptc.asignarCoach(idMiembro, cedulaCoach));
                    } else {
                        JOptionPane.showMessageDialog(null, "MIEMBRO NO ENCONTRADO");
                    }
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, gimnasioUptc.mostrarMiembro());
                    break;
                default:
                    break;
            }
        }
    }
}
