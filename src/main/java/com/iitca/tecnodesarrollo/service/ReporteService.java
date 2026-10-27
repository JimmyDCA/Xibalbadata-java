package com.iitca.tecnodesarrollo.service;

import com.iitca.tecnodesarrollo.dto.Lista_pozos;
import com.iitca.tecnodesarrollo.repo.Lista_pozosRepo;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ReporteService {

    private static final Color AZUL = new Color(31, 78, 140);
    private static final Color GRIS_ETIQUETA = new Color(100, 116, 139);
    private static final Color GRIS_LINEA = new Color(226, 232, 240);

    private static final Font F_TITULO = new Font(Font.HELVETICA, 20, Font.BOLD, AZUL);
    private static final Font F_SUBTITULO = new Font(Font.HELVETICA, 10, Font.NORMAL, GRIS_ETIQUETA);
    private static final Font F_SECCION = new Font(Font.HELVETICA, 12, Font.BOLD, Color.WHITE);
    private static final Font F_ETIQUETA = new Font(Font.HELVETICA, 8, Font.BOLD, GRIS_ETIQUETA);
    private static final Font F_VALOR = new Font(Font.HELVETICA, 11, Font.NORMAL, Color.BLACK);
    private static final Font F_VALOR_DESTACADO = new Font(Font.HELVETICA, 11, Font.BOLD, AZUL);

    @Autowired
    private Lista_pozosRepo pozosRepo;

    public byte[] generarReportePozo(int id_lp) {
        // Fuera del try: si no existe, responde 404 en lugar de 500
        Lista_pozos pozo = pozosRepo.findById(id_lp)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Pozo no encontrado con id " + id_lp));

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Document documento = new Document(PageSize.A4, 40, 40, 40, 40);
            PdfWriter.getInstance(documento, baos);
            documento.open();

            // ---------- Encabezado ----------
            Paragraph titulo = new Paragraph("Ficha Técnica del Pozo", F_TITULO);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            Paragraph sub = new Paragraph("Generado el " + fecha, F_SUBTITULO);
            sub.setAlignment(Element.ALIGN_CENTER);
            sub.setSpacingAfter(18);
            documento.add(sub);

        // ---------- 1. Datos Generales ----------
        documento.add(crearSeccion("1. Datos Generales", new String[][]{
                {"CLAVE DEL POZO", txt(pozo.getL_poz_clave(), "Sin registro"), "destacado"},
                {"NOMBRE DE IDENTIFICACIÓN", txt(pozo.getLp_Nombre(), "Sin registro")},
                {"RAMAL", txt(pozo.getLp_ramal(), "No asignado")},
                {"UBICACIÓN / COORDENADAS", txt(pozo.getLp_ubicacion(), "No especificada")}
        }));

        documento.add(crearSeccion("1. Datos Generales", new String[][]{
                {"CLAVE DEL POZO", txt(pozo.getL_poz_clave(), "Sin registro"), "destacado"},
                {"NOMBRE DE IDENTIFICACIÓN", txt(pozo.getLp_Nombre(), "Sin registro")},
                {"RAMAL", txt(pozo.getLp_ramal(), "No asignado")},
                {"UBICACIÓN / COORDENADAS", txt(pozo.getLp_ubicacion(), "No especificada")}
        }));

        // ---------- 2. Características Físicas ----------
        documento.add(crearSeccion("2. Características Físicas", new String[][]{
                {"PROFUNDIDAD DE PERFORACIÓN", txt(pozo.getLp_Profundidad_perforación(), "0") + " metros", "destacado"},
                {"DIÁMETRO DE PERFORACIÓN", txt(pozo.getLp_Diámetro_perforación(), "0") + " pulgadas", "destacado"},
                {"DIÁMETRO DE ADEME", txt(pozo.getLp_Diámetro_ADEME(), "0") + " pulgadas", "destacado"}
        }));

            // ---------- 3. Equipamiento y Aportes ----------
            String subestacion = txt(pozo.getLp_subestacion(), "N/A");
            String circuito = txt(pozo.getLp_circuito_electrico(), "N/A");

            documento.add(crearSeccion("3. Equipamiento y Aportes", new String[][]{
                    {"SUBESTACIÓN / CIRCUITO", subestacion + " | " + circuito}
            }));
            documento.add(crearTablaBanderas(new String[][]{
                    {"ACUEDUCTO", txt(pozo.getLp_aporta_acueducto(), "No"),
                     "COMUNIDAD", txt(pozo.getLp_aporta_comunidad(), "No")},
                    {"RIEGO", txt(pozo.getLp_aporta_riego(), "No"),
                     "P.A. CDMX", txt(pozo.getLp_pa_cdmx(), "No")},
                    {"TELEMETRÍA", txt(pozo.getLp_telemetria(), "No"),
                     "UTR", txt(pozo.getLp_utr(), "No")}
            }));

            documento.close();
            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Error al ensamblar el reporte PDF", e);
        }
    }

    // ==================== Helpers ====================

    /** Sección con encabezado azul y filas etiqueta / valor (2 columnas). */
    private PdfPTable crearSeccion(String titulo, String[][] filas) throws DocumentException {
        PdfPTable tabla = new PdfPTable(2);
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{40f, 60f});
        tabla.setSpacingBefore(10);

        PdfPCell cabecera = new PdfPCell(new Phrase(titulo, F_SECCION));
        cabecera.setColspan(2);
        cabecera.setBackgroundColor(AZUL);
        cabecera.setPadding(8);
        cabecera.setBorder(Rectangle.NO_BORDER);
        tabla.addCell(cabecera);

        for (String[] fila : filas) {
            boolean destacado = fila.length > 2 && "destacado".equals(fila[2]);
            tabla.addCell(celda(fila[0], F_ETIQUETA));
            tabla.addCell(celda(fila[1], destacado ? F_VALOR_DESTACADO : F_VALOR));
        }
        return tabla;
    }

    /** Tabla de 4 columnas: etiqueta, valor, etiqueta, valor (Sí/No). */
    private PdfPTable crearTablaBanderas(String[][] filas) throws DocumentException {
        PdfPTable tabla = new PdfPTable(4);
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{22f, 28f, 22f, 28f});

        for (String[] fila : filas) {
            for (int i = 0; i < 4; i++) {
                tabla.addCell(celda(fila[i], i % 2 == 0 ? F_ETIQUETA : F_VALOR));
            }
        }
        return tabla;
    }

    private PdfPCell celda(String texto, Font fuente) {
        PdfPCell c = new PdfPCell(new Phrase(texto, fuente));
        c.setPadding(7);
        c.setBorder(Rectangle.BOTTOM);
        c.setBorderColor(GRIS_LINEA);
        return c;
    }

    /** Convierte cualquier valor a texto y evita "null". */
    private String txt(Object valor, String porDefecto) {
        if (valor == null) return porDefecto;
        String s = String.valueOf(valor).trim();
        return s.isEmpty() ? porDefecto : s;
    }
}