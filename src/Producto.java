import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

// Clase principal Producto



public abstract class Producto {
    private String nombre;
    private double precio;

    // Constructor
    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    

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
    
    //Metodo abstracto para crear productos
    public abstract void crearProducto(Scanner entrada, Cliente cliente,
            List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, List<Pasaje> listaPasajes,
            List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina,
            List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina,
            Consumer<Reserva> menuProductoAdicional);

}

