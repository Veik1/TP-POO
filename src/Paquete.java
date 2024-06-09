
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Paquete extends Producto {
	private String hotel;
	private Pasaje pasaje;
	private Experiencia experiencia;
	private DayTour daytour;
	
	// Constructor
	Paquete(String nombre, double precio, String hotel, Pasaje pasaje, Experiencia experiencia, DayTour daytour) {
		super(nombre, precio);
		this.hotel = hotel;
		this.pasaje = pasaje;
		this.experiencia = experiencia;
		this.daytour = daytour;
	}
	
	//Getters y setter
	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public Pasaje getPasaje() {
		return pasaje;
	}

	public void setPasaje(Pasaje pasaje) {
		this.pasaje = pasaje;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	public DayTour getDaytour() {
		return daytour;
	}

	public void setDaytour(DayTour daytour) {
		this.daytour = daytour;
	}
	
	
    @Override
    public String toString() {
        return "Paquete - " + getNombre() + 
               ", hotel = " + hotel +
               ", Pasaje = " + pasaje.getNombre() +
               ", Experiencia = " + experiencia.getNombre() +
               ", DayTour = " + daytour.getNombre();
    }
 
	public void mostrarProductos(){
		System.out.println("Paquete de viajes en Argentina");
		System.out.println("Paquete de viajes en Uruguay");
	}
	
	// Método para crear un paquete y devolver la instancia creada
    public void crearProducto(Scanner entrada, Cliente cliente,
                                    List<Experiencia> listaExperienciasUruguay,
                                    List<Experiencia> listaExperienciasArgentina,
                                    List<Pasaje> listaPasajes,
                                    List<DayTour> listaDayToursUruguay,
                                    List<DayTour> listaDayToursArgentina,
                                    List<Paquete> listaPaquetesUruguay,
                                    List<Paquete> listaPaquetesArgentina,
                                    Consumer<Reserva> menuProductoAdicional) {
        System.out.println("Elija el tipo de Paquete según país.");
        System.out.println("1 - Paquete en Uruguay.");
        System.out.println("2 - Paquete en Argentina.\n");
        System.out.print("Seleccione su producto: ");
        
        int opcionPaquete = entrada.nextInt();
        entrada.nextLine();
        
        switch(opcionPaquete) {
            case 1:
                System.out.println("Lista de Paquetes disponibles en Uruguay:");
                
                for (int i = 0; i < listaPaquetesUruguay.size(); i++) {
                    System.out.println((i + 1) + ". " + listaPaquetesUruguay.get(i).toString());
                }
                System.out.print("Seleccione el paquete que desea reservar: ");
                
                int seleccionPaqueteUruguay = entrada.nextInt();
                entrada.nextLine();
                if (seleccionPaqueteUruguay > 0 && seleccionPaqueteUruguay <= listaPaquetesUruguay.size()) {
                    Paquete paquete = listaPaquetesUruguay.get(seleccionPaqueteUruguay - 1);
                    Pago pagoPaquete = new Pago(cliente);
                    try {
                        pagoPaquete.seleccionarMetodoDePago(entrada);
                        Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), paquete.getPrecio());
                        nuevaReserva.agregarProducto(paquete);
                        cliente.agregarReserva(nuevaReserva);
                        System.out.println("Reserva realizada para: " + paquete.getNombre());
                        System.out.println("¡Gracias por elegir Buquealtoque!");
                        
                        System.out.println("\n¿Querés agregar más productos a la reserva?\n1 - Sí\n2 - No");
                        System.out.println("\nSeleccione una opción: ");
                        
                        int opcionProductoAdicional = entrada.nextInt();
                        switch (opcionProductoAdicional) {
                            case 1: 
                                menuProductoAdicional.accept(nuevaReserva);
                                break;
                            case 2:
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Error al realizar el pago: " + e.getMessage());
                        System.out.println("La reserva no ha podido realizarse.");
                        break;
                    }
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
                break;
            case 2:
                System.out.println("Lista de Paquetes disponibles en Argentina:");
                
                for (int i = 0; i < listaPaquetesArgentina.size(); i++) {
                    System.out.println((i + 1) + ". " + listaPaquetesArgentina.get(i).toString());
                }
                System.out.print("Seleccione el paquete que desea reservar: ");
                
                int seleccionPaqueteArgentina = entrada.nextInt();
                entrada.nextLine();
                if (seleccionPaqueteArgentina > 0 && seleccionPaqueteArgentina <= listaPaquetesArgentina.size()) {
                    Paquete paquete = listaPaquetesArgentina.get(seleccionPaqueteArgentina - 1);
                    Pago pagoPaquete = new Pago(cliente);
                    try {
                        pagoPaquete.seleccionarMetodoDePago(entrada);
                        Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), paquete.getPrecio());
                        nuevaReserva.agregarProducto(paquete);
                        cliente.agregarReserva(nuevaReserva);
                        System.out.println("Reserva realizada para: " + paquete.getNombre());
                        System.out.println("¡Gracias por elegir Buquealtoque!");
                        
                        System.out.println("\n¿Querés agregar más productos a la reserva?\n1 - Sí\n2 - No");
                        System.out.println("\nSeleccione una opción: ");
                        
                        int opcionProductoAdicional = entrada.nextInt();
                        switch (opcionProductoAdicional) {
                            case 1: 
                                menuProductoAdicional.accept(nuevaReserva);
                                break;
                            case 2:
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Error al realizar el pago: " + e.getMessage());
                        System.out.println("La reserva no ha podido realizarse.");
                        break;
                    }
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                break;
        }
    }
    
    public static void agregarProductoAdicional(Scanner entrada, Cliente cliente, List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, 
    		List<Pasaje> listaPasajes, List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina, List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina, Reserva nuevaReserva) {
    	// Mostrar lista de paquete
    	System.out.println("Elija el tipo de Paquete según país.");
    	System.out.println("1 - Paquete en Uruguay.");
    	System.out.println("2 - Paquete en Argentina.\n");
    	System.out.print("Seleccione su producto: ");
    	
    	int opcionPaquete = entrada.nextInt();
        entrada.nextLine();
        
        switch(opcionPaquete) {
        	case 1:
                System.out.println("Lista de Paquetes disponibles en Uruguay:");
                
                for (int i = 0; i < listaPaquetesUruguay.size(); i++) {
                    System.out.println((i + 1) + ". " + listaPaquetesUruguay.get(i).toString());
                }
                System.out.print("Seleccione el paquete que desea reservar: ");
                
                int seleccionPaqueteUruguay = entrada.nextInt();
                entrada.nextLine();
                if (seleccionPaqueteUruguay > 0 && seleccionPaqueteUruguay <= listaPaquetesUruguay.size()) {
                    Paquete paquete = listaPaquetesUruguay.get(seleccionPaqueteUruguay - 1);
                    Pago pagoPaquete = new Pago(cliente);
                    try {
                    	pagoPaquete.seleccionarMetodoDePago(entrada);
                        nuevaReserva.agregarProducto(paquete);
                        double precioNuevo = nuevaReserva.calcularValorFinal();
                        nuevaReserva.setValorFinal(precioNuevo);
                        System.out.println("Reserva realizada para: " + paquete.getNombre());
                        System.out.println("¡Gracias por elegir Buquealtoque!");
                        cliente.verificarSiEsVip(cliente, cliente.getReservas());
                        
                    } catch (Exception e) {
                        System.out.println("Error al realizar el pago: " + e.getMessage());
                        System.out.println("La reserva no ha podido realizarse.");
                    }
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
                break;
        	case 2:
                System.out.println("Lista de Paquetes disponibles en Argentina:");
                
                for (int i = 0; i < listaPaquetesArgentina.size(); i++) {
                    System.out.println((i + 1) + ". " + listaPaquetesArgentina.get(i).toString());
                }
                System.out.print("Seleccione el paquete que desea reservar: ");
                
                int seleccionPaqueteArgentina = entrada.nextInt();
                entrada.nextLine();
                if (seleccionPaqueteArgentina > 0 && seleccionPaqueteArgentina <= listaPaquetesArgentina.size()) {
                    Paquete paquete = listaPaquetesArgentina.get(seleccionPaqueteArgentina - 1);
                    Pago pagoPaquete = new Pago(cliente);
                    try {
                    	pagoPaquete.seleccionarMetodoDePago(entrada);
                        nuevaReserva.agregarProducto(paquete);
                        double precioNuevo = nuevaReserva.calcularValorFinal();
                        nuevaReserva.setValorFinal(precioNuevo);
                        System.out.println("Reserva realizada para: " + paquete.getNombre());
                        System.out.println("¡Gracias por elegir Buquealtoque!");
                        cliente.verificarSiEsVip(cliente, cliente.getReservas());
                        
                    } catch (Exception e) {
                        System.out.println("Error al realizar el pago: " + e.getMessage());
                        System.out.println("La reserva no ha podido realizarse.");
                    }
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
                break;
    	
        }
    }

}