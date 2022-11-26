package com.crud.repository;

import com.crud.model.Tracking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
@Repository
public interface TrackingRepository extends CrudRepository<Tracking, Integer>{
}
