

// Clase principal Producto
public abstract class Producto {
    private String nombre;
    private double precio;

    // Constructor
    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    // Método abstracto para mostrar productos
    public abstract void mostrarProductos();

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
    	this.precio = precio;
    }
    
    

}

