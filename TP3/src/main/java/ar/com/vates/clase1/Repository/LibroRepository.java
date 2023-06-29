package ar.com.vates.clase1.Repository;
import ar.com.vates.clase1.Clases.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface LibroRepository extends JpaRepository <Libro, Integer> {

    Collection<Libro> getLibrosByOrderByNombreLibroAsc();



    Collection<Libro> getLibrosByNombreLibroEqualsIgnoreCaseOrderById(String nombre);


}
