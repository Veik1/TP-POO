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
        Pasaje pasaje1 = new Pasaje("Pasaje a Argentina", 30.0, new Fecha("15/06/2024"), "10:00", "18:00", "Buenos Aires", "Punta del este", 1);
        Pasaje pasaje2 = new Pasaje("Pasaje a Uruguay", 35.0, new Fecha("20/07/2024"), "12:00", "20:00", "Punta del este", "Buenos Aires", 1);
        listaPasajes.add(pasaje1);
        listaPasajes.add(pasaje2);
        
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
        Paquete paquete1 = new Paquete("Raices porteñas", 6, "Hotel 5 estrellas", pasaje1, experiencia4, daytour2);
        Paquete paquete2 = new Paquete("Escapada a Buenos Aires", 6, "Hotel 4 estrellas", pasaje1, experiencia5, daytour2);
        Paquete paquete3 = new Paquete("Viaje oriental", 6, "Hotel 5 estrellas", pasaje2, experiencia1, daytour1);
        Paquete paquete4 = new Paquete("Descubre Montevideo", 6, "Hotel 5 estrellas", pasaje2, experiencia3, daytour1);
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

    public static void menuProductos(Scanner entrada, Cliente cliente, List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, 
    		List<Pasaje> listaPasajes, List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina, List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina) {
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
                        	menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina,
                        			listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
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
                                Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), experiencia.getPrecio());
                                nuevaReserva.agregarProducto(experiencia);
                                cliente.agregarReserva(nuevaReserva);
                                System.out.println("Reserva realizada para: " + experiencia.getNombre());
                                System.out.println("¡Gracias por elegir Buquealtoque!");
                                
                                System.out.println("\n¿Querés agregar más productos a la reserva?\n1 - Sí\n2 - No");
                                System.out.println("\nSeleccione una opción: ");
                                
                                int opcionProductoAdicional = entrada.nextInt();
                                switch (opcionProductoAdicional) {
                                case 1: 
                                	menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina,
                                			listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
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
                                Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), experiencia.getPrecio());
                                nuevaReserva.agregarProducto(experiencia);
                                cliente.agregarReserva(nuevaReserva);
                                System.out.println("Reserva realizada para: " + experiencia.getNombre());
                                System.out.println("¡Gracias por elegir Buquealtoque!");
                                
                                System.out.println("\n¿Querés agregar más productos a la reserva?\n1 - Sí\n2 - No");
                                System.out.println("\nSeleccione una opción: ");
                                
                                int opcionProductoAdicional = entrada.nextInt();
                                switch (opcionProductoAdicional) {
                                case 1: 
                                	menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina,
                                			listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
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
                }
                break;
            case 3:
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
                                Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), daytour.getPrecio());
                                nuevaReserva.agregarProducto(daytour);
                                cliente.agregarReserva(nuevaReserva);
                                System.out.println("Reserva realizada para: " + daytour.getNombre());
                                System.out.println("¡Gracias por elegir Buquealtoque!");
                                
                                System.out.println("\n¿Querés agregar más productos a la reserva?\n1 - Sí\n2 - No");
                                System.out.println("\nSeleccione una opción: ");
                                
                                int opcionProductoAdicional = entrada.nextInt();
                                switch (opcionProductoAdicional) {
                                case 1: 
                                	menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina,
                                			listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
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
                                Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", Fecha.obtenerFechaYHoraActual(), daytour.getPrecio());
                                nuevaReserva.agregarProducto(daytour);
                                cliente.agregarReserva(nuevaReserva);
                                System.out.println("Reserva realizada para: " + daytour.getNombre());
                                System.out.println("¡Gracias por elegir Buquealtoque!");
                                
                                System.out.println("\n¿Querés agregar más productos a la reserva?\n1 - Sí\n2 - No");
                                System.out.println("\nSeleccione una opción: ");
                                
                                int opcionProductoAdicional = entrada.nextInt();
                                switch (opcionProductoAdicional) {
                                case 1: 
                                	menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina,
                                			listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
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
                }
                break;
            case 4:
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
                                	menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina,
                                			listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
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
                                	menuProductoAdicional(entrada, cliente, listaExperienciasUruguay, listaExperienciasArgentina, listaPasajes, listaDayToursUruguay, listaDayToursArgentina,
                                			listaPaquetesUruguay, listaPaquetesArgentina, nuevaReserva);
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
                break;
        }
    }
    
    public static void menuProductoAdicional(Scanner entrada, Cliente cliente, List<Experiencia> listaExperienciasUruguay, List<Experiencia> listaExperienciasArgentina, 
    		List<Pasaje> listaPasajes, List<DayTour> listaDayToursUruguay, List<DayTour> listaDayToursArgentina, List<Paquete> listaPaquetesUruguay, List<Paquete> listaPaquetesArgentina, Reserva nuevaReserva) {
    	boolean salir = false;
    	
    	while (!salir) {
    		System.out.println("1 - Pasaje");
    	    System.out.println("2 - Experiencia");
    	    System.out.println("3 - Day Tour");
    	    System.out.println("4 - Paquete\n");
    	    System.out.println("0 - Salir del menú\n");
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
                            } catch (Exception e) {
                                System.out.println("Error al realizar el pago: " + e.getMessage());
                                System.out.println("La reserva no ha podido realizarse.");
                            }
                        } else {
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        }
                        break;
                }
                break;
            case 3:
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
                            } catch (Exception e) {
                                System.out.println("Error al realizar el pago: " + e.getMessage());
                                System.out.println("La reserva no ha podido realizarse.");
                            }
                        } else {
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        }
                        break;
                }
                break;
            case 4:
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
                            } catch (Exception e) {
                                System.out.println("Error al realizar el pago: " + e.getMessage());
                                System.out.println("La reserva no ha podido realizarse.");
                            }
                        } else {
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        }
                        break;
                }
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
        	System.out.println("\nMenú de métodos de pago: \n");
            System.out.println("1 - Añadir una tarjeta");
            System.out.println("2 - Añadir una cuenta bancaria");
            System.out.println("3 - Añadir mercado pago");
            System.out.println("0 - Salir\n");
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
                    System.out.println("Cuenta bancaria agregada al cliente: " + nuevaCuentaBancaria);
                    break;
                case 3:
                    //Lógica para añadir una cuenta bancaria al cliente
                    MercadoPago nuevoMercadoPago = MercadoPago.crearMercadoPago(entrada);
                    cliente.agregarCuentaMercadoPago(nuevoMercadoPago);
                    System.out.println("Cuenta de Mercado Pago agregada al cliente: " + nuevoMercadoPago);
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
        	System.out.println("\nMenú de reservas: \n");
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