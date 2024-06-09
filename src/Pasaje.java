import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Pasaje extends Producto {
    private Fecha fecha;
    private String horaSalida;
    private String horaLlegada;
    private String origen;
    private String destino;
    private int cantidadPasajeros;
    private Buque buque;

    // Constructor
    Pasaje(String nombre, double precio, Fecha fecha, String horaSalida, String horaLlegada, String origen, String destino, int cantidadPasajeros, Buque buque) {
        super(nombre, precio);
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.origen = origen;
        this.destino = destino;
        this.cantidadPasajeros = cantidadPasajeros;
        this.buque = buque;  // Utiliza el buque proporcionado
    }

    // Getters
    public Fecha getFecha() {
        return fecha;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public Buque getBuque() {
        return buque;
    }

    @Override
    public String toString() {
        return "Pasaje - " + getNombre() + " en buque " + buque.getNombre() + " (Capacidad: " + buque.getCapacidad() + ", Lugares reservados: " + buque.getPasajerosActuales() + ")";
    }
   
    
    public void crearProducto(Scanner entrada, Cliente cliente,
                              List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, List<Pasaje> listaPasajes,
                              List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina,
                              List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina,
                              Consumer<Reserva> menuProductoAdicional) {
        System.out.println("Lista de Pasajes Disponibles:");
        for (int i = 0; i < listaPasajes.size(); i++) {
            System.out.println((i + 1) + ". " + listaPasajes.get(i).toString());
        }

        System.out.print("Seleccione el pasaje que desea reservar: ");
        int seleccionPasaje = entrada.nextInt();
        entrada.nextLine();

        if (seleccionPasaje > 0 && seleccionPasaje <= listaPasajes.size()) {
            Pasaje pasaje = listaPasajes.get(seleccionPasaje - 1);

            // Verificar capacidad del buque
            if (!pasaje.getBuque().verificarCapacidad(pasaje.getCantidadPasajeros())) {
                System.out.println("No hay suficiente capacidad en el buque para esta reserva.");
                return;
            }

            Pago pagoPasaje = new Pago(cliente);

            try {
                pagoPasaje.seleccionarMetodoDePago(entrada);
                Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), pasaje.getPrecio());
                nuevaReserva.agregarProducto(pasaje);
                double precioNuevo = nuevaReserva.calcularValorFinal();
                nuevaReserva.setValorFinal(precioNuevo);
                cliente.agregarReserva(nuevaReserva);

                // Actualizar la capacidad del buque
                pasaje.getBuque().agregarPasajeros(pasaje.getCantidadPasajeros());

                System.out.println("Reserva realizada para: " + pasaje.getNombre());
                System.out.println("¡Gracias por elegir Buquealtoque!");

                System.out.println("\n¿Querés agregar más productos a la reserva?\n1 - Sí\n2 - No");
                System.out.print("Seleccione una opción: ");
                int opcionProductoAdicional = entrada.nextInt();

                if (opcionProductoAdicional == 1) {
                    menuProductoAdicional.accept(nuevaReserva);
                }

            } catch (Exception e) {
                System.out.println("Error al realizar el pago: " + e.getMessage());
                System.out.println("La reserva no ha podido realizarse.");
            }
        } else {
            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }
    
    public static void agregarProductoAdicional(Scanner entrada, Cliente cliente, List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, 
    		List<Pasaje> listaPasajes, List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina, List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina, Reserva nuevaReserva) {
    	// Mostrar lista de pasajes
        System.out.println("Lista de Pasajes Disponibles:");
        for (int i = 0; i < listaPasajes.size(); i++) {
            System.out.println((i + 1) + ". " + listaPasajes.get(i).toString());
        }
        System.out.print("Seleccione el pasaje que desea reservar: ");
         
        int seleccionPasaje = entrada.nextInt();
        entrada.nextLine();
        if (seleccionPasaje > 0 && seleccionPasaje <= listaPasajes.size()) {
            Pasaje pasaje = listaPasajes.get(seleccionPasaje - 1);
            

            // Verificar capacidad del buque
            if (!pasaje.getBuque().verificarCapacidad(pasaje.getCantidadPasajeros())) {
                System.out.println("No hay suficiente capacidad en el buque para esta reserva.");
                return;
            }
            
            Pago pagoPasaje = new Pago(cliente);
            try {
            	pagoPasaje.seleccionarMetodoDePago(entrada);
                nuevaReserva.agregarProducto(pasaje);
                double precioNuevo = nuevaReserva.calcularValorFinal();
                nuevaReserva.setValorFinal(precioNuevo);
                System.out.println("Reserva realizada para: " + pasaje.getNombre());
                System.out.println("¡Gracias por elegir Buquealtoque!");
                cliente.verificarSiEsVip(cliente, cliente.getReservas());
                // Actualizar la capacidad del buque
                pasaje.getBuque().agregarPasajeros(pasaje.getCantidadPasajeros());
                
            } catch (Exception e) {
                System.out.println("Error al realizar el pago: " + e.getMessage());
                System.out.println("La reserva en el producto adicional no ha podido realizarse.");
            }
        } else {
        	System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }
}
