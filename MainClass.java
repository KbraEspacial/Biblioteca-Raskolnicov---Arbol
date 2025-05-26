//Desarrollo 
//Actividad 4 - Utilizando sistemas de control de versiones
// Bryan Felipe Celis Arcila
// ID 100159764
//Buen dia en el desarrollo del prototipo  dejare algunos comentarios para entender el funcionamiento del code.

//El proyecto se compone de dos nodos y dos arboles binarios y un main donde maneja interfaz grafica
import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        ArbolLibros arbolLibros = new ArbolLibros();
        ArbolUsuarios arbolUsuarios = new ArbolUsuarios();
        int opcion = 0;

        // Panel principal importado de swing
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Cargar la imagen y añadirla al panel
        ImageIcon imagenIcono = new ImageIcon(".\\fiodor.png"); 
        JLabel etiquetaImagen = new JLabel(imagenIcono);
        panel.add(etiquetaImagen);

        // Definiciones del panel para las opciones
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel, menuPanel);
        splitPane.setDividerLocation(200);  // Ajusta según el tamaño de tu imagen y preferencias

        do {
            try {
                // Definimos opcion para tener comenzar a definir casos segun el input ingresado
                opcion = Integer.parseInt(JOptionPane.showInputDialog(splitPane,
                        "Bienvenidos a la Biblioteca Raskolnicov\n1. Agregar Id. Del libro\n2. Mostrar Inventario de Libros Disponibles\n3. Buscar y Eliminar un Libro\n4. Agregar ID de usuario\n5. Mostrar Inventario de Usuarios\n6. Buscar y Eliminar un Usuario\n7. Realiza prestamo de libro\n8. Finalizar Sesion\nIndique una opcion:",
                        "Biblioteca Raskolnicov",
                        JOptionPane.PLAIN_MESSAGE));

                switch (opcion) {
                    case 1:
                        try {
                            int idLibro = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del libro:"));
                            String nombreLibro = JOptionPane.showInputDialog(null, "Ingrese el nombre del libro:");
                            arbolLibros.insertar(idLibro, nombreLibro);
                            JOptionPane.showMessageDialog(null, "Se ha agregado: " + nombreLibro, "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage());
                        }
                        break;

                    case 2:
                        String inventarioLibros = arbolLibros.getInventarioLibros();
                        JOptionPane.showMessageDialog(null, inventarioLibros, "Inventario de Libros", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 3:
                        try {
                            int idLibroEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del libro a eliminar:"));
                            boolean eliminado = arbolLibros.eliminarLibro(idLibroEliminar);
                            if (eliminado) {
                                JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Libro no encontrado o no pudo ser eliminado.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del usuario:"));
                            String nombreUsuario = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario:");
                            arbolUsuarios.insertar(idUsuario, nombreUsuario);
                            JOptionPane.showMessageDialog(null, "Se ha agregado: " + nombreUsuario, "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage());
                        }
                        break;

                    case 5:
                        String inventarioUsuarios = arbolUsuarios.getInventarioUsuarios();
                        JOptionPane.showMessageDialog(null, inventarioUsuarios, "Inventario de Usuarios", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 6:
                        try {
                            int idUsuarioEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del usuario a eliminar:"));
                            boolean eliminado = arbolUsuarios.eliminarUsuario(idUsuarioEliminar);
                            if (eliminado) {
                                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario no encontrado o no pudo ser eliminado.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage());
                        }
                        break;

                    case 7:
                        try {
                            int idLibroPrestar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del libro a prestar:"));
                            int idUsuarioPrestar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del usuario que solicita el libro:"));
                            String resultado = arbolUsuarios.registrarPrestamo(idUsuarioPrestar, idLibroPrestar, arbolLibros);
                            JOptionPane.showMessageDialog(null, resultado, "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage());
                        }
                        break;

                    case 8:
                        JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                        System.exit(0);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en digitación: " + e.getMessage());
            }
        } while (opcion != 10); 
    }
}

             







