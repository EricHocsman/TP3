package ar.com.vates.clase1.Service;

import ar.com.vates.clase1.Clases.Autor;
import ar.com.vates.clase1.Clases.Libro;
import ar.com.vates.clase1.Repository.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AutorService {


    @Autowired
    private AutorRepository aR;


    @Transactional
    public  boolean guardar(Autor p) {
        aR.save(p);
        return true;
    }
    public Autor buscar(int id) {
        return aR.findById(id).orElse(null);
    }
    public boolean existe(int id) {
        return aR.existsById(id);
    }

    public Autor borrar(int id) {
        Autor encontrada = buscar(id);
        if (encontrada != null)
            aR.deleteById(id);
        return encontrada;
    }
    public Collection<Autor> obtenerTodas() {return aR.findAll();}

    public int cantLibrosAutor (int idAutor)
    {
       return aR.getAutorByIdEquals(idAutor).getLibros().size();
    }

    public Collection <Libro> librosDelAutor (String Autor)
    {
       Autor autor= aR.getAutorByNombreEqualsIgnoreCase(Autor);
       return autor.getLibros();
    }










}
