package ar.com.vates.clase1.Controller;

import ar.com.vates.clase1.Clases.Libro;
import ar.com.vates.clase1.Service.AutorService;
import ar.com.vates.clase1.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/reportes/")
public class ReportesController {


    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;

@GetMapping("ordenado")
public Collection<Libro> Ordenado() { return libroService.devolverOrdenadoTitulo();}


    @GetMapping("cantLibrosAutor/{id_autor}")
    public int cantLibrosAutor(@PathVariable int id_autor)
    {
        return autorService.cantLibrosAutor(id_autor);
    }


    @GetMapping("buscar")
    public Collection<Libro> buscarTitulo(@RequestBody String tituloBuscado){
    return libroService.buscarTitulo(tituloBuscado);
    }


    @GetMapping("librosAutor")
    public Collection<Libro> librosAutor (@RequestBody String nombreAutor){
    return autorService.librosDelAutor(nombreAutor);
    }


}
