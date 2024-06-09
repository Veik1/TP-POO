import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

class Experiencia extends Producto {
    private String lugar;
    private String descripcion;

    // Constructor
    public Experiencia(String nombre, double precio, String lugar, String descripcion) {
        super(nombre, precio);
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    // Getters específicos
    public String getLugar() {
        return lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Experiencia - " + getNombre();
    }

    // Método para mostrar las opciones de experiencia
    public void mostrarProductos() {
        System.out.println("Opciones de Experiencia:");
        System.out.println("1- Experiencia en Argentina");
        System.out.println("2- Experiencia en Uruguay");
    }

    // Método para crear una experiencia y devolver la instancia creada
    public void crearProducto(Scanner entrada, Cliente cliente,
                                        List<Experiencia> listaExperienciasUruguay,
                                        List<Experiencia> listaExperienciasArgentina,
                                        List<Pasaje> listaPasajes,
                                        List<DayTour> listaDayToursUruguay,
                                        List<DayTour> listaDayToursArgentina,
                                        List<Paquete> listaPaquetesUruguay,
                                        List<Paquete> listaPaquetesArgentina,
                                        Consumer<Reserva> menuProductoAdicional) {
        System.out.println("Seleccione el país para ver las experiencias disponibles:");
        System.out.println("1. Uruguay");
        System.out.println("2. Argentina");
        System.out.print("Ingrese su opción: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();

        List<Experiencia> listaExperiencias = null;
        String pais = "";

        switch (opcion) {
            case 1:
                listaExperiencias = listaExperienciasUruguay;
                pais = "Uruguay";
                break;
            case 2:
                listaExperiencias = listaExperienciasArgentina;
                pais = "Argentina";
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                return;
        }

        System.out.println("Lista de Experiencias en " + pais + " disponibles:");
        for (int i = 0; i < listaExperiencias.size(); i++) {
            System.out.println((i + 1) + ". " + listaExperiencias.get(i).toString());
        }
        System.out.print("Seleccione la experiencia que desea reservar: ");
        int seleccionExperiencia = entrada.nextInt();
        entrada.nextLine();
        if (seleccionExperiencia > 0 && seleccionExperiencia <= listaExperiencias.size()) {
            Experiencia experiencia = listaExperiencias.get(seleccionExperiencia - 1);
            Pago pagoExperiencia = new Pago(cliente);
            try {
                pagoExperiencia.seleccionarMetodoDePago(entrada);
                Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), experiencia.getPrecio());
                nuevaReserva.agregarProducto(experiencia);
                double precioNuevo = nuevaReserva.calcularValorFinal();
                nuevaReserva.setValorFinal(precioNuevo);
                cliente.agregarReserva(nuevaReserva);
                System.out.println("Reserva realizada para: " + experiencia.getNombre());
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
    	// Mostrar lista de experiencias
    	System.out.println("Elija el tipo de experiencia según país.");
    	System.out.println("1 - Experiencias en Uruguay.");
    	System.out.println("2 - Experiencias en Argentina.\n");
    	System.out.print("Seleccione su producto: ");
    	
    	int opcionExperiencia = entrada.nextInt();
        entrada.nextLine();
    	
        switch (opcionExperiencia) {
        	case 1:
                System.out.println("Lista de Experiencias en Uruguay disponibles:");
                for (int i = 0; i < listaExperienciasUruguay.size(); i++) {
                    System.out.println((i + 1) + ". " + listaExperienciasUruguay.get(i).toString());
                }
                System.out.print("Seleccione la experiencia que desea reservar: ");
                
                int seleccionExperienciaUruguay = entrada.nextInt();
                entrada.nextLine();
                if (seleccionExperienciaUruguay > 0 && seleccionExperienciaUruguay <= listaExperienciasUruguay.size()) {
                    Experiencia experiencia = listaExperienciasUruguay.get(seleccionExperienciaUruguay - 1);
                    Pago pagoExperiencia = new Pago(cliente);
                    try {
                        pagoExperiencia.seleccionarMetodoDePago(entrada);
                        nuevaReserva.agregarProducto(experiencia);
                        double precioNuevo = nuevaReserva.calcularValorFinal();
                        nuevaReserva.setValorFinal(precioNuevo);
                        System.out.println("Reserva realizada para: " + experiencia.getNombre());
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
                System.out.println("Lista de Experiencias en Argentina disponibles:");
                for (int i = 0; i < listaExperienciasArgentina.size(); i++) {
                    System.out.println((i + 1) + ". " + listaExperienciasArgentina.get(i).toString());
                }
                System.out.print("Seleccione la experiencia que desea reservar: ");
                
                int seleccionExperienciaArgentina = entrada.nextInt();
                entrada.nextLine();
                if (seleccionExperienciaArgentina > 0 && seleccionExperienciaArgentina <= listaExperienciasArgentina.size()) {
                    Experiencia experiencia = listaExperienciasArgentina.get(seleccionExperienciaArgentina - 1);
                    Pago pagoExperiencia = new Pago(cliente);
                    try {
                        pagoExperiencia.seleccionarMetodoDePago(entrada);
                        nuevaReserva.agregarProducto(experiencia);
                        double precioNuevo = nuevaReserva.calcularValorFinal();
                        nuevaReserva.setValorFinal(precioNuevo);
                        System.out.println("Reserva realizada para: " + experiencia.getNombre());
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

    // Método para mostrar la experiencia creada
    public void mostrarExperiencia(Experiencia experiencia) {
        System.out.println("Experiencia creada:");
        System.out.println("Nombre: " + experiencia.getNombre());
        System.out.println("Precio: " + experiencia.getPrecio());
        System.out.println("Lugar: " + experiencia.getLugar());
        System.out.println("Descripción: " + experiencia.getDescripcion());
    }
}
