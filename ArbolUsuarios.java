public class ArbolUsuarios {
    private NodoUsuario raiz;

    public ArbolUsuarios() {
        this.raiz = null;
    }

    public void insertar(int idUsuario, String nombreUsuario) {
        NodoUsuario nuevoNodo = new NodoUsuario(idUsuario, nombreUsuario);
        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            insertarRecursivo(raiz, nuevoNodo);
        }
    }

    private void insertarRecursivo(NodoUsuario actual, NodoUsuario nuevo) {
        if (nuevo.idUsuario < actual.idUsuario) {
            if (actual.izquierda == null) {
                actual.izquierda = nuevo;
            } else {
                insertarRecursivo(actual.izquierda, nuevo);
            }
        } else {
            if (actual.derecha == null) {
                actual.derecha = nuevo;
            } else {
                insertarRecursivo(actual.derecha, nuevo);
            }
        }
    }

    public String getInventarioUsuarios() {
        StringBuilder inventario = new StringBuilder();
        recorrerInorden(raiz, inventario);
        return inventario.toString();
    }

    private void recorrerInorden(NodoUsuario nodo, StringBuilder inventario) {
        if (nodo != null) {
            recorrerInorden(nodo.izquierda, inventario);
            inventario.append("ID Estudiante: ").append(nodo.idUsuario).append(", Nombre: ").append(nodo.nombreUsuario).append("\n");
            recorrerInorden(nodo.derecha, inventario);
        }
    }

    public String registrarPrestamo(int idUsuario, int idLibro, ArbolLibros arbolLibros) {
        NodoUsuario usuario = buscarUsuario(raiz, idUsuario);
        if (usuario != null) {
            boolean prestado = arbolLibros.prestarLibro(idLibro);
            if (prestado) {
                usuario.libroPrestado = new NodoLibro(idLibro, ""); // Simulación de libro prestado
                return "Libro prestado con éxito a " + usuario.nombreUsuario;
            } else {
                return "El libro no está disponible o no fue encontrado.";
            }
        }
        return "Usuario no encontrado";
    }

    private NodoUsuario buscarUsuario(NodoUsuario actual, int idUsuario) {
        if (actual == null || actual.idUsuario == idUsuario) {
            return actual;
        }
        if (idUsuario < actual.idUsuario) {
            return buscarUsuario(actual.izquierda, idUsuario);
        } else {
            return buscarUsuario(actual.derecha, idUsuario);
        }
    }
    public boolean eliminarUsuario(int idUsuario) {
        if (raiz == null) {
            return false;
        } else {
            return eliminarRecursivo(null, raiz, idUsuario);
        }
    }
    
    private boolean eliminarRecursivo(NodoUsuario padre, NodoUsuario actual, int idUsuario) {
        if (actual == null) {
            return false;
        }
        if (idUsuario < actual.idUsuario) {
            return eliminarRecursivo(actual, actual.izquierda, idUsuario);
        } else if (idUsuario > actual.idUsuario) {
            return eliminarRecursivo(actual, actual.derecha, idUsuario);
        } else {
            // Encontramos el nodo a eliminar
            if (actual.izquierda == null && actual.derecha == null) {
                if (padre == null) {
                    raiz = null;
                } else if (padre.izquierda == actual) {
                    padre.izquierda = null;
                } else {
                    padre.derecha = null;
                }
            } else if (actual.izquierda != null && actual.derecha == null) {
                if (padre == null) {
                    raiz = actual.izquierda;
                } else if (padre.izquierda == actual) {
                    padre.izquierda = actual.izquierda;
                } else {
                    padre.derecha = actual.izquierda;
                }
            } else if (actual.derecha != null && actual.izquierda == null) {
                if (padre == null) {
                    raiz = actual.derecha;
                } else if (padre.izquierda == actual) {
                    padre.izquierda = actual.derecha;
                } else {
                    padre.derecha = actual.derecha;
                }
            } else {
                // El nodo tiene dos hijos
                NodoUsuario sucesor = encontrarSucesor(actual.derecha);
                int tempId = sucesor.idUsuario;
                String tempNombre = sucesor.nombreUsuario;
                eliminarUsuario(sucesor.idUsuario);
                actual.idUsuario = tempId;
                actual.nombreUsuario = tempNombre;
            }
            return true;
        }
    }
    
    private NodoUsuario encontrarSucesor(NodoUsuario nodo) {
        while (nodo != null && nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }
    
}


