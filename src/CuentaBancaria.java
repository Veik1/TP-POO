import java.util.Scanner;

public class CuentaBancaria extends MetodoPago {
    private String numCuenta;
    private String tipoCuenta;

    // Constructor
    public CuentaBancaria(String numCuenta, String nombre, String titular, String tipoCuenta) {
        super(nombre, titular);
        this.numCuenta = numCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    // Getters and Setters
    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return "Número de cuenta = " + numCuenta +
               ", Nombre del banco = " + getNombre() +
               ", Titular = " + getTitular() +
               ", Tipo de cuenta = " + tipoCuenta + "\n";
    }

    public static CuentaBancaria crearCuentaBancaria(Scanner entrada) {
        System.out.print("Ingrese el número de la cuenta: ");
        String numCuenta = entrada.nextLine();

        System.out.print("Ingrese el nombre del banco de la cuenta: ");
        String nombreBanco = entrada.nextLine();

        System.out.print("Ingrese el nombre del titular: ");
        String titular = entrada.nextLine();

        System.out.print("Ingrese el tipo de cuenta (ahorro o corriente): ");
        String tipoCuenta = entrada.nextLine();

        return new CuentaBancaria(numCuenta, nombreBanco, titular, tipoCuenta);
    }
}
