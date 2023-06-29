package ar.com.vates.clase1.Controller;


import ar.com.vates.clase1.Clases.Libro;
import ar.com.vates.clase1.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/libros/")
public class LibroController {

@Autowired
    private LibroService lSer;

@GetMapping("")
    public Collection<Libro> obtenerTodos() { return lSer.obtenerTodas();}

@GetMapping("{id}")
public ResponseEntity<Libro> obtenerUna(@PathVariable int id) {
    Libro encontrada = lSer.buscar(id);
    if (encontrada != null)
        return ResponseEntity.ok(encontrada);
    else
        return ResponseEntity.notFound().build();
}

    @DeleteMapping("{id}")
    public ResponseEntity<Libro> borrarUna(@PathVariable int id) {
        if (lSer.existe(id)) {
            return ResponseEntity.ok(lSer.borrar(id));
        }
        else
            return ResponseEntity.notFound().build();
    }



    @PutMapping("{id}")
    public ResponseEntity guardar(@PathVariable int id, @RequestBody Libro nueva) {
        nueva.setId(id);
        if (lSer.guardar(nueva))
            return ResponseEntity.created(URI.create("/libro/" + id)).build();
        else
            return ResponseEntity.ok().build();

        /* {"nombreLibro": "Farenheit 456",
            "autor": {"id" : 3}  }
        */

    }


}
