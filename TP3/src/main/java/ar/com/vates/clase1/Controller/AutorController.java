package ar.com.vates.clase1.Controller;

import ar.com.vates.clase1.Clases.Autor;
import ar.com.vates.clase1.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/autor/")
public class AutorController {

    @Autowired
    private AutorService servicio;

    @GetMapping("")
    public Collection<Autor> obtenerTodas() {
        return servicio.obtenerTodas();
    }

    @GetMapping("{id}")
    public ResponseEntity<Autor> obtenerUna(@PathVariable int id) {
        Autor encontrada = servicio.buscar(id);
        if (encontrada != null)
            return ResponseEntity.ok(encontrada);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Autor> borrarUna(@PathVariable int id) {
        if (servicio.existe(id)) {
            return ResponseEntity.ok(servicio.borrar(id));
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity guardar(@PathVariable int id, @RequestBody Autor nueva) {
        if (nueva.getNombre() == null || nueva.getNombre().isBlank() || nueva.getId() < 0 ) {
            String mensaje = "Datos no válidos: ";
            if (nueva.getNombre() == null || nueva.getNombre().isBlank()) mensaje += "- El nombre es obligatorio";
            if (nueva.getId() < 0 ) mensaje += "El id no puede ser menor a 1";

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, mensaje);
        }

        nueva.setId(id);
        if (servicio.guardar(nueva)) // metodo guardar de la clase PersonasService
            return ResponseEntity.created(URI.create("/autor/" + id)).build();
        else
            return ResponseEntity.ok().build();

    }




}
