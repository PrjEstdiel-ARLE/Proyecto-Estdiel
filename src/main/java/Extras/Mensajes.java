package Extras;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import javafx.scene.control.ChoiceDialog;
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

    public static String mostrarOpcionesFX(List<String> opciones, String mensaje) {
        if (opciones == null || opciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista de opciones está vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        final String[] seleccion = {null};
        final CountDownLatch latch = new CountDownLatch(1);
        final boolean[] javaFXFunciono = {false};

        try {
            Platform.runLater(() -> {
                try {
                    ChoiceDialog<String> dialog = new ChoiceDialog<>(opciones.get(0), opciones);
                    dialog.setTitle("Selección");
                    dialog.setHeaderText(mensaje);
                    dialog.setContentText("Elija una opción:");
                    dialog.setGraphic(null);

                    Optional<String> resultado = dialog.showAndWait();
                    javaFXFunciono[0] = true; // Marca que JavaFX sí se ejecutó
                    seleccion[0] = resultado.orElse(null);
                } catch (Exception e) {
                    javaFXFunciono[0] = false; // JavaFX falló
                } finally {
                    latch.countDown();
                }
            });

            latch.await();

            // Solo hacer fallback a Swing si JavaFX falló por completo
            if (!javaFXFunciono[0]) {
                return mostrarOpciones(opciones, mensaje);
            }

            return seleccion[0]; // Puede ser null si el usuario canceló

        } catch (Exception e) {
            return mostrarOpciones(opciones, mensaje); // Fallback completo
        }
    }
}
