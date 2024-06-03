package com.tuuniversidad.LIBRERIA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuuniversidad.LIBRERIA.models.Libro;
import com.tuuniversidad.LIBRERIA.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    public void save(Libro libro) {
        libroRepository.save(libro);
    }

}
