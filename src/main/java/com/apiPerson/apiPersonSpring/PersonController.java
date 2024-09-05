package com.apiPerson.apiPersonSpring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/cliente")
    public ResponseEntity<Object> getClientInfo(
            @RequestParam String tipoDocumento,
            @RequestParam String numeroDocumento) {
        
        // Validación de tipo de documento
        if (!"C".equals(tipoDocumento) && !"P".equals(tipoDocumento)) {
            return new ResponseEntity<>("Tipo de documento inválido", HttpStatus.BAD_REQUEST);
        }
        
        // Validación de número de documento
        if (numeroDocumento == null || numeroDocumento.isEmpty()) {
            return new ResponseEntity<>("Número de documento es obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        // Datos mockeados para el cliente con cédula de ciudadanía 23445322
        if ("C".equals(tipoDocumento) && "23445322".equals(numeroDocumento)) {
            ClientInfo clientInfo = new ClientInfo(
                "Juan",
                "Carlos",
                "Gómez",
                "Pérez",
                "3001234567",
                "Calle 123",
                "Bogotá"
            );
            return new ResponseEntity<>(clientInfo, HttpStatus.OK);
        }
        
        // Si el cliente no es encontrado
        return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
    }
}
