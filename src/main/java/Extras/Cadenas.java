package Extras;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Cadenas {

    public static String formatoSoles(double cantidad, boolean redondear) {
        // Si no se debe redondear, devolver el valor con 2 decimales
        if (!redondear) {
            return String.format("S/. %.2f", cantidad);
        }

        // Redondear el valor a múltiplos válidos
        double redondeado = Math.round(cantidad * 10) / 10.0;
        double decimal = redondeado - Math.floor(redondeado);

        if (decimal > 0 && decimal < 0.05) {
            redondeado = Math.floor(redondeado); // Redondear hacia abajo
        } else if (decimal > 0.05) {
            redondeado = Math.ceil(redondeado * 2) / 2; // Redondear hacia el múltiplo más cercano de 0.5
        }

        // Formatear en soles
        return String.format("S/. %.2f", redondeado);
    }

    public static double obtenerPrecioLimpio(String textoPrecio) {
        if (textoPrecio == null || !textoPrecio.startsWith("S/.")) {
            throw new IllegalArgumentException("El texto proporcionado no tiene el formato esperado: 'S/.'.");
        }
        // Eliminar el prefijo "S/." y convertir a double
        return Double.parseDouble(textoPrecio.replace("S/.", "").trim());
    }

}
