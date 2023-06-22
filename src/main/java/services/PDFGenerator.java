package services;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.Cliente;
import models.OrdenDeVenta;
import models.OrdenItem;
import models.Producto;
import models.Usuario;

public class PDFGenerator {

    public PDFGenerator() {
    }

    public void crearPDFOrdenDeVenta(Cliente cliente, List<OrdenItem> items, Usuario usuario, OrdenDeVenta orden) {
        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Orden-" + orden.getId() + ".pdf"));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate template = cb.createTemplate(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
            Graphics2D g = template.createGraphics(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

            Font font1 = new Font("Tahoma", Font.BOLD, 24);
            g.setFont(font1);

            g.setColor(Color.BLACK);
            g.drawString("Resumen de la Orden " + orden.getId(), 40, 140);

            Font font2 = new Font("Tahoma", Font.PLAIN, 12);
            g.setFont(font2);
            //datos de cliente
            g.drawString("Cliente: " + cliente.getNombre() + " " + cliente.getApellido(), 40, 160);
            g.drawString("Identificacion: " + cliente.getIdentificacion(), 40, 180);
            g.drawString("Vendedor: " + usuario.getNombre() + " " + usuario.getApellido(), 40, 200);
            g.drawString("Punto de Ventas: " + usuario.getPunto_de_venta().getNombre(), 40, 220);

            //productos
            double total = 0;
            int y = 240;
            for (OrdenItem item : items) {
                g.drawString(item.toString(), 40, y);
                total += item.getPrecio() * item.getCantidad();
                y = y + 20;
            }
            g.drawString("TOTAL: " + total, 40, y);

            g.dispose();
            cb.addTemplate(template, 0, 0);

            document.close();
            JOptionPane.showMessageDialog(null, "El PDF Orden de Venta se ha generado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el pdf." + e);
        }
    }

    public void crearPDFInventario(List<Producto> productos) {
        Document document = new Document();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = today.format(formatter);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Estado de Inventario - " + formattedDate + ".pdf"));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate template = cb.createTemplate(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
            Graphics2D g = template.createGraphics(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

            Font font1 = new Font("Tahoma", Font.BOLD + Font.ROMAN_BASELINE, 24);
            g.setFont(font1);

            g.setColor(Color.BLACK);
            g.drawString("Resumen de estado de Inventario " + formattedDate, 40, 100);

            Font font2 = new Font("Tahoma", Font.PLAIN, 12);
            g.setFont(font2);

            //productos
            int y = 120;
            for (Producto producto : productos) {
                if (producto.getStock() < 10) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLACK);

                }
                g.drawString(producto.getNombre() + " - Stock actual: " + producto.getStock() + " - Proveedor: " + producto.getProveedor().getNombre() + " " + producto.getProveedor().getApellido() + " - Telf: " + producto.getProveedor().getCelular(), 40, y);
                y = y + 20;
            }
            g.dispose();
            cb.addTemplate(template, 0, 0);

            document.close();
            JOptionPane.showMessageDialog(null, "El PDF Estado de Inventario se ha generado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el pdf." + e);
        }
    }

}
