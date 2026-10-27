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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.iitca.tecnodesarrollo.dto.Mantenimiento;
import com.iitca.tecnodesarrollo.dto.Operacion;
import com.iitca.tecnodesarrollo.repo.MantenimientoRepo;
import com.iitca.tecnodesarrollo.repo.OperacionRepo;
import org.springframework.data.domain.PageRequest;
import java.util.ArrayList;
import java.util.List;


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
    
    private static final int MAX_OPERACIONES = 50;   // últimas N operaciones en el PDF
    private static final Font F_TABLA = new Font(Font.HELVETICA, 8, Font.NORMAL, Color.BLACK);
    private static final Font F_TABLA_ENC = new Font(Font.HELVETICA, 7, Font.BOLD, GRIS_ETIQUETA);

    @Autowired
    private MantenimientoRepo mantenimientoRepo;

    @Autowired
    private OperacionRepo operacionRepo;

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

                // ---------- 4. Mantenimiento ----------
        String clavePozo = pozo.getL_poz_clave();
        Mantenimiento m = (clavePozo == null || clavePozo.isBlank())
                ? null
                : mantenimientoRepo.buscarPorClave(clavePozo.trim(), PageRequest.of(0, 1))
                        .stream().findFirst().orElse(null);        
            if (m != null) {
            List<String[]> campos = new ArrayList<>();
            campo(campos, "MOTOR - TIPO", m.getMtto_motor_tipo(), "");
            campo(campos, "MOTOR - POTENCIA", m.getMtto_motor_hp(), " HP");
            campo(campos, "MOTOR - POTENCIA", m.getMtto_motor_kw(), " kW");
            campo(campos, "MOTOR - EFICIENCIA", m.getMtto_motor_eficiencia(), " %");
            campo(campos, "TABLERO - TIPO", m.getMtto_tablero_tipo(), "");
            campo(campos, "TABLERO - CAPACIDAD", m.getMtto_tablero_capacidad(), "");
            campo(campos, "TRANSFORMADOR - TIPO", m.getMtto_transformador_tipo(), "");
            campo(campos, "TRANSFORMADOR - CAPACIDAD", m.getMtto_transformador_capacidad(), "");
            campo(campos, "TRANSFORMADOR SECO", m.getMtto_trans_seco(), "");
            campo(campos, "CABLE TRANSFORMADOR", m.getMtto_cable_transformador(), "");
            campo(campos, "CALIBRE SUMERGIBLE", m.getMtto_calibre_sumergible(), "");
            campo(campos, "LONGITUD SUMERGIBLE", m.getMtto_longitud_sumergible(), "");
            campo(campos, "CABLE BOMBA", m.getMtto_cable_bomba(), "");
            campo(campos, "CALIBRE BOMBA", m.getMtto_calibre_bomba(), "");
            campo(campos, "LONGITUD BOMBA", m.getMtto_longitud_bomba(), "");
            campo(campos, "CALIBRE ARRANCADOR", m.getMtto_calibre_arrancador(), "");
            campo(campos, "LONGITUD ARRANCADOR", m.getMtto_longitud_arrancador(), "");
            campo(campos, "TUBERÍA - DIÁMETRO", m.getMtto_tuberia_diametro(), "");
            campo(campos, "TUBERÍA - LONGITUD", m.getMtto_tuberia_longitud(), "");
            campo(campos, "POLIDUCTO", m.getMtto_poliducto(), "");
            campo(campos, "MEDIDOR DE PRESIÓN", m.getMtto_medidor_presion(), "");
            campo(campos, "MEDIDOR DE FLUJO", m.getMtto_medidor_flujo(), "");
            campo(campos, "MEDIDOR NE", m.getMtto_medidor_NE(), "");
            campo(campos, "MEDIDOR ND", m.getMtto_medidor_ND(), "");
            campo(campos, "SISTEMA DE TIERRAS", m.getMtto_sistema_tierras(), "");
            campo(campos, "PANEL SOLAR", m.getMtto_panel_solar(), "");
            campo(campos, "BANCO DE BATERÍAS", m.getMtto_banco_baterias(), "");
            campo(campos, "ELÉCTRICA EXTERIOR", m.getMtto_electrica_exterior(), "");
            campo(campos, "ELÉCTRICA INFERIOR", m.getMtto_electrica_inferior(), "");
            campo(campos, "INSTALACIÓN SANITARIA", m.getMtto_sanitaria(), "");
            campo(campos, "FECHA DE CAPTURA", m.getMtto_fecha_captura(), "");

            String obs = m.getMtto_observaciones();
            if (!campos.isEmpty() || (obs != null && !obs.isBlank())) {
                documento.add(crearSeccionCampos("4. Mantenimiento y Equipo Instalado", campos, obs));
            }
        }

        // ---------- 5. Operaciones ----------
        List<Operacion> operaciones = operacionRepo.buscarPorPozo(id_lp, PageRequest.of(0, MAX_OPERACIONES));
        if (!operaciones.isEmpty()) {
            List<String[]> filas = new ArrayList<>();
            for (Operacion o : operaciones) {
                filas.add(new String[]{
                        fecha(o.getOp_fecha_captura()),
                        txt(o.getOp_operando(), "—"),
                        txt(o.getOp_nestatico(), "—"),
                        txt(o.getOp_ndinamico(), "—"),
                        txt(o.getOp_gasto(), "—"),
                        txt(o.getOp_presion(), "—"),
                        txt(o.getOp_tiempo_op(), "—"),
                        txt(o.getOp_operador(), "—"),
                        txt(o.getOp_observaciones(), "—")
                });
            }
            documento.add(crearTablaRegistros(
                    "5. Historial de Operaciones (últimos " + MAX_OPERACIONES + " registros)",
                    new String[]{"FECHA", "OPERANDO", "N. ESTÁTICO", "N. DINÁMICO", "GASTO", "PRESIÓN", "TIEMPO OP.", "OPERADOR", "OBSERVACIONES"},
                    new float[]{13f, 9f, 8f, 8f, 8f, 8f, 8f, 12f, 26f},
                    filas));
        }

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

        /** Agrega un campo solo si tiene valor; así el PDF no se llena de "—". */
    private void campo(List<String[]> lista, String etiqueta, Object valor, String unidad) {
        if (valor == null) return;
        String texto = (valor instanceof LocalDateTime d) ? fecha(d) : String.valueOf(valor).trim();
        if (texto.isEmpty()) return;
        lista.add(new String[]{etiqueta, texto + unidad});
    }

    /** Sección de 4 columnas (etiqueta, valor, etiqueta, valor) con observaciones opcionales a todo el ancho. */
    private PdfPTable crearSeccionCampos(String titulo, List<String[]> campos, String observaciones)
            throws DocumentException {
        PdfPTable tabla = new PdfPTable(4);
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{24f, 26f, 24f, 26f});
        tabla.setSpacingBefore(14);
        tabla.setHeaderRows(1);

        PdfPCell cabecera = new PdfPCell(new Phrase(titulo, F_SECCION));
        cabecera.setColspan(4);
        cabecera.setBackgroundColor(AZUL);
        cabecera.setPadding(8);
        cabecera.setBorder(Rectangle.NO_BORDER);
        tabla.addCell(cabecera);

        for (String[] c : campos) {
            tabla.addCell(celda(c[0], F_ETIQUETA));
            tabla.addCell(celda(c[1], F_VALOR));
        }
        if (campos.size() % 2 != 0) {          // completa la última fila
            tabla.addCell(celda("", F_ETIQUETA));
            tabla.addCell(celda("", F_VALOR));
        }

        if (observaciones != null && !observaciones.isBlank()) {
            tabla.addCell(celda("OBSERVACIONES", F_ETIQUETA));
            PdfPCell obs = celda(observaciones.trim(), F_VALOR);
            obs.setColspan(3);
            tabla.addCell(obs);
        }
        return tabla;
    }

    /** Tabla de historial. Repite título y encabezados al cambiar de página. */
    private PdfPTable crearTablaRegistros(String titulo, String[] encabezados,
                                        float[] anchos, List<String[]> filas) throws DocumentException {
        PdfPTable tabla = new PdfPTable(encabezados.length);
        tabla.setWidthPercentage(100);
        tabla.setWidths(anchos);
        tabla.setSpacingBefore(14);
        tabla.setHeaderRows(2);

        PdfPCell cabecera = new PdfPCell(new Phrase(titulo, F_SECCION));
        cabecera.setColspan(encabezados.length);
        cabecera.setBackgroundColor(AZUL);
        cabecera.setPadding(8);
        cabecera.setBorder(Rectangle.NO_BORDER);
        tabla.addCell(cabecera);

        for (String h : encabezados) {
            PdfPCell c = celda(h, F_TABLA_ENC);
            c.setBackgroundColor(new Color(241, 245, 249));
            c.setPadding(4);
            tabla.addCell(c);
        }
        for (String[] fila : filas) {
            for (String valor : fila) {
                PdfPCell c = celda(valor, F_TABLA);
                c.setPadding(4);
                tabla.addCell(c);
            }
        }
        return tabla;
    }

    private String fecha(LocalDateTime f) {
        return f == null ? "—" : f.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

}