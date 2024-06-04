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

        // Listas de experiencias, pasajes y day tours
        List<Pasaje> listaPasajes = new ArrayList<>();
        Pasaje pasaje1 = new Pasaje("Pasaje a Argentina", 300.0, new Fecha("15/06/2024"), "10:00", "18:00", "Buenos Aires", "Punta del este", 1);
        Pasaje pasaje2 = new Pasaje("Pasaje a Uruguay", 450.0, new Fecha("20/07/2024"), "12:00", "20:00", "Punta del este", "Buenos Aires", 1);
        listaPasajes.add(pasaje1);
        listaPasajes.add(pasaje2);
        
        List<Experiencia> listaExperiencias = new ArrayList<>();
        Experiencia experiencia1 = new Experiencia("Playa del Carmen", 100.0, "Una experiencia inolvidable en la playa", "Vacaciones");
        Experiencia experiencia2 = new Experiencia("Montañas Rocosas", 200.0, "Aventura en las montañas", "Aventura");
        Experiencia experiencia3 = new Experiencia("Amazonas", 150.0, "Exploración en la selva", "Exploración");
        listaExperiencias.add(experiencia1);
        listaExperiencias.add(experiencia2);
        listaExperiencias.add(experiencia3);
        
        List<DayTour> listaDayTours = new ArrayList<>();
        DayTour daytour1 = new DayTour("Colonia", 1000.0, "Pasaje ida y vuelta con vianda. Visita museo.", new Fecha("20/06/2024"), "16:30hs", "12hs", "Cristian Ciarallo");
        listaDayTours.add(daytour1);
        
        List<Paquete> listaPaquetes = new ArrayList<>();
        listaPaquetes.add(new Paquete("Pack 1", 100, "Hotel 5 estrellas", pasaje1, experiencia1, daytour1));

        menuPrincipal(opcion, listaClientes, listaExperiencias, listaPasajes, listaDayTours, listaPaquetes);
    }

    public static void menuPrincipal(Scanner entrada, List<Cliente> listaClientes, List<Experiencia> listaExperiencias, List<Pasaje> listaPasajes, List<DayTour> listaDayTours, List<Paquete> listaPaquetes) {
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
                        clienteOpciones(entrada, clienteEncontrado, listaExperiencias, listaPasajes, listaDayTours, listaPaquetes);
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

    public static void clienteOpciones(Scanner entrada, Cliente cliente, List<Experiencia> listaExperiencias, List<Pasaje> listaPasajes, List<DayTour> listaDayTours, List<Paquete> listaPaquete) {
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
                    menuProductos(entrada, cliente, listaExperiencias, listaPasajes, listaDayTours, listaPaquete);
                    break;
                case 2:
                    System.out.println("Esto representa la parte de realizar consultas");
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

    public static void menuProductos(Scanner entrada, Cliente cliente, List<Experiencia> listaExperiencias, List<Pasaje> listaPasajes, List<DayTour> listaDayTours, List<Paquete> listaPaquetes) {
        System.out.println("1- Pasaje");
        System.out.println("2- Experiencia");
        System.out.println("3- Day Tour");
        System.out.println("4- Paquete\n");
        System.out.print("Seleccione su producto: ");

        int opcionProducto = entrada.nextInt();
        entrada.nextLine();
        switch (opcionProducto) {
            case 1:
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
                    Pago pagoPasaje = new Pago(cliente);
                    try {
                        pagoPasaje.seleccionarMetodoDePago(entrada);
                        Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), pasaje.getPrecio());
                        nuevaReserva.agregarProducto(pasaje);
                        double precioNuevo = nuevaReserva.calcularValorFinal();
                        nuevaReserva.setValorFinal(precioNuevo);
                        cliente.agregarReserva(nuevaReserva);
                        System.out.println("Reserva realizada para: " + pasaje.getNombre());
                        System.out.println("¡Gracias por elegir Buquealtoque!");
                        
                        System.out.println("\n¿Querés agregar más productos a la reserva?\n1 - Sí\n2 - No");
                        System.out.println("\nSeleccione una opción: ");
                        
                        int opcionProductoAdicional = entrada.nextInt();
                        switch (opcionProductoAdicional) {
                        case 1: 
                        	menuProductoAdicional(entrada, cliente, listaExperiencias, listaPasajes, listaDayTours, listaPaquetes, nuevaReserva);
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
                break;
            case 2:
                // Mostrar lista de experiencias
                System.out.println("Lista de Experiencias Disponibles:");
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
                        cliente.agregarReserva(nuevaReserva);
                        System.out.println("Reserva realizada para: " + experiencia.getNombre());
                        System.out.println("¡Gracias por elegir Buquealtoque!");
                    } catch (Exception e) {
                        System.out.println("Error al realizar el pago: " + e.getMessage());
                        System.out.println("La reserva no ha podido realizarse.");
                    }
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
                break;
            case 3:
                // Mostrar lista de experiencias
                System.out.println("Lista de Day Tours Disponibles:");
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
                    } catch (Exception e) {
                        System.out.println("Error al realizar el pago: " + e.getMessage());
                        System.out.println("La reserva no ha podido realizarse.");
                    }
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
                
                break;
            case 4:
                // Mostrar lista de paquete
                System.out.println("Lista de Paquetes Disponibles:");
                for (int i = 0; i < listaPaquetes.size(); i++) {
                    System.out.println((i + 1) + ". " + listaPaquetes.get(i).toString());
                }
                System.out.print("Seleccione el paquete que desea reservar: ");
                
                int seleccionPaquete = entrada.nextInt();
                entrada.nextLine();
                if (seleccionPaquete > 0 && seleccionPaquete <= listaPaquetes.size()) {
                    Paquete paquete = listaPaquetes.get(seleccionPaquete - 1);
                    Pago pagoPaquete = new Pago(cliente);
                    try {
                    	pagoPaquete.seleccionarMetodoDePago(entrada);
                        Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), paquete.getPrecio());
                        nuevaReserva.agregarProducto(paquete);
                        cliente.agregarReserva(nuevaReserva);
                        System.out.println("Reserva realizada para: " + paquete.getNombre());
                        System.out.println("¡Gracias por elegir Buquealtoque!");
                    } catch (Exception e) {
                        System.out.println("Error al realizar el pago: " + e.getMessage());
                        System.out.println("La reserva no ha podido realizarse.");
                    }
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                break;
        }
    }
    
    public static void menuProductoAdicional(Scanner entrada, Cliente cliente, List<Experiencia> listaExperiencias, List<Pasaje> listaPasajes, List<DayTour> listaDayTours, List<Paquete> listaPaquetes, Reserva nuevaReserva) {
    	boolean salir = false;
    	
    	 while (!salir) {
    		 System.out.println("1- Pasaje");
    	     System.out.println("2- Experiencia");
    	     System.out.println("3- Day Tour");
    	     System.out.println("4- Paquete\n");
             System.out.println("0 - Salir a Menú\n");
    	     System.out.print("Seleccione su producto adicional: ");
    	     
             int opcion = entrada.nextInt();
             entrada.nextLine();
             
             switch (opcion) {
             case 1:
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
                     Pago pagoPasaje = new Pago(cliente);
                     try {
                    	 pagoPasaje.seleccionarMetodoDePago(entrada);
                         nuevaReserva.agregarProducto(pasaje);
                         double precioNuevo = nuevaReserva.calcularValorFinal();
                         nuevaReserva.setValorFinal(precioNuevo);
                     } catch (Exception e) {
                         System.out.println("Error al realizar el pago: " + e.getMessage());
                         System.out.println("La reserva en el producto adicional no ha podido realizarse.");
                     }
                 } else {
                     System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                 }
                 break;
             case 2:
                 // Mostrar lista de experiencias
                 System.out.println("Lista de Experiencias Disponibles:");
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
                    	 nuevaReserva.agregarProducto(experiencia);
                         double precioNuevo = nuevaReserva.calcularValorFinal();
                         nuevaReserva.setValorFinal(precioNuevo);
                     } catch (Exception e) {
                         System.out.println("Error al realizar el pago: " + e.getMessage());
                         System.out.println("La reserva en el producto adicional no ha podido realizarse.");
                     }
                 } else {
                     System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                 }
                 break;
             case 3:
                 // Mostrar lista de experiencias
                 System.out.println("Lista de Day Tours Disponibles:");
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
                    	 nuevaReserva.agregarProducto(daytour);
                         double precioNuevo = nuevaReserva.calcularValorFinal();
                         nuevaReserva.setValorFinal(precioNuevo);
                     } catch (Exception e) {
                         System.out.println("Error al realizar el pago: " + e.getMessage());
                         System.out.println("La reserva en el producto adicional no ha podido realizarse.");
                     }
                 } else {
                     System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                 }
                 
                 break;
             case 4:
                 // Mostrar lista de paquete
                 System.out.println("Lista de Paquetes Disponibles:");
                 for (int i = 0; i < listaPaquetes.size(); i++) {
                     System.out.println((i + 1) + ". " + listaPaquetes.get(i).toString());
                 }
                 System.out.print("Seleccione el paquete que desea reservar: ");
                 
                 int seleccionPaquete = entrada.nextInt();
                 entrada.nextLine();
                 if (seleccionPaquete > 0 && seleccionPaquete <= listaPaquetes.size()) {
                     Paquete paquete = listaPaquetes.get(seleccionPaquete - 1);
                     Pago pagoPaquete = new Pago(cliente);
                     try {
                    	 pagoPaquete.seleccionarMetodoDePago(entrada);
                         nuevaReserva.agregarProducto(paquete);
                         double precioNuevo = nuevaReserva.calcularValorFinal();
                         nuevaReserva.setValorFinal(precioNuevo);
                     } catch (Exception e) {
                         System.out.println("Error al realizar el pago: " + e.getMessage());
                         System.out.println("La reserva en el producto adicional no ha podido realizarse.");
                     }
                 } else {
                     System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                 }
                 break;
             case 0:
                 salir = true;
                 System.out.println("Regresando al menú...");
                 break;
             default:
                 System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                 break;
         }
    	 }
    }

    public static void menuMetodoPago(Scanner entrada, Cliente cliente) {
        System.out.println("1- Añadir una tarjeta");
        System.out.println("2- Añadir una cuenta bancaria");
        System.out.println("3- Añadir mercado pago");
        System.out.print("Ingrese una opción: ");

        int opcionMetodoPago = entrada.nextInt();
        entrada.nextLine();
        switch (opcionMetodoPago) {
            case 1:
                //Lógica para añadir una tarjeta al cliente
                Tarjeta nuevaTarjeta = Tarjeta.crearTarjeta(entrada);
                cliente.agregarTarjeta(nuevaTarjeta);
                System.out.println("Cuenta de Mercado Pago del cliente: " + nuevaTarjeta);
                break;
            case 2:
                //Lógica para añadir una cuenta bancaria al cliente
                CuentaBancaria nuevaCuentaBancaria = CuentaBancaria.crearCuentaBancaria(entrada);
                cliente.agregarCuentaBancaria(nuevaCuentaBancaria);
                System.out.println("Cuenta de Mercado Pago agregada al cliente: " + nuevaCuentaBancaria);
                break;
            case 3:
                //Lógica para añadir una cuenta bancaria al cliente
                MercadoPago nuevoMercadoPago = MercadoPago.crearMercadoPago(entrada);
                cliente.agregarCuentaMercadoPago(nuevoMercadoPago);
                System.out.println("Cuenta de Mercado Pago agregada al cliente: " + nuevoMercadoPago);
                break;
            default:
                System.out.println("Opcion no válida. Por favor, seleccione una opción válida.");
                break;
        }
    }
    
    public static void menuReservas(Scanner entrada, Cliente cliente) {
        System.out.println("1- Ver mis reservas");
        System.out.println("2- Cancelar una reserva");
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
        }
    }
    
}
