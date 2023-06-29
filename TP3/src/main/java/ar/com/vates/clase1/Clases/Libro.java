package ar.com.vates.clase1.Clases;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {


    @ManyToOne()
    @JoinColumn(name = "id_autor")
    @JsonBackReference
    private Autor autor;

    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="titulo")
    private String nombreLibro;

    public Libro()
    {

    }

    public Libro(int id, String nombreLibro) {
        this.id = id;
        this.nombreLibro = nombreLibro;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return String.format("%d - %s - %d", id,nombreLibro);
    }
}
