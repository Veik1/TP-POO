import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechaCorta {
    private int mes;
    private int año;

    public FechaCorta(String fechaString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        dateFormat.setLenient(false); // Hacer que el parsing sea estricto
        Date fecha = dateFormat.parse(fechaString);

        // Obtener los componentes de la fecha
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        this.mes = calendar.get(Calendar.MONTH) + 1; // Se suma 1 porque en Calendar, enero es 0
        this.año = calendar.get(Calendar.YEAR);

        // Validar la fecha
        if (!validarFecha()) {
            throw new ParseException("Fecha inválida", 0);
        }
    }
    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return String.format("%02d/%d", mes, año);
    }

    // Método para validar la fecha en su totalidad
    private boolean validarFecha() {
        boolean fechaValida = true;

        // Validar que el año esté entre 2025 y el 2036
        if (año < 2025 || año > 2036) {
            System.out.println("El año debe estar entre 2025 y el 2036.");
            fechaValida = false;
        }

        // Validar que el mes esté entre 1 y 12
        else if (mes < 1 || mes > 12) {
            System.out.println("El mes debe estar entre 1 y 12.");
            fechaValida = false;
        }

        return fechaValida;
    }
    
    public static FechaCorta obtenerFecha(String fechaString) {
        try {
            return new FechaCorta(fechaString);
        } catch (ParseException  e) {
            System.out.println("Formato de fecha incorrecto o fecha inválida. Intente nuevamente.");
            return null; // En caso de excepción, devolver null
        }
    }
    
    
}
