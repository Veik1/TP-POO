import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public abstract class MetodoPago {
    private String nombre;
    private String titular;

    // Constructor
    MetodoPago(String nombre, String titular) {
        this.nombre = nombre;
        this.titular = titular;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

}

