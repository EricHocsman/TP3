package ar.com.vates.clase1.Clases;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.stream.Collectors;

@Entity @Table(name = "autores") // Nombre de la tabla en la base de datos
public class Autor {

    @Column(name="id")
    @Id
    private int id;
    @Column(name="nombre")
    private String nombre;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor")
    @JsonManagedReference
    private Collection<Libro> libros;

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Autor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return String.format("%d - %s - %d - (%s)", id, nombre, libros, libros.stream().map(Libro::toString).collect(Collectors.joining()));
    }
}
