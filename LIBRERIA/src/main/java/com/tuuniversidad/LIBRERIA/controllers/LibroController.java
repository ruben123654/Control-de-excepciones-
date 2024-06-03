package com.tuuniversidad.LIBRERIA.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuuniversidad.LIBRERIA.exceptions.LibroException;
import com.tuuniversidad.LIBRERIA.models.Libro;
import com.tuuniversidad.LIBRERIA.service.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.findAll();
    }

    @GetMapping("/id_libro")
    public ResponseEntity<Libro> getLibroById(@PathVariable("id_libro") Long id) {
        Optional<Libro> libro = libroService.findById(id);
        if (libro.isPresent()) {
            return new ResponseEntity<>(libro.get(), HttpStatus.OK);
        } else {
            throw new LibroException("Libro no encontrado con id: " + id);
        }
    }

     @PostMapping
    public ResponseEntity<Void> createLibro(@RequestBody Libro libro) {
        libroService.save(libro);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ExceptionHandler(LibroException.class)
    public ResponseEntity<String> handleLibroException(LibroException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /*@GetMapping("/{id_libro}")
    public Optional<Libro> getLibroById(@PathVariable("id_libro") Long id) {
        return libroService.findById(id);
    }*/
    /*@PostMapping
    public void createLibro(@RequestBody Libro libro) {
        libroService.save(libro);
    }*/





}
