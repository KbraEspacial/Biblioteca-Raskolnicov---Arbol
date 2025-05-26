/**
 * Clase que representa un nodo de un árbol binario para almacenar libros.
 */
public class NodoLibro {

    public int idLibro;
    public String nombreLibro;
    public NodoLibro izquierda;
    public NodoLibro derecha;
    public boolean prestado;

    /**
     * Constructor para inicializar un nuevo nodo de libro.
     *
     * @param id     Identificador único del libro.
     * @param nombre Nombre del libro.
     */
    public NodoLibro(int id, String nombre) {
        idLibro = id;
        nombreLibro = nombre;
        izquierda = null;
        derecha = null;
        prestado = false;
    }
}



