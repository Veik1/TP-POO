import java.util.Scanner;

public class MercadoPago extends MetodoPago {
    private String numCuenta;
    private String numComprobante;

    // Constructor
    public MercadoPago(String numCuenta, String titular, String nombre, String numComprobante) {
        super(nombre, titular);
        this.numCuenta = numCuenta;
        this.numComprobante = numComprobante;
    }

    // Getters and Setters
    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    @Override
    public String toString() {
        return "Titular de la cuenta = " + getTitular() + 
               ", Nombre de la entidad = " + getNombre() +
               ", Número de la cuenta = " + numCuenta +
               ", Número de comprobante = " + numComprobante + "\n";
    }

    public static MercadoPago crearMercadoPago(Scanner entrada) {
        System.out.print("Ingrese el nombre del titular: ");
        String titular = entrada.nextLine();

        String nombre = "Mercado Pago";

        System.out.print("Ingrese el número de la cuenta: ");
        String numCuenta = entrada.nextLine();

        System.out.print("Ingrese el número de comprobante del titular: ");
        String numComprobante = entrada.nextLine();

        return new MercadoPago(numCuenta, titular, nombre, numComprobante);
    }
}