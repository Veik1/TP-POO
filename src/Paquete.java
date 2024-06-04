import java.util.ArrayList;
import java.util.List;

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

}