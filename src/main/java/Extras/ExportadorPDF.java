package Extras;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class ExportadorPDF {

    public static void generarPDF(JTable tabla, String nombreTabla) {
        boolean conf = Mensajes.confirmar("¿Desea generar un reporte PDF de la tabla " + nombreTabla.toLowerCase() + "?");
        if (!conf) {
            return;
        }
        ExportadorPDF.exportarTabla(tabla, nombreTabla);
    }

    private static void exportarTabla(JTable tabla, String nombreTabla) {
        try {
            // 1. Ruta base: escritorio > reportes > nombreTabla
            String escritorio = System.getProperty("user.home") + File.separator + "Desktop";
            String rutaCarpeta = escritorio + File.separator + "reportes" + File.separator + nombreTabla.toLowerCase();
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            // 2. Nombre del archivo con timestamp
            String fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            String nombreArchivo = StringUtils.capitalize(nombreTabla) + "_" + fecha + ".pdf";
            String rutaCompleta = rutaCarpeta + File.separator + nombreArchivo;

            // 3. Crear documento
            Document documento = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(documento, new FileOutputStream(rutaCompleta));
            documento.open();

            // 4. Fuente
            Font fuenteTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font fuenteEncabezado = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font fuenteCelda = new Font(Font.FontFamily.HELVETICA, 11);

            // 5. Título
            Paragraph titulo = new Paragraph("Reporte de " + nombreTabla, fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            documento.add(titulo);

            // 6. Construcción de tabla PDF
            PdfPTable pdfTabla = new PdfPTable(tabla.getColumnCount());
            pdfTabla.setWidthPercentage(100);

            for (int i = 0; i < tabla.getColumnCount(); i++) {
                PdfPCell celdaEncabezado = new PdfPCell(new Phrase(tabla.getColumnName(i), fuenteEncabezado));
                celdaEncabezado.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaEncabezado.setBackgroundColor(BaseColor.LIGHT_GRAY);
                pdfTabla.addCell(celdaEncabezado);
            }

            TableModel modelo = tabla.getModel();
            for (int fila = 0; fila < tabla.getRowCount(); fila++) {
                for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
                    Object valor = modelo.getValueAt(fila, columna);
                    PdfPCell celda = new PdfPCell(new Phrase(valor != null ? valor.toString() : "", fuenteCelda));
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTabla.addCell(celda);
                }
            }

            documento.add(pdfTabla);
            documento.close();

            // 7. Confirmación
            String mensaje = "El reporte se ha guardado en la carpeta *reportes* de su escritorio,\n"
                    + "dentro de la subcarpeta *" + nombreTabla.toLowerCase() + "* con el nombre:\n\n"
                    + nombreArchivo;
            Extras.Mensajes.mostrarMensaje(mensaje, "informacion");

        } catch (Exception e) {
            e.printStackTrace();
            Extras.Mensajes.mostrarMensaje("Error al generar el PDF: " + e.getMessage(), "error");
        }
    }
}
