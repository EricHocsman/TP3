package ar.com.vates.clase1.Service;


import ar.com.vates.clase1.Clases.Libro;
import ar.com.vates.clase1.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LibroService {
@Autowired
    //private LibroRepository lRepo;
    private LibroRepository lRepo;

    public boolean guardar(Libro l) {
        lRepo.save(l);
                        return true;
    }

    public Libro buscar(int id) {
        return lRepo.findById(id).orElse(null);

    }
    public boolean existe (int id) {
        return lRepo.existsById(id);
    }

    public Libro borrar(int id) {
        Libro encontrada = buscar(id);
        if (encontrada != null)
            lRepo.deleteById(id);
        return encontrada;
    }

    public Collection<Libro> obtenerTodas() {
        return lRepo.findAll();
    }

    public Collection<Libro> devolverOrdenadoTitulo(){
        return lRepo.getLibrosByOrderByNombreLibroAsc();
    }



    public Collection<Libro> buscarTitulo(String tituloBuscado)
    {
        return lRepo.getLibrosByNombreLibroEqualsIgnoreCaseOrderById(tituloBuscado);
    }


}
