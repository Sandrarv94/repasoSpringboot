package com.example.mercancia.controladores;

import com.example.mercancia.modelos.Mercancia;
import com.example.mercancia.servicios.MercanciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mercancia")
public class MercanciaControlador {
    @Autowired
    MercanciaServicio mercanciaServicio;

    @PostMapping
    public ResponseEntity<?> registrarMercancia(@RequestBody Mercancia datosMercancia){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.mercanciaServicio.registrarMercancia(datosMercancia));
        } catch(Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("{idMercancia}")
    public ResponseEntity<?> modificarMercancia(@RequestBody Mercancia datosNuevosMercancia, @PathVariable Integer idMercancia){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.mercanciaServicio.modificarMercancia(datosNuevosMercancia, idMercancia));
        } catch(Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("{idMercancia}")
    public ResponseEntity<?> buscarMercanciaPorId(@PathVariable Integer idMercancia){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.mercanciaServicio.buscarMercanciaPorId(idMercancia));
        } catch(Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodaLaMercancia(){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.mercanciaServicio.buscarTodaLaMercancia());
        } catch(Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("{idMercancia}")
    public ResponseEntity<?> eliminarMercancia(@PathVariable Integer idMercancia){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.mercanciaServicio.eliminarMercancia(idMercancia));
        } catch(Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
