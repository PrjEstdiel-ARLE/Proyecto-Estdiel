package Extras;

import java.util.List;
import javax.swing.JOptionPane;

public class Mensajes {
    public static void mostrarMensaje(String mensaje, String tipo) {
        int tipoMensaje;

        tipoMensaje = switch (tipo.toLowerCase()) {
            case "error" ->
                JOptionPane.ERROR_MESSAGE;
            case "informacion" ->
                JOptionPane.INFORMATION_MESSAGE;
            case "advertencia" ->
                JOptionPane.WARNING_MESSAGE;
            case "pregunta" ->
                JOptionPane.QUESTION_MESSAGE;
            default ->
                JOptionPane.PLAIN_MESSAGE;
        };

        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", tipoMensaje);
    }

    public static boolean confirmar(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                mensaje,
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        return (respuesta == JOptionPane.YES_OPTION);
    }

    public static String mostrarOpciones(List<String> opciones, String mensaje) {
        // Convertimos la lista a un arreglo de String para usar en el JOptionPane
        String[] opcionesArray = opciones.toArray(new String[0]);

        // Mostramos el diálogo de selección
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                mensaje,
                "Seleccione una opción",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesArray,
                opcionesArray[0] // Selección inicial por defecto
        );

        return seleccion; // Retornamos la opción seleccionada o null si no se seleccionó ninguna
    }
}
