import java.util.Scanner;

public class Tarjeta {
    private int numTarjeta;
    private String nombreBanco;
    private String titular;
    private FechaCorta fechaVec;
    private String codSeguridad;

    // Constructor
    public Tarjeta(int numTarjeta, String nombreBanco, String titular, FechaCorta fechaVec, String codSeguridad) {
        this.numTarjeta = numTarjeta;
        this.nombreBanco = nombreBanco;
        this.titular = titular;
        this.fechaVec = fechaVec;
        this.codSeguridad = codSeguridad;
    }

    // Getters and Setters
    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public FechaCorta getFechaVec() {
        return fechaVec;
    }

    public void setFechaVec(FechaCorta fechaVec) {
        this.fechaVec = fechaVec;
    }

    public String getCodSeguridad() {
        return codSeguridad;
    }

    public void setCodSeguridad(String codSeguridad) {
        this.codSeguridad = codSeguridad;
    }

    @Override
    public String toString() {
        return "Número de la tarjeta = " + numTarjeta +
               ", Nombre del banco = " + nombreBanco +
               ", Titular = " + titular +
               ", Fecha de vencimiento = " + fechaVec +
               ", Código de seguridad = " + codSeguridad + "\n";
    }

    public static Tarjeta crearTarjeta(Scanner entrada) {
        System.out.print("Ingrese el número de la tarjeta: ");
        int numTarjeta = Integer.parseInt(entrada.nextLine());

        System.out.print("Ingrese el nombre del banco de la tarjeta: ");
        String nombreBanco = entrada.nextLine();

        System.out.print("Ingrese el nombre del titular: ");
        String titular = entrada.nextLine();

        FechaCorta fechaVec = null;
        while(fechaVec == null) {
            System.out.print("Ingrese la Fecha de vencimiento (MM/aaaa): ");
            fechaVec = FechaCorta.obtenerFecha(entrada.nextLine());
        }

        System.out.print("Ingrese el código de seguridad: ");
        String codSeguridad = entrada.nextLine();

        return new Tarjeta(numTarjeta, nombreBanco, titular, fechaVec, codSeguridad);
    }

}