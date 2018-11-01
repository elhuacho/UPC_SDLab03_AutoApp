package com.curso.jpaDemo.repositorio;

import com.curso.jpaDemo.entidades.Auto;
import org.springframework.data.repository.CrudRepository;

public interface AutoRepositorio extends CrudRepository<Auto, Long> {
}
