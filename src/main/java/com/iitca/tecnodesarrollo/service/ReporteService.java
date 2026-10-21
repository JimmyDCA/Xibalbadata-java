package com.iitca.tecnodesarrollo.service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class ReporteService {

    // Próximamente inyectaremos aquí Lista_pozosRepo, MantenimientoRepo y OperacionesRepo

    public byte[] generarReportePozo(int id_lp) {
        // Usamos ByteArrayOutputStream para crear el archivo directamente en la memoria RAM del servidor
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Document documento = new Document();
            PdfWriter.getInstance(documento, baos);

            documento.open();

            // Configuración de la fuente y el título
            Font fuenteTitulo = new Font(Font.HELVETICA, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("Reporte Técnico Consolidado - Pozo ID: " + id_lp, fuenteTitulo);
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            
            documento.add(titulo);
            documento.add(new Paragraph(" ")); // Salto de línea

            // Mensaje temporal
            documento.add(new Paragraph("Documento generado exitosamente desde Spring Boot. En el siguiente paso insertaremos las tablas de datos reales."));

            documento.close();
            return baos.toByteArray(); // Retorna el PDF convertido en bytes

        } catch (Exception e) {
            throw new RuntimeException("Error al ensamblar el reporte PDF", e);
        }
    }
}