package Extras;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FooterConFechaHora extends PdfPageEventHelper {
    private final Font font = new Font(Font.FontFamily.HELVETICA, 9, Font.ITALIC, BaseColor.GRAY);

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        Phrase footer = new Phrase("Reporte generado el " +
                new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date()), font);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer,
                (document.right() + document.left()) / 2,
                document.bottom() - 10, 0);
    }
}
