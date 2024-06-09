import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner opcion = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        
        // Crear un cliente predefinido
        Cliente clienteEjemplo = null;
        try {
            clienteEjemplo = new Cliente(
                1,  // ID del cliente
                false,  // Tipo de cliente VIP (false para no VIP, true para VIP)
                "Juan",  // Nombre del cliente
                "Perez",  // Apellido del cliente
                "12345678",  // DNI del cliente
                "Calle Falsa 123",  // Domicilio del cliente
                new Fecha("01/01/1990"),  // Fecha de nacimiento del cliente
                0,  // Incumplimientos del cliente
                "test",  // Email del cliente
                "123"  // Contraseña del cliente
            );
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha de nacimiento del cliente: " + e.getMessage());
        }

        if (clienteEjemplo != null) {
            listaClientes.add(clienteEjemplo); // Agregar el cliente predefinido a la lista de clientes
        }

        // creo una instancia de buque para pasar el mismo buque por parametro a la lista de pasajes predefinidos
	    Buque buqueDestinoArgentina = new Buque("El Navegante Soñador");
	    Buque buqueDestinoUruguay = new Buque("El Aventurero Místico");
        
        // Listas de experiencias, pasajes y day tours
        List<Pasaje> listaPasajes = new ArrayList<>();
        Pasaje pasaje1 = new Pasaje("Pasaje a Argentina", 30.0, new Fecha("15/06/2024"), "10:00", "18:00", "Buenos Aires", "Punta del este", 1, buqueDestinoArgentina);
        Pasaje pasaje2 = new Pasaje("Pasaje a Argentina 2 Personas", 60.0, new Fecha("15/06/2024"), "10:00", "18:00", "Buenos Aires", "Punta del este", 2, buqueDestinoArgentina);
        Pasaje pasaje3 = new Pasaje("Pasaje a Argentina 3 Personas", 90.0, new Fecha("15/06/2024"), "10:00", "18:00", "Buenos Aires", "Punta del este", 3, buqueDestinoArgentina);
        Pasaje pasaje4 = new Pasaje("Pasaje a Uruguay", 35.0, new Fecha("20/07/2024"), "12:00", "20:00", "Punta del este", "Buenos Aires", 1, buqueDestinoUruguay);      
        Pasaje pasaje5 = new Pasaje("Pasaje a Uruguay 2 Personas", 70.0, new Fecha("20/07/2024"), "12:00", "20:00", "Punta del este", "Buenos Aires", 2, buqueDestinoUruguay);
        Pasaje pasaje6 = new Pasaje("Pasaje a Uruguay 3 Personas", 105.0, new Fecha("20/07/2024"), "12:00", "20:00", "Punta del este", "Buenos Aires", 3, buqueDestinoUruguay);
        listaPasajes.add(pasaje1);
        listaPasajes.add(pasaje2);
        listaPasajes.add(pasaje3);
        listaPasajes.add(pasaje4);
        listaPasajes.add(pasaje5);
        listaPasajes.add(pasaje6);
        
        List<Experiencia> listaExperienciasUruguay = new ArrayList<>();
        List<Experiencia> listaExperienciasArgentina = new ArrayList<>();
        Experiencia experiencia1 = new Experiencia("Playa del Carmen", 227.0, "Uruguay", "Una experiencia inolvidable en la playa");
        Experiencia experiencia2 = new Experiencia("Montañas Rocosas", 250.0, "Uruguay", "Aventura en las montañas");
        Experiencia experiencia3 = new Experiencia("Piriapolis", 280.0, "Uruguay", "Exploración en la selva");
        Experiencia experiencia4 = new Experiencia("Recorrido Palermo", 200.0, "Argentina", "Una experiencia inolvidable en el barrio porteño");
        Experiencia experiencia5 = new Experiencia("Conoce el planetario", 210.0, "Argentina", "Mirá los planetas de nuestro sistema solar");
        Experiencia experiencia6 = new Experiencia("Teatro Colón y cena", 205.0, "Argentina", "Conoce el teatro más emblemático de Buenos Aires y disfruta de una cena ÚNICA");
        listaExperienciasUruguay.add(experiencia1);
        listaExperienciasUruguay.add(experiencia2);
        listaExperienciasUruguay.add(experiencia3);
        listaExperienciasArgentina.add(experiencia4);
        listaExperienciasArgentina.add(experiencia5);
        listaExperienciasArgentina.add(experiencia6);
        
        List<DayTour> listaDayToursUruguay = new ArrayList<>();
        List<DayTour> listaDayToursArgentina = new ArrayList<>();
        DayTour daytour1 = new DayTour("Colonia", 72.0, "Pasaje ida y vuelta con vianda. Visita museo.", new Fecha("20/06/2024"), "16:30hs", "12hs", "Cristian Ciarallo");
        DayTour daytour2 = new DayTour("BsAs Imbatible", 62.0, "Pasaje ida y vuelta con vianda. Conoce la ciudad.", new Fecha("20/06/2024"), "16:30hs", "12hs", "Cristian Ciarallo");
        listaDayToursUruguay.add(daytour1);
        listaDayToursArgentina.add(daytour2);
        
        List<Paquete> listaPaquetesUruguay = new ArrayList<>();
        List<Paquete> listaPaquetesArgentina = new ArrayList<>();
        Paquete paquete1 = new Paquete("Raices porteñas", 400, "Hotel 5 estrellas", pasaje1, experiencia4, daytour2);
        Paquete paquete2 = new Paquete("Escapada a Buenos Aires", 420, "Hotel 4 estrellas", pasaje1, experiencia5, daytour2);
        Paquete paquete3 = new Paquete("Viaje oriental", 430, "Hotel 5 estrellas", pasaje2, experiencia1, daytour1);
        Paquete paquete4 = new Paquete("Descubre Montevideo", 390, "Hotel 5 estrellas", pasaje2, experiencia3, daytour1);
        listaPaquetesArgentina.add(paquete1);
        listaPaquetesArgentina.add(paquete2);
        listaPaquetesUruguay.add(paquete3);
        listaPaquetesUruguay.add(paquete4);

        menuPrincipal(opcion, listaClientes, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina);
    }

    public static void menuPrincipal(Scanner entrada, List<Cliente> listaClientes, List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, 
    		List<Pasaje> listaPasajes, List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina, List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina) {
    	
        boolean salir = false;
        while (!salir) {
            System.out.println("Menú Principal\n");
            System.out.println("1- Crear una cuenta");
            System.out.println("2- Ya tengo una cuenta");
            System.out.println("0- Salir\n");
            System.out.print("Seleccione una opción: ");

            int opcion = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcion) {
                case 1:
                    Cliente nuevoCliente = Cliente.crearCliente(entrada, listaClientes);
                    if (nuevoCliente != null) {
                        System.out.println("Cliente creado: " + nuevoCliente);
                    }
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada: Ya tengo una cuenta.");
                    System.out.print("Ingrese el Email: ");
                    String email = entrada.nextLine();
                    System.out.print("Ingrese el Password: ");
                    String password = entrada.nextLine();
                    Cliente clienteEncontrado = Cliente.buscarCliente(email, password, listaClientes);
                    if (clienteEncontrado != null) {
                        System.out.println("Cliente encontrado: " + clienteEncontrado);
                        clienteOpciones(entrada, clienteEncontrado, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.\n\n");
                    break;
            }
        }
    }

    public static void clienteOpciones(Scanner entrada, Cliente cliente, List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, 
    		List<Pasaje> listaPasajes, List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina, List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina) {
    	
        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú de opciones: \n");
            System.out.println("1 - Realizar reserva");
            System.out.println("2 - Realizar consulta");
            System.out.println("3 - Mis reservas");
            System.out.println("4 - Métodos de pago");
            System.out.println("0 - Salir a Menú Principal\n");
            System.out.print("Ingrese una opción: ");

            int opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    menuProductos(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina);
                    break;
                case 2:
                	menuSoporte(entrada, cliente);
                    break;
                case 3:
                    menuReservas(entrada, cliente);
                    break;
                case 4:
                    menuMetodoPago(entrada, cliente);
                    break;
                case 0:
                    salir = true;
                    System.out.println("Regresando al menú...");
                    break;
                default:
                    System.out.println("Error, ingrese una opción válida");
                    break;
            }
        }
    }

    public static void menuProductos(Scanner entrada, Cliente cliente, 
    	    List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, 
    	    List<Pasaje> listaPasajes, List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina, 
    	    List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina) {

    	    

    	    System.out.println("\nMenú de productos: \n");
    	    System.out.println("1 - Pasaje");
    	    System.out.println("2 - Experiencia");
    	    System.out.println("3 - Day Tour");
    	    System.out.println("4 - Paquete");
    	    System.out.println("0 - Salir del menú\n");
    	    System.out.print("Seleccione su producto: ");

    	    int opcionProducto = entrada.nextInt();
    	    entrada.nextLine();

    	    switch (opcionProducto) {
    	        case 1:
    	            Pasaje pasaje = new Pasaje("Pasaje", 0, null, null, null, null, null, 0, null);
    	            pasaje.crearProducto(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, 
    	                listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina, 
    	                reserva -> menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, 
    	                                                  listaPasajes, listaDayToursUruguay, listaDayToursArgentina, 
    	                                                  listaPaquetesUruguay, listaPaquetesArgentina, reserva));
    	            break;
            case 2:
                Experiencia experiencia = new Experiencia("Experiencia", 0, null, null);
                experiencia.crearProducto(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, 
                        listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina, 
                        reserva -> menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, 
                                                          listaPasajes, listaDayToursUruguay, listaDayToursArgentina, 
                                                          listaPaquetesUruguay, listaPaquetesArgentina, reserva));
                break;
            case 3:
                DayTour dayTour = new DayTour("Day Tour", 0, null, null, null, null, null);
                dayTour.crearProducto(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, 
                        listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina, 
                        reserva -> menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, 
                                                          listaPasajes, listaDayToursUruguay, listaDayToursArgentina, 
                                                          listaPaquetesUruguay, listaPaquetesArgentina, reserva));
                break;
            case 4:
                Paquete paquete = new Paquete("Paquete", 0, null, null, null, null);
                paquete.crearProducto(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, 
                        listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina, 
                        reserva -> menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, 
                                                          listaPasajes, listaDayToursUruguay, listaDayToursArgentina, 
                                                          listaPaquetesUruguay, listaPaquetesArgentina, reserva));
                break;
            case 0:
                // Lógica para salir del menú
                System.out.println("Saliendo del menú...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                break;
        }
    }
    
    public static void menuProductoAdicional(Scanner entrada, Cliente cliente, List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, 
    		List<Pasaje> listaPasajes, List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina, List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina, Reserva nuevaReserva) {
    	boolean salir = false;
    	
    	while (!salir) {
    		System.out.println("\n");
    		System.out.println("1 - Pasaje");
    	    System.out.println("2 - Experiencia");
    	    System.out.println("3 - Day Tour");
    	    System.out.println("4 - Paquete\n");    
    	    System.out.println("0 - Finalizar reserva\n");
    	    System.out.print("Seleccione su producto adicional: ");
    	     
            int opcion = entrada.nextInt();
            entrada.nextLine();
             
            switch (opcion) {
            case 1:
                Pasaje.agregarProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
                break;
            case 2:
            	Experiencia.agregarProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
                break;
            case 3:
            	DayTour.agregarProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
                break;
            case 4:
            	Paquete.agregarProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina, listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
                break;
            case 0:
            	salir = true;
            	break;
            default:
            	System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            	break;
            }
    	}
    }
    
    public static void menuSoporte(Scanner entrada, Cliente cliente) {
    	boolean salir = false;
    	System.out.println("\n¡Bienvenido al soporte de Buquealtoque, " + cliente.getNombre() + "!");
    	
    	while (!salir) {
            System.out.println("¿En qué puedo ayudarte?\n");
            System.out.println("1 - ¿A qué hora salen mi/s viaje/s?");
            System.out.println("2 - ¿Se pueden llevar animales?");
            System.out.println("3 - ¿Hay juegos para los chicos en el viaje?");
            System.out.println("4 - ¿Se pueden ver películas en los viajes?");
            System.out.println("5 - ¿Cómo puedo ser un cliente VIP?");
            System.out.println("0 - Salir del menú\n");
            System.out.print("Ingrese una opción: ");

            int opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea después de ingresar la opción
            
            switch (opcion) {
            	case 1:
            		// Lógica para consultar la hora de viaje usando el número de reserva
                    System.out.print("\n");
            		cliente.saberHoraPasaje(cliente, cliente.getReservas());
            		break;
                case 2:
                    System.out.println("Sí, se permiten animales en los viajes. Por favor, asegúrate de cumplir con los requisitos establecidos antes de viajar.\n");
                    break;
                case 3:
                    System.out.println("Sí, hay juegos para los chicos en el viaje. Contamos con una sala de juegos para entretener a los más pequeños.\n");
                    break;
                case 4:
                    System.out.println("Sí, se proyectan películas durante los viajes para que los pasajeros puedan disfrutar.\n");
                    break;
                case 5:
                	System.out.print("\n");
                	System.out.println("Para ser un cliente debe, por lo menos, realizar una compra que supere los $500.");
                	if(cliente.getTipoCliente()) {
                		System.out.println("¡Felicitaciones " + cliente.getNombre() + ", sos un cliente VIP!");
                	} else {
                		System.out.println("Aún no cumplís el requisito para ser un cliente VIP, " + cliente.getNombre() + ".");
                	}
                	break;
                case 0:
                	salir = true;
                    System.out.println("Gracias por usar el soporte de Buquealtoque. ¡Que tengas un buen día!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.\n");
            }
    	}
    }

    public static void menuMetodoPago(Scanner entrada, Cliente cliente) {
    	boolean salir = false;
    	while (!salir) {
        	System.out.println("\nMenú de métodos de pago\n");
            System.out.println("1 - Añadir una tarjeta");
            System.out.println("2 - Añadir una cuenta bancaria");
            System.out.println("3 - Añadir mercado pago");
            System.out.println("0 - Volver al menú de reservas\n");
            System.out.print("Ingrese una opción: ");

            int opcionMetodoPago = entrada.nextInt();
            entrada.nextLine();
            switch (opcionMetodoPago) {
                case 1:
                    //Lógica para añadir una tarjeta al cliente
                    Tarjeta nuevaTarjeta = Tarjeta.crearTarjeta(entrada);
                    cliente.agregarTarjeta(nuevaTarjeta);
                    System.out.println("Tarjeta de crédito añadida correctamente al cliente: " + nuevaTarjeta);
                    break;
                case 2:
                    //Lógica para añadir una cuenta bancaria al cliente
                    CuentaBancaria nuevaCuentaBancaria = CuentaBancaria.crearCuentaBancaria(entrada);
                    cliente.agregarCuentaBancaria(nuevaCuentaBancaria);
                    System.out.println("Cuenta bancaria añadida correctamente al cliente: " + nuevaCuentaBancaria);
                    break;
                case 3:
                    //Lógica para añadir una cuenta bancaria al cliente
                    MercadoPago nuevoMercadoPago = MercadoPago.crearMercadoPago(entrada);
                    cliente.agregarCuentaMercadoPago(nuevoMercadoPago);
                    System.out.println("Cuenta de Mercado Pago añadida correctamente al cliente: " + nuevoMercadoPago);
                    break;
            	case 0:
            		salir = true;
            		break;
            	default:
            		System.out.println("Opcion no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
    
    public static void menuReservas(Scanner entrada, Cliente cliente) {
    	boolean salir = false;
    	while (!salir) {
        	System.out.println("\nMenú de reservas\n");
            System.out.println("1 - Ver mis reservas");
            System.out.println("2 - Cancelar una reserva");
            System.out.println("0 - Salir del menú\n");
            System.out.print("Seleccione su opción: ");

            int opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
            	case 1:
            		cliente.mostrarReservas(cliente.getReservas());
            		break;
            	case 2:
            		System.out.print("Seleccione la reserva a borrar por ID: ");
            		int opcionBorrar = entrada.nextInt();
            		cliente.cancelarReserva(opcionBorrar, cliente.getReservas());
            	
            		break;
            	case 0:
            		salir = true;
            		break;
            	default:
            		System.out.println("Opcion no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
    
}
