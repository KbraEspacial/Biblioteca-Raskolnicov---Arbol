public class NodoLibro {
    public int idLibro;
    public String nombreLibro;
    public NodoLibro izquierda, derecha;
    public boolean prestado;

    // Constructor para crear un nuevo NodoLibro
    public NodoLibro(int id, String nombre) {
        this.idLibro = id;
        this.nombreLibro = nombre;
        this.izquierda = null;
        this.derecha = null;
        this.prestado = false;
    }
}


