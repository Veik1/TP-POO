import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar; // Acá importamos calendar para usar las funciones al restringir rango de edad

public class Cliente {
    private int idCliente;
    private boolean clienteVIP;
    private String nombre;
    private String apellido;
    private String dni;
    private String domicilio;
    private Fecha fechaNacimiento;
    private int incumplimientos;
    private String email;
    private String password;
    private static int contadorId = 1;
    private List<Tarjeta> tarjetas;
    private List<CuentaBancaria> cuentasBancarias;
    private List<MercadoPago> cuentasMercadoPago;
    private List<Reserva> reservas;

    // Constructor
    public Cliente(int idCliente, boolean clienteVIP, String nombre, String apellido, String dni,
                   String domicilio, Fecha fechaNacimiento, int incumplimientos, String email, String password) {
        this.idCliente = idCliente;
        this.clienteVIP = clienteVIP;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.incumplimientos = incumplimientos;
        this.email = email;
        this.password = password;
        this.tarjetas = new ArrayList<>();
        this.cuentasBancarias = new ArrayList<>();
        this.cuentasMercadoPago = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Getters and Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public boolean getTipoCliente() {
        return clienteVIP;
    }

    public void setTipoCliente(boolean clienteVIP) {
        this.clienteVIP = clienteVIP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIncumplimientos() {
        return incumplimientos;
    }

    public void setIncumplimientos(int incumplimientos) {
        this.incumplimientos = incumplimientos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public void agregarTarjeta(Tarjeta tarjeta) {
        this.tarjetas.add(tarjeta);
    }
    
    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }
    
    public void setCuentasBancarias(List<CuentaBancaria> cuentasbancarias) {
        this.cuentasBancarias = cuentasbancarias;
    }
    
    public void agregarCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentasBancarias.add(cuentaBancaria);
    }
    
    public List<MercadoPago> getCuentasMercadoPago() {
        return cuentasMercadoPago;
    }
    
    public void setCuentasMercadoPago(List<MercadoPago> cuentasmercadopago) {
        this.cuentasMercadoPago = cuentasmercadopago;
    }
    
    public void agregarCuentaMercadoPago(MercadoPago mercadopago) {
        this.cuentasMercadoPago.add(mercadopago);
    }

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    @Override
    public String toString() {
        return "ID de Cliente = " + idCliente +
        		", Cliente VIP = " + clienteVIP +
                ", Nombre = " + nombre +
                ", Apellido = " + apellido +
                ", DNI = " + dni +
                ", Domicilio = " + domicilio +
                ", Fecha Nac. = " + fechaNacimiento +
                ", Email = " + email + "\n";
    }

    public static Cliente crearCliente(Scanner entrada, List<Cliente> listaClientes) {
        System.out.print("Ingrese el Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Ingrese el Apellido: ");
        String apellido = entrada.nextLine();

        System.out.print("Ingrese el DNI: ");
        String dni = entrada.nextLine();

        System.out.print("Ingrese el Domicilio: ");
        String domicilio = entrada.nextLine();

        Fecha fechaNacimiento = null;
        while(fechaNacimiento == null) {
            System.out.print("Ingrese la Fecha de Nacimiento (dd/MM/aaaa): ");
            fechaNacimiento = Fecha.obtenerFecha(entrada.nextLine());
        }
        
     
     // Validación de edad mínima y máxima
        if (fechaNacimiento != null) {
            int añoNacimiento = fechaNacimiento.getAño();
            int mesNacimiento = fechaNacimiento.getMes();
            int diaNacimiento = fechaNacimiento.getDia();

            Calendar fechaNac = Calendar.getInstance();
            fechaNac.set(añoNacimiento, mesNacimiento - 1, diaNacimiento); // Restamos 1 al mes porque en Calendar, enero es 0
            Calendar fechaActual = Calendar.getInstance();
            fechaActual.add(Calendar.YEAR, -18); // Restar 18 años a la fecha actual

            if (fechaNac.after(fechaActual)) {
                System.out.println("Debe tener al menos 18 años para registrarse.");
                return null;
            } else {
                // Verificar si la edad es mayor a 100 años
                Calendar fechaMaxima = Calendar.getInstance();
                fechaMaxima.add(Calendar.YEAR, -100); // Restar 100 años a la fecha actual

                if (fechaNac.before(fechaMaxima)) {
                    System.out.println("La edad máxima para registrarse es de 100 años.");
                    return null;
                }
            }
        }

        
        System.out.print("Ingrese el Email: ");
        String email = entrada.nextLine();

        System.out.print("Ingrese el Password: ");
        String password = entrada.nextLine();

        Cliente nuevoCliente = new Cliente(contadorId++, false, nombre, apellido, dni, domicilio, fechaNacimiento, 0, email, password);
        listaClientes.add(nuevoCliente); // Agregar el nuevo cliente a la lista
        return nuevoCliente; // Devolver el cliente creado
    }

    public static void mostrarClientes(List<Cliente> listaClientes) {
        System.out.println("\nLista de Clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }

    }
    
    
    public void mostrarReservas(List<Reserva> listaReservas) {
    	
    	if(listaReservas.size() == 0) {
    		System.out.println("No tiene reservas realizadas...");
    	} else {
    		System.out.println("\nLista de Reservas:");
    		for (Reserva reserva : listaReservas) {
    			System.out.println(reserva.toString());
    		}
    	}
    }
    
    public void cancelarReserva(int num, List<Reserva> reservas) {
    	int eliminada=0;
        
    	if(reservas.size()>0) {
        for(int i=0;i<reservas.size();i++) {
        	if(reservas.get(i).getIdReserva()==num) {
        		reservas.remove(i);
                System.out.println("---------------------");
                System.out.println("RESERVA N°"+num+" ELIMINADA");
                System.out.println("---------------------");
                eliminada=1;
            }
        }
        
        if(eliminada==0) {
        	System.out.println("RESERVA N°"+num+" NO EXISTE");
        	}
        } else {
        	System.out.println("RESERVA N°"+num+" NO EXISTE"); 
        	System.out.println("NO HAY RESERVAS CARGADAS");
        }
    }

    public static Cliente buscarCliente(String email, String password, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getEmail().equals(email) && cliente.getPassword().equals(password)) {
                return cliente; // Se encontró el cliente con el correo electrónico y contraseña correctos
            }
        }
        return null; // No se encontró ningún cliente
    }
    
    public void saberHoraPasaje(Cliente cliente, List<Reserva> listaReservas) {
        if (listaReservas.isEmpty()) {
            System.out.println("\nNo tiene reservas realizadas...\n");
        } else {
            boolean foundPasaje = false;
            for (Reserva reserva : listaReservas) {
                for (Producto producto : reserva.getProductos()) {
                    if (producto instanceof Pasaje) {
                        Pasaje pasaje = (Pasaje) producto;  // Cast seguro a Pasaje
                        System.out.println("---------------------------------------");
                        System.out.println("Hora de salida del " + pasaje.getNombre() + ": " + pasaje.getHoraSalida());
                        System.out.println("---------------------------------------\n");
                        foundPasaje = true;
                    }
                }
            }
            if (!foundPasaje) {
                System.out.println("No tiene reservas de pasajes...");
            }
        }
    }
    
   
}
