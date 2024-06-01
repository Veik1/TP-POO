import java.util.Scanner;

public class Tarjeta {
    private String numTarjeta;
    private String nombreBanco;
    private String titular;
    private Fecha fechaVec;
    private String codSeguridad;

    // Constructor
    public Tarjeta(String numTarjeta, String nombreBanco, String titular, Fecha fechaVec, String codSeguridad) {
        this.numTarjeta = numTarjeta;
        this.nombreBanco = nombreBanco;
        this.titular = titular;
        this.fechaVec = fechaVec;
        this.codSeguridad = codSeguridad;
    }

    // Getters and Setters
    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
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

    public Fecha getFechaVec() {
        return fechaVec;
    }

    public void setFechaVec(Fecha fechaVec) {
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
        String numTarjeta = entrada.nextLine();

        System.out.print("Ingrese el nombre del banco de la tarjeta: ");
        String nombreBanco = entrada.nextLine();

        System.out.print("Ingrese el nombre del titular: ");
        String titular = entrada.nextLine();

        Fecha fechaVec = null;
        while(fechaVec == null) {
            System.out.print("Ingrese la Fecha de vencimiento (dd/MM/aaaa): ");
            fechaVec = Fecha.obtenerFecha(entrada.nextLine());
        }

        System.out.print("Ingrese el código de seguridad: ");
        String codSeguridad = entrada.nextLine();

        return new Tarjeta(numTarjeta, nombreBanco, titular, fechaVec, codSeguridad);
    }
}