package com.tuuniversidad.LIBRERIA.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tuuniversidad.LIBRERIA.models.Libro;

@Repository
public class LibroRepository {
    private List<Libro> libros = new ArrayList<>();

    public LibroRepository() {
        // Añadir algunos libros quemados
        //libros.add(new Libro(1 , "Cien años de soledad", "Gabriel García Márquez", "Bloomsbury Publishing Scholastic"));
        //libros.add(new Libro(2 , "En busca del tiempo perdido", "Marcel Proust","Editorial Planeta "));
        //libros.add(new Libro(3 ,  "Alicia en el país de las maravillas", "Lewis Carroll", "Jan Romein"));

        libros.add(new Libro(1L,"En busca del tiempo perdido","Marcel Proust", "Sudamericana",1913));
        libros.add(new Libro(1L,"Don Quijote de la Mancha","Miguel de Cervantes", "Francisco de Robles",1605));
        //libros.add(new Libro(1L, "Cien años de soledad", "Gabriel García Márquez", "Sudamericana", 1967));
        //libros.add(new Libro(2L, "Don Quijote de la Mancha", "Miguel de Cervantes", "Francisco de Robles", 1605));
        // Añadir más libros según sea necesario
    }

    public List<Libro> findAll() {
        return libros;
    }

    public Optional<Libro> findById(Long id) {
        return libros.stream().filter(libro -> libro.getId().equals(id)).findFirst();
    }

    public void save(Libro libro) {
        libros.add(libro);
    }

}
