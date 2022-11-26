package com.crud.repository;

import com.crud.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Integer> {
}
