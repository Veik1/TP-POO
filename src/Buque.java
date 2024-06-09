public class Buque {
    private String nombre;
    private int capacidad;
    private int pasajerosActuales;

    // Constructor con capacidad predeterminada
    public Buque(String nombre) {
        this.nombre = nombre;
        this.capacidad = 10;
        this.pasajerosActuales = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getPasajerosActuales() {
        return pasajerosActuales;
    }

    // Método para verificar si hay capacidad suficiente
    public boolean verificarCapacidad(int cantidad) {
        return (pasajerosActuales + cantidad) <= capacidad;
    }

    // Método para agregar pasajeros
    public void agregarPasajeros(int cantidad) {
        if (verificarCapacidad(cantidad)) {
            pasajerosActuales += cantidad;
        } else {
            throw new IllegalArgumentException("No hay suficiente capacidad en el buque.");
        }
    }
    
    public void restarPasajeros(int cantidad) {
    	pasajerosActuales -= cantidad;             
      
    }

    @Override
    public String toString() {
        return "Buque{" +
                "nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                ", pasajerosActuales=" + pasajerosActuales +
                '}';
    }
}
