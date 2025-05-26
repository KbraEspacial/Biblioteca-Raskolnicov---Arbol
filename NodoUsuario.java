public class NodoUsuario {
    public int idUsuario;
    public String nombreUsuario;
    public NodoUsuario izquierda;
    public NodoUsuario derecha;
    public NodoLibro libroPrestado;

    // Constructor para ingresar un NodoUsuario al principio
    public NodoUsuario(int id, String nombre) {
        this.idUsuario = id;
        this.nombreUsuario = nombre;
        this.izquierda = null;
        this.derecha = null;
        this.libroPrestado = null;
    }

    // Constructor para ingresar un NodoUsuario al inicio
    public NodoUsuario(int id, String nombre, NodoUsuario izquierda, NodoUsuario derecha) {
        this.idUsuario = id;
        this.nombreUsuario = nombre;
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.libroPrestado = null;
    }
}

