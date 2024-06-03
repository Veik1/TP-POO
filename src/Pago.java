import java.util.List;
import java.util.Scanner;

public class Pago {
    private List<Tarjeta> tarjetas;
    private List<CuentaBancaria> cuentasBancarias;
    private List<MercadoPago> cuentasMercadoPago;

    public Pago(Cliente cliente) {
        this.tarjetas = cliente.getTarjetas();
        this.cuentasBancarias = cliente.getCuentasBancarias();
        this.cuentasMercadoPago = cliente.getCuentasMercadoPago();
    }

    public void seleccionarMetodoDePago(Scanner entrada) throws Exception {
        System.out.println("\nSeleccione un método de pago: \n");
        System.out.println("1 - Pago con tarjeta");
        System.out.println("2 - Pago con cuenta bancaria");
        System.out.println("2 - Pago con Mercado Pago");
        System.out.print("Ingrese una opción: ");

        int opcion = entrada.nextInt();
        entrada.nextLine();
        switch (opcion) {
            case 1:
                pagoConTarjeta(entrada);
                break;
            case 2:
                pagoConCuentaBancaria(entrada);
                break;
            case 3:
            	pagoConMercadoPago(entrada);
            	break;
            default:
                throw new Exception("Error, ingrese una opción válida");
        }
    }

    private void pagoConTarjeta(Scanner entrada) throws Exception {
        if (tarjetas.isEmpty()) {
            throw new Exception("No tiene tarjetas registradas. Por favor, agregue una tarjeta primero.");
        }

        System.out.println("Seleccione una tarjeta para el pago:");
        for (int i = 0; i < tarjetas.size(); i++) {
            System.out.println((i + 1) + " - " + tarjetas.get(i));
        }

        int opcion = entrada.nextInt();
        entrada.nextLine();
        if (opcion < 1 || opcion > tarjetas.size()) {
            throw new Exception("Error, ingrese una opción válida");
        } else {
            Tarjeta tarjetaSeleccionada = tarjetas.get(opcion - 1);
            System.out.println("Pago realizado con la tarjeta: " + tarjetaSeleccionada.getNumTarjeta());
        }
    }
    
    private void pagoConCuentaBancaria(Scanner entrada) throws Exception {
        if (cuentasBancarias.isEmpty()) {
            throw new Exception("No tiene cuentas bancarias registradas. Por favor, agregue una primero.");
        }

        System.out.println("Seleccione una cuenta bancaria para el pago:");
        for (int i = 0; i < cuentasBancarias.size(); i++) {
            System.out.println((i + 1) + " - " + cuentasBancarias.get(i));
        }

        int opcion = entrada.nextInt();
        entrada.nextLine();
        if (opcion < 1 || opcion > cuentasBancarias.size()) {
            throw new Exception("Error, ingrese una opción válida");
        } else {
            CuentaBancaria cuentaSeleccionada = cuentasBancarias.get(opcion - 1);
            System.out.println("Pago realizado con la cuenta bancaria: " + cuentaSeleccionada.getNumCuenta());
        }
    }
    
    private void pagoConMercadoPago(Scanner entrada) throws Exception {
        if (cuentasMercadoPago.isEmpty()) {
            throw new Exception("No tiene cuentas de Mercado Pago. Por favor, agregue una primero.");
        }

        System.out.println("Seleccione una cuenta de Mercado Pago para el pago:");
        for (int i = 0; i < cuentasMercadoPago.size(); i++) {
            System.out.println((i + 1) + " - " + cuentasMercadoPago.get(i));
        }

        int opcion = entrada.nextInt();
        entrada.nextLine();
        if (opcion < 1 || opcion > cuentasMercadoPago.size()) {
            throw new Exception("Error, ingrese una opción válida");
        } else {
            MercadoPago cuentaSeleccionada = cuentasMercadoPago.get(opcion - 1);
            System.out.println("Pago realizado con la cuenta de Mercado Pago: " + cuentaSeleccionada.getNumCuenta());
        }
    }

}
