package com.iitca.tecnodesarrollo.controler;

import com.iitca.tecnodesarrollo.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/reportes")
public class ReporteControler {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/pozo/{id_lp}")
    public ResponseEntity<byte[]> descargarReportePozo(@PathVariable int id_lp) {
        byte[] pdfBytes = reporteService.generarReportePozo(id_lp);

        HttpHeaders headers = new HttpHeaders();
        // Le indicamos al navegador que es un documento PDF
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Forzamos la descarga con un nombre de archivo dinámico
        headers.setContentDispositionFormData("attachment", "Reporte_Pozo_" + id_lp + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}