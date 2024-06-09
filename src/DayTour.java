import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class DayTour extends Producto {
	private String descripcion;
	private Fecha fechaInicio;
	private String hora;
	private String duracion;
	private String guiaTour;
	
	// Constructor
	DayTour(String nombre, double precio, String descripcion, Fecha fechaInicio, String hora, String duracion, String guiaTour) {
		super(nombre, precio);
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.hora = hora;
		this.duracion = duracion;
		this.guiaTour = guiaTour;
	}
	
	//Getters y setters
	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public Fecha getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Fecha fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
 
	public String getGuiaTour() {
		return guiaTour;
	}


	public void setGuiaTour(String guiaTour) {
		this.guiaTour = guiaTour;
	}
 
	public void mostrarProductos(){
		System.out.println("1- DayTour en Argentina");
		System.out.println("2- DayTour en Uruguay");
	}
	
    @Override
    public String toString() {
        return "Day Tour - " + getNombre() + " " + "| Guia a cargo - " + getGuiaTour();
    }
	
 // Método para crear un DayTour y devolver la instancia creada
    public void crearProducto(Scanner entrada, Cliente cliente,
                                    List<Experiencia> listaExperienciasArgentina,
                                    List<Experiencia> lisaExpertienciasUruguay,
                                    List<Pasaje> listaPasajes,
                                    List<DayTour> listaDayToursUruguay,
                                    List<DayTour> listaDayToursArgentina,
                                    List<Paquete> listaPaquetesUruguay,
                                    List<Paquete> listaPaquetesArgentina,
                                    Consumer<Reserva> menuProductoAdicional) {
        System.out.println("Elija el tipo de Day Tour según país.");
        System.out.println("1 - Day Tour en Uruguay.");
        System.out.println("2 - Day Tour en Argentina.\n");
        System.out.print("Seleccione su producto: ");
        
        int opcionDayTour = entrada.nextInt();
        entrada.nextLine();
        
        List<DayTour> listaDayTours = null;
        String pais = "";

        switch (opcionDayTour) {
            case 1:
                listaDayTours = listaDayToursUruguay;
                pais = "Uruguay";
                break;
            case 2:
                listaDayTours = listaDayToursArgentina;
                pais = "Argentina";
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                return;
        }

        System.out.println("Lista de Day Tours disponibles en " + pais + ":");
        for (int i = 0; i < listaDayTours.size(); i++) {
            System.out.println((i + 1) + ". " + listaDayTours.get(i).toString());
        }
        System.out.print("Seleccione el day tour que desea reservar: ");
        
        int seleccionDayTour = entrada.nextInt();
        entrada.nextLine();
        if (seleccionDayTour > 0 && seleccionDayTour <= listaDayTours.size()) {
            DayTour daytour = listaDayTours.get(seleccionDayTour - 1);
            Pago pagoDayTour = new Pago(cliente);
            try {
                pagoDayTour.seleccionarMetodoDePago(entrada);
                Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), daytour.getPrecio());
                nuevaReserva.agregarProducto(daytour);
                cliente.agregarReserva(nuevaReserva);
                System.out.println("Reserva realizada para: " + daytour.getNombre());
                System.out.println("¡Gracias por elegir Buquealtoque!");
                
                System.out.println("\n¿Querés agregar más productos a la reserva?\n1 - Sí\n2 - No");
                System.out.print("\nSeleccione una opción: ");
                
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
            }
        } else {
            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }
    
    public static void agregarProductoAdicional(Scanner entrada, Cliente cliente, List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, 
    		List<Pasaje> listaPasajes, List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina, List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina, Reserva nuevaReserva) {
    	
    	// Mostrar lista de daytours
    	System.out.println("Elija el tipo de Day Tour según país.");
    	System.out.println("1 - Day Tour en Uruguay.");
    	System.out.println("2 - Day Tour en Argentina.\n");
    	System.out.print("Seleccione su producto: ");
    	
    	int opcionDayTour = entrada.nextInt();
        entrada.nextLine();
        
        switch (opcionDayTour) {
        	case 1:
                System.out.println("Lista de Day Tours disponibles en Uruguay:");
                for (int i = 0; i < listaDayToursUruguay.size(); i++) {
                    System.out.println((i + 1) + ". " + listaDayToursUruguay.get(i).toString());
                }
                System.out.print("Seleccione el day tour que desea reservar: ");
                
                int seleccionDayTourUruguay = entrada.nextInt();
                entrada.nextLine();
                if (seleccionDayTourUruguay > 0 && seleccionDayTourUruguay <= listaDayToursUruguay.size()) {
                    DayTour daytour = listaDayToursUruguay.get(seleccionDayTourUruguay - 1);
                    Pago pagoDayTour = new Pago(cliente);
                    try {
                    	pagoDayTour.seleccionarMetodoDePago(entrada);
                        nuevaReserva.agregarProducto(daytour);
                        double precioNuevo = nuevaReserva.calcularValorFinal();
                        nuevaReserva.setValorFinal(precioNuevo);
                        System.out.println("Reserva realizada para: " + daytour.getNombre());
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
                System.out.println("Lista de Day Tours disponibles en Uruguay:");
                for (int i = 0; i < listaDayToursArgentina.size(); i++) {
                    System.out.println((i + 1) + ". " + listaDayToursArgentina.get(i).toString());
                }
                System.out.print("Seleccione el day tour que desea reservar: ");
                
                int seleccionDayTourArgentina = entrada.nextInt();
                entrada.nextLine();
                if (seleccionDayTourArgentina > 0 && seleccionDayTourArgentina <= listaDayToursArgentina.size()) {
                    DayTour daytour = listaDayToursArgentina.get(seleccionDayTourArgentina - 1);
                    Pago pagoDayTour = new Pago(cliente);
                    try {
                    	pagoDayTour.seleccionarMetodoDePago(entrada);
                        nuevaReserva.agregarProducto(daytour);
                        double precioNuevo = nuevaReserva.calcularValorFinal();
                        nuevaReserva.setValorFinal(precioNuevo);
                        System.out.println("Reserva realizada para: " + daytour.getNombre());
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