public class ArbolLibros {
    private NodoLibro raiz;

    public ArbolLibros() {
        this.raiz = null;
    }

    public void insertar(int id, String nombre) {
        NodoLibro nuevoNodo = new NodoLibro(id, nombre);
        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            insertarRecursivo(raiz, nuevoNodo);
        }
    }

    private void insertarRecursivo(NodoLibro actual, NodoLibro nuevo) {
        if (nuevo.idLibro < actual.idLibro) {
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

    public String getInventarioLibros() {
        StringBuilder inventario = new StringBuilder();
        recorrerInorden(raiz, inventario);
        return inventario.toString();
    }

    private void recorrerInorden(NodoLibro nodo, StringBuilder inventario) {
        if (nodo != null) {
            recorrerInorden(nodo.izquierda, inventario);
            inventario.append("Libro disponible: ").append(nodo.idLibro).append(" ").append(nodo.nombreLibro);
            if (nodo.prestado) inventario.append(" (Prestado)");
            inventario.append("\n");
            recorrerInorden(nodo.derecha, inventario);
        }
    }

    public boolean prestarLibro(int idLibro) {
        NodoLibro libro = buscarLibro(raiz, idLibro);
        if (libro != null && !libro.prestado) {
            libro.prestado = true;
            return true;
        } else if (libro == null) {
            System.out.println("El libro con ID " + idLibro + " no se encuentra en el árbol.");
            return false;
        } else {
            System.out.println("El libro con ID " + idLibro + " ya está prestado.");
            return false;
        }
    }

    private NodoLibro buscarLibro(NodoLibro actual, int idLibro) {
        if (actual == null) {
            return null;
        }
        if (idLibro == actual.idLibro) {
            return actual;
        }
        if (idLibro < actual.idLibro) {
            return buscarLibro(actual.izquierda, idLibro);
        } else {
            return buscarLibro(actual.derecha, idLibro);
        }
    }
    public boolean eliminarLibro(int idLibro) {
        if (raiz == null) {
            return false;
        } else {
            return eliminarRecursivo(null, raiz, idLibro);
        }
    }
    
    private boolean eliminarRecursivo(NodoLibro padre, NodoLibro actual, int idLibro) {
        if (actual == null) {
            return false;
        }
        if (idLibro < actual.idLibro) {
            return eliminarRecursivo(actual, actual.izquierda, idLibro);
        } else if (idLibro > actual.idLibro) {
            return eliminarRecursivo(actual, actual.derecha, idLibro);
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
                NodoLibro sucesor = encontrarSucesor(actual.derecha);
                int tempId = sucesor.idLibro;
                String tempNombre = sucesor.nombreLibro;
                eliminarLibro(sucesor.idLibro);
                actual.idLibro = tempId;
                actual.nombreLibro = tempNombre;
            }
            return true;
        }
    }
    
    private NodoLibro encontrarSucesor(NodoLibro nodo) {
        while (nodo != null && nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }
    
}












    
                  
            
        





