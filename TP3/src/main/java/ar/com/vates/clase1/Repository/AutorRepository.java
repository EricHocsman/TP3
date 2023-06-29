package ar.com.vates.clase1.Repository;

import ar.com.vates.clase1.Clases.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor, Integer> {

    Autor getAutorByIdEquals(int id);
    Autor getAutorByNombreEqualsIgnoreCase(String nombre);


}
